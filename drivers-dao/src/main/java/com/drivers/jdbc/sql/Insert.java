package com.drivers.jdbc.sql;


import com.drivers.jdbc.annotations.Column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is just a tool, not is a framework, do not compare with Hibernate,MyBatis,JPA or Querydsl etc.
 * If you need a more powerful persistence framework, Please help yourself。
 * <p/>
 * Insert SQL build:
 * <p/>
 * <pre>
 *     Example:
 * Insert insert = new Insert("user", true);
 * insert.add("x1", null);
 * insert.add("x2", 45);
 * insert.add("x3", "rewrw");
 * insert.addValue("x2", "NOW()");
 * insert.addSubSql("sebsql", "select 1");
 * insert.addSubSql("x3", "select 1 from x>? and y>?", 1, "xc");
 * String sql=insert.toSQL();
 * Object[] params=insert.getParams();
 * List<Object> paramList=insert.getParamList();
 * System.out.println(insert.toSQL());
 * System.out.println(insert.getParamList());
 *
 *
 * </pre>
 *
 * @author Tietang Wang
 *         Created by MacBook Pro on 2014/12/26.
 */
public class Insert extends AbstractSqlBuilder {


    private Map<String, Object> columnValues = new HashMap<>();
    private Map<String, Object> columnFunctionValues = new HashMap<>();
    private Map<String, SubItem> columnSubSQLValues = new HashMap<>();


    private boolean isFilterNull = false;
    private boolean isGenerated = false;
    private String sql;
    private List<Object> params = new ArrayList<>();

    /**
     * 通过表名构造
     *
     * @param tableName
     */
    public Insert(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 通过一个not null java bean构造
     *
     * @param entity
     */
    public Insert(Object entity) {
        init(entity, true);
    }

    /**
     * 通过一个not null java bean和可选参数isFilterNull构造
     *
     * @param entity
     */
    public Insert(Object entity, boolean isFilterNull) {
        init(entity, isFilterNull);
    }

    /**
     * 通过表名和可选参数isFilterNull构造
     *
     * @param tableName    表名
     * @param isFilterNull 是否过滤null值
     */
    public Insert(String tableName, boolean isFilterNull) {
        this.tableName = tableName;
        this.isFilterNull = isFilterNull;
    }

    protected void firstRemove(String columnName) {
        columnValues.remove(columnName);
        columnFunctionValues.remove(columnName);
        columnSubSQLValues.remove(columnName);
    }

    /**
     * 添加列及值到insert SQL中
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

    /**
     * 添加列及值到insert SQL中
     *
     * @param columnName 实体属性注解的列名
     * @param value      实体属性值
     */
    public void add(String columnName, Object value) {
        add(columnName, value, isFilterNull);
    }

    /**
     * 用默认值添加列及值到insert SQL中
     *
     * @param columnName
     * @param value
     * @param defaultValue
     */
    public void addWithDefaultValue(String columnName, Object value, String defaultValue) {
        if (value == null) {
            addValue(columnName, defaultValue);
        } else {
            add(columnName, value, true);
        }
    }

    /**
     * 添加一个SQL 数据库平台函数到insert SQL中
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
     * @param isFilterNull
     * @param values
     */
    public void addSubSql(String columnName, String subSQL, boolean isFilterNull, Object... values) {
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
    public void addSubSql(String columnName, String subSQL, Object... values) {
        firstRemove(columnName);
        columnSubSQLValues.put(columnName, new SubItem(columnName, subSQL, values));
    }

    /**
     * 添加逗号
     *
     * @param columns
     * @param placeholders
     */
    private void addComma(StringBuilder columns, StringBuilder placeholders) {
        if (columns.length() > 0) {
            columns.append(", ");
            placeholders.append(", ");
        }
    }

    /**
     * 创建insert SQL
     */
    public void generate() {
        params = new ArrayList<>();
        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        //生成列和值部分

        for (Map.Entry<String, Object> entry : columnValues.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();
            addComma(columns, placeholders);
            columns.append(columnName);
            placeholders.append("?");
            params.add(value);
        }
        //生成列和函数
        for (Map.Entry<String, Object> entry : columnFunctionValues.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();
            addComma(columns, placeholders);
            columns.append(columnName);
            placeholders.append(value);
        }
        //生成列和子sql
        for (Map.Entry<String, SubItem> entry : columnSubSQLValues.entrySet()) {
            String columnName = entry.getKey();
            SubItem item = entry.getValue();
            addComma(columns, placeholders);
            columns.append(columnName);

            placeholders.append("(");
            placeholders.append(item.subSQL);
            placeholders.append(")");


            if (item.values != null) for (Object value : item.values) {
                params.add(value);
            }
        }
        isGenerated = true;
        sql = String.format(INSERT, tableName, columns, placeholders);
    }

    /**
     * insert 语句
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

    @Override
    protected boolean isAvailable(Column column) {
        return column.insertable();
    }

    final static String INSERT = "insert into %s(%s) values(%s)";

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

    //    public static void main(String[] args) {
    //        Insert insert = new Insert("user", true);
    //        insert.add("x2", 45);
    //        insert.add("x3", "rewrw");
    //        insert.addWithDefaultValue("x2", null, "NOW()");
    //        insert.addWithDefaultValue("x3", null, "NOW()");
    //        insert.addSubSql("sebsql", "select 1");
    //        insert.addSubSql("x3", "select 1 from x>? and y>?", 1, "xc");
    //        System.out.println(insert.toSQL());
    //        System.out.println(insert.getParamList());
    //    }

}
