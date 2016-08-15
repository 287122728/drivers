package com.drivers.jdbc;


import com.drivers.jdbc.sql.BatchInsert4Entity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Service基类.
 * <p/>
 * 接受DataSource注入,封装SimpleJdbcTemplate及一些简便操作.
 */
public class SimpleJdbcSupport {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected JdbcTemplateExt jdbcTemplate;
    public static final String SEPARATOR = ",";

    @Autowired
    public void init(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplateExt(dataSource);
    }

    public JdbcTemplateExt getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * 简化将ResultSet反射到Bean的定义.
     */
    public static <S> RowMapper<S> resultBeanMapper(Class<S> clazz) {
        return ClassPropertyRowMapper.newInstance(clazz);
    }

    /**
     * 简化将ResultSet反射到Bean的定义.
     */
    public static <S> RowMapper<S> newAnnotationRowMapper(Class<S> clazz) {
        return AnnotationRowMapper.newInstance(clazz);
    }

    /**
     * 简化将Bean反射到SQL参数的定义.
     */
    public BeanPropertySqlParameterSource paramBeanMapper(Object object) {
        return new BeanPropertySqlParameterSource(object);
    }

    /**
     * 批量添加
     *
     * @param data 批量插入的数据
     * @param <T>  数据泛型类型
     * @return sql执行后的条数
     */
    public <T> int[] batchSave(List<T> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        BatchInsert4Entity<T> bi = new BatchInsert4Entity<>(data);
        String sql = bi.toSql();
        List<Object[]> paramList = bi.getParamList(data);
        for (Object[] params : paramList) {
            printSqlLog(sql, params);
        }

        return getJdbcTemplate().batchUpdate(sql, paramList);
    }

    /**
     * 保存数据,返回数据库自增的主键ID
     *
     * @param insertSql 插入sql
     * @return 插入记录的主键值
     * @throws Exception
     */
    public long save(final String insertSql, final Object[] args) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                if (args != null && args.length > 0) {
                    for (int i = 1; i <= args.length; i++) {
                        ps.setObject(i, args[i - 1]);
                    }
                }
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    /**
     * 拼接修改SQL语句(不支持无更新条件的全表跟新)
     *
     * @param tabName        表名
     * @param columnArr      操作的列名集合
     * @param whereColumnArr 查询条件列名集合
     * @return
     */
    public String spellUpdateSql(String tabName, Object[] columnArr, Object[] whereColumnArr) throws Exception {
        // 非空校验
        if (StringUtils.isBlank(tabName)) {
            return null;
        }
        if (columnArr == null || columnArr.length == 0) {
            return null;
        }
        if (whereColumnArr == null || whereColumnArr.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" update ").append(tabName).append(" set ");
        for (Object arr : columnArr) {
            sb.append(arr).append(" = ?").append(SEPARATOR);
        }
        String beforeSql = "";
        if (sb.toString().endsWith(SEPARATOR)) {
            beforeSql = sb.substring(0, sb.toString().lastIndexOf(SEPARATOR));
        }

        StringBuilder where = new StringBuilder();
        where.append(" where 1=1 ");
        for (Object arr : whereColumnArr) {
            where.append(" and ").append(arr).append(" = ?");
        }

        return beforeSql + where.toString();
    }

    public Object[] listToStringArr(List<Object> list) {
        Object[] params = null;
        if (list != null && !list.isEmpty()) {
            params = new Object[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj != null && !obj.equals("")) {
                    params[i] = obj;
                } else {
                    params[i] = null;
                }
            }
        }
        return params;
    }

    /**
     * 根据唯一标识查询记录的时间戳(10位)
     *
     * @param tableName 表名称
     * @param field     字段名称
     * @param value     字段值
     * @return 时间戳
     */
    public String getModifyTime(String tableName, String field, String value) {
        String sql = "select UNIX_TIMESTAMP(modifyDateTime) as lastSyncMarker from " + tableName + " where " + field + " = '" + value + "'";
        logger.info("根据唯一标识查询表的修改时间:" + sql);
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return rs.getString("lastSyncMarker");
        });
    }

    /**
     * sql日志打印
     * <p>
     * 2015-1-26 上午9:35:45 edit by Liangbin
     *
     * @param sql
     * @param args
     */
    protected void printSqlLog(String sql, Object... args) {
        try {
            if (args != null) {
                for (Object object : args) {
                    if (object == null) {
                        sql = StringUtils.replace(sql, "?", object + "", 1);
                        continue;
                    }
                    Class<?> clazz = object.getClass();
                    if (clazz.isPrimitive() || "Long".equals(clazz.getSimpleName()) || "Integer".equals(clazz.getSimpleName())) {
                        sql = StringUtils.replace(sql, "?", object + "", 1);
                        continue;
                    }
                    sql = StringUtils.replace(sql, "?", "'" + object + "'", 1);
                }
            }
            logger.info("执行sql：" + sql);
        } catch (Exception e) {
            logger.error("执行sql异常，sql={}" + e.getLocalizedMessage(), sql, e);
        }
    }

    /**
     * 生成sql批量条件 问号 如： ?,?,?,?
     *
     * @param count 数量
     * @return 多个问号使用逗号连接起来的字符串
     */
    protected String createQuestionMark(int count) {
        String[] paramKeys = new String[count];
        for (int i = 0; i < paramKeys.length; i++) {
            paramKeys[i] = "?";
        }
        return StringUtils.join(paramKeys, SEPARATOR);
    }
}
