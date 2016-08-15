package com.drivers.jdbc.sql;

import com.drivers.jdbc.annotations.Column;
import com.drivers.jdbc.annotations.Id;
import com.drivers.jdbc.annotations.TableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is just a tool, not is a framework, do not compare with Hibernate,MyBatis,JPA or Querydsl etc.
 * If you need a more powerful persistence framework, Please help yourself。
 *
 * Select SQL builder
 *
 * @author Tietang Wang
 *         Created by MacBook Pro on 2014/12/26.
 */
public class Select extends AbstractSqlBuilder {

    static Logger logger = LoggerFactory.getLogger(Select.class);
    private List<String> columns = new ArrayList<>();
    private StringBuilder clauseBuffer = new StringBuilder();
    private List<Object> params = new ArrayList<>();
    private boolean isGenerated = false;
    private String sql;
    static Map<Class, String> baseSqlCache = new ConcurrentHashMap<>();
    private String baseSql;


    public Select(Class<?> entityClass) {
        baseSql = baseSqlCache.get(entityClass);
        if (baseSql == null) {
            super.init(entityClass, null, null, false);
        }
    }

    @Override
    public boolean isFilterPk() {
        return false;
    }

    @Override
    public void add(String columnName, Object value, boolean isFilterNull) {
        columns.add(columnName);
    }

    public void addColumn(String columnName) {
        columns.add(columnName);
    }

    public void removeColumn(String columnName) {
        columns.remove(columnName);
    }

    private void addComma(StringBuilder columns) {
        if (columns.length() > 0) {
            columns.append(",");
        }
    }

    public Select andClauses(String clause, Object... params) {
        and(clause);
        for (int i = 0; i < params.length; i++) {

            if (params[i] == null) logger.warn("The param is null for params index:" + i);
            this.params.add(params[i]);
        }
        return this;
    }

    public Select and(String clause) {
        clauseBuffer.append(" and ");
        clauseBuffer.append(clause);
        return this;
    }

    public Select and(String clause, Object param, boolean isAppend) {
        if (!isAppend) return this;
        and(clause);
        params.add(param);
        return this;
    }

    public Select and(String clause, Object param) {
        if (param == null) return this;
        and(clause, param, true);
        return this;
    }

    public Select appendClauses(String clause, Object... params) {
        append(clause);
        for (int i = 0; i < params.length; i++) {
            if (params[i] == null) logger.warn("The param is null for params index:" + i);
            this.params.add(params[i]);
        }
        return this;
    }

    public Select append(String clause) {
        clauseBuffer.append(" ");
        clauseBuffer.append(clause);
        return this;
    }

    public Select append(String clause, Object param, boolean isAppend) {
        if (!isAppend) return this;
        and(clause);
        params.add(param);
        return this;
    }

    public Select append(String clause, Object param) {
        if (param == null) return this;
        and(clause, param, true);
        return this;
    }

    public String getSQL() {
        if (!isGenerated) generate();
        return sql;
    }

    public void generate() {
        StringBuilder sqlStr = new StringBuilder();

        if (baseSql == null) {
            StringBuilder columnsStr = new StringBuilder();
            for (Object column : columns) {
                addComma(columnsStr);
                columnsStr.append(column);
            }

            sqlStr.append("select ");
            sqlStr.append(columnsStr);
            sqlStr.append(" from ").append(tableName);
        } else {
            sqlStr.append(baseSql);
        }

        if (clauseBuffer.length() > 0) {
            int index = clauseBuffer.indexOf("and");
            sqlStr.append(" where ").append(clauseBuffer.substring(index + 4));
        }

        sql = sqlStr.toString();
        isGenerated = true;
    }

    public Object[] getParams() {
        if (!isGenerated) generate();
        return params.toArray();
    }

    public List<Object> getParamList() {
        if (!isGenerated) generate();
        return params;
    }

    public String toSQL(String... clauses) {
        StringBuilder sqlStr = new StringBuilder();

        if (baseSql == null) {
            StringBuilder columnsStr = new StringBuilder();
            for (Object column : columns) {
                addComma(columnsStr);
                columnsStr.append(column);
            }

            sqlStr.append("select ");
            sqlStr.append(columnsStr);
            sqlStr.append(" from ").append(tableName);
        } else {
            sqlStr.append(baseSql);
        }

        if (clauses != null) for (String clause : clauses) {
            if (clause != null) sqlStr.append(" ").append(clause);
        }

        return sqlStr.toString();

    }


    @Override
    protected boolean isAvailable(Column column) {
        return true;
    }

    public static void main(String[] args) {
        @TableEntity("S_USER")
        class User {

            @Id
            private Long pk;
            @Column("user_id")
            private Long id;
            private String name;
            @Column("c_age")
            private int age;

            public Long getPk() {
                return pk;
            }

            public void setPk(Long pk) {
                this.pk = pk;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
        Select select = new Select(User.class);
        System.out.println(select.toSQL());
        System.out.println(select.toSQL("where id=?"));
        User user = new User();
        user.setName("dd");
        Insert insert = new Insert(new User());
        System.out.println(insert.toSQL());


    }
}

