package com.drivers.jdbc.sql;

import com.drivers.jdbc.annotations.Column;

import java.util.*;

/**
 * This is just a tool, not is a framework, do not compare with Hibernate,MyBatis,JPA or Querydsl etc.
 * If you need a more powerful persistence framework, Please help yourself。
 * <p/>
 * Update SQL builder
 *
 * @author Tietang Wang
 *         Created by MacBook Pro on 2014/12/26.
 */
public class Update extends AbstractSqlBuilder {


    private Map<String, Object> columnValues = new HashMap<>();
    private Map<String, Object> columnFunctionValues = new HashMap<>();
    private Map<String, SubItem> columnSubSQLValues = new HashMap<>();

    private String where = "";
    private List<Object> whereParams = new ArrayList<>();
    private boolean isFilterNull = false;
    private boolean isGenerated = false;
    private String sql;
    private List<Object> params = new ArrayList<>();

    /**
     * 通过表名构造
     *
     * @param tableName
     */
    public Update(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 通过一个not null java bean构造
     *
     * @param entity
     */
    public Update(Object entity) {
        init(entity, false);
    }

    /**
     * 通过一个not null java bean和可选参数isFilterNull构造
     *
     * @param entity
     */
    public Update(Object entity, Object persistedEntity) {
        init(entity, true);
    }

    public Update(Object entity, boolean isFilterNull) {
        init(entity, isFilterNull);
    }

    /**
     * 通过表名和可选参数isFilterNull构造
     *
     * @param tableName    表名
     * @param isFilterNull 是否过滤null值
     */
    public Update(String tableName, boolean isFilterNull) {
        this.tableName = tableName;
        this.isFilterNull = isFilterNull;
    }

    protected void firstRemove(String columnName) {
        columnValues.remove(columnName);
        columnFunctionValues.remove(columnName);
        columnSubSQLValues.remove(columnName);
    }

    /**
     * 添加列及值到 SQL中
     *
     * @param columnName   实体属性注解的列名
     * @param value        实体属性值
     * @param isFilterNull 是否过滤null值
     */
    public void add(String columnName, Object value, boolean isFilterNull) {
        if (isFilterNull && value == null) {
            return;
        }
        firstRemove(columnName);
        columnValues.put(columnName, value);

    }

    public void addWithDefaultValue(String columnName, Object value, String defaultValue) {
        if (value == null) {
            addValue(columnName, defaultValue);
        } else {
            add(columnName, value, true);
        }
    }

    /**
     * 添加列及值到  SQL中
     *
     * @param columnName 实体属性注解的列名
     * @param value      实体属性值
     */
    public void add(String columnName, Object value) {
        add(columnName, value, isFilterNull);
    }

    /**
     * 添加一个SQL 数据库平台函数到 SQL中
     * <pre>
     * 例如：
     * <code>
     * addValue("time","now()")
     * insert into tablex(time) values(now())
     * </code>
     * </pre>
     *
     * @param columnName
     * @param value
     */
    public void addValue(String columnName, String value) {
        if (isFilterNull && value == null) {
            return;
        }
        firstRemove(columnName);

        columnFunctionValues.put(columnName, value);

    }

    /**
     * 添加一个子SQL 到  SQL中
     * <pre>
     * 例如：
     * <code>
     * addValue("time","select now()")
     * insert into tablex(time) values(select now())
     * </code>
     * </pre>
     *
     * @param columnName
     * @param subSQL
     * @param isFilterNull
     * @param values
     */
    public void addSubsql(String columnName, String subSQL, boolean isFilterNull, Object... values) {
        if (isFilterNull && (values == null || values.length == 0)) {
            return;
        }
        firstRemove(columnName);
        columnSubSQLValues.put(columnName, new SubItem(columnName, subSQL, values));

    }

    /**
     * 添加一个子SQL 到insert SQL中
     * <pre>
     * 例如：
     * <code>
     * addValue("time","select now()")
     * insert into tablex(time) values(select now())
     * </code>
     * </pre>
     *
     * @param columnName
     * @param subSQL
     * @param values
     */

    public void addSubsql(String columnName, String subSQL, Object... values) {
        firstRemove(columnName);
        columnSubSQLValues.put(columnName, new SubItem(columnName, subSQL, values));
    }

    /**
     * 设置where条件
     *
     * @param where
     * @param params
     */
    public void setWhere(String where, Object... params) {
        this.where = where;
        this.whereParams = Arrays.asList(params);
    }


    /**
     * 添加逗号
     */
    private void addComma(StringBuilder settings) {
        if (settings.length() > 0) {
            settings.append(", ");
        }
    }

    /**
     * 创建 SQL
     */
    public void generate() {
        params = new ArrayList<>();
        StringBuilder settings = new StringBuilder();
        for (Map.Entry<String, Object> entry : columnValues.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();
            addComma(settings);
            settings.append(columnName).append("=? ");
            params.add(value);
        }
        for (Map.Entry<String, Object> entry : columnFunctionValues.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();
            addComma(settings);
            settings.append(columnName).append("= " + value);
        }
        for (Map.Entry<String, SubItem> entry : columnSubSQLValues.entrySet()) {
            String columnName = entry.getKey();
            SubItem item = entry.getValue();
            addComma(settings);
            settings.append(columnName).append("= ");
            settings.append("(").append(item.subSQL).append(")");
            if (item.values != null) for (Object value : item.values) {
                params.add(value);
            }
        }
        //防止不设置where，出现更新全表的问题
        if (null == where || "".equals(where.trim())) throw new IllegalStateException("Can't set where cause.");
        sql = String.format(UPDATE, tableName, settings.toString(), where);
        params.addAll(whereParams);
        isGenerated = true;
    }

    /**
     * update 语句
     *
     * @return
     */
    public String toSQL() {
        if (!isGenerated) generate();
        return sql;
    }

    /**
     * 参数
     *
     * @return
     */

    public Object[] getParams() {
        if (!isGenerated) generate();
        return params.toArray();
    }

    /**
     * 参数
     *
     * @return
     */
    public List<Object> getParamList() {
        if (!isGenerated) generate();
        return params;
    }


    public void setFilterNull(boolean isFilterNull) {
        this.isFilterNull = isFilterNull;
    }

    @Override
    protected boolean isAvailable(Column column) {
        return column.updatable();
    }

    final static String UPDATE = "update %s set %s where %s";

    private static class SubItem {

        public String columnName;
        public String subSQL;
        public Object[] values;

        public SubItem(String columnName, String subSQL, Object[] values) {
            this.columnName = columnName;
            this.subSQL = subSQL;
            this.values = values;
        }
    }

    /**
     * 移除列，不insert
     *
     * @param columnName
     */
    public void remove(String columnName) {
        columnValues.remove(columnName);
        columnFunctionValues.remove(columnName);
        columnSubSQLValues.remove(columnName);
    }

    //
    //    public static void main(String[] args) {
    //
    //        Update update = new Update("user", true);
    //        update.add("x1", null);
    //        update.add("x2", 45);
    //        update.add("x3", "rewrw");
    //        update.addValue("x2", "NOW()");
    //        update.addSubsql("sebsql", "select 1");
    //        update.addSubsql("x3", "select 1 from x>? and y>?", 1, "xc");
    //        update.setWhere(" x=?", 2);
    //        System.out.println(update.toSQL());
    //        System.out.println(update.getParamList());
    //    }

}
