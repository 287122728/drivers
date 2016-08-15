package com.drivers.jdbc.sql;

import com.drivers.jdbc.annotations.Column;
import com.drivers.jdbc.annotations.Id;
import com.drivers.jdbc.annotations.TableEntity;
import com.drivers.jdbc.annotations.Transient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * This is just a tool, not is a framework, do not compare with Hibernate,MyBatis,JPA or Querydsl etc.
 * If you need a more powerful persistence framework, Please help yourself。
 * Base SQL builder
 *
 * @author Tietang Wang
 *         Created by MacBook Pro on 2014/12/26.
 */
public abstract class AbstractSqlBuilder {

    static Logger logger = LoggerFactory.getLogger(AbstractSqlBuilder.class);
    protected String tableName;

	/**
     * 添加一个注解列和列值
     *
     * @param columnName   实体属性注解的列名
     * @param value        实体属性值
     * @param isFilterNull 是否过滤null值
     */
    public abstract void add(String columnName, Object value, boolean isFilterNull);

    /**
     * 是否过滤不处理主键列
     *
     * @return
     */
    public boolean isFilterPk() {
        return true;
    }

    /**
     * 熟悉mapping
     */
    protected static class Property {

        public String fieldName;
        public Field field;
        public Method readMethod;
    }

    /**
     * 表名
     *
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 初始化bean实例注解metadata
     *
     * @param entity       bean实例
     * @param isFilterNull 是否过滤null值属性
     */
    public void init(Object entity, boolean isFilterNull) {
        Class<?> entityClass = entity.getClass();
        init(entityClass, entity, null, isFilterNull);

    }

    /**
     * 初始化bean实例注解metadata
     *
     * @param entityClass     实体类class
     * @param entity          实体类实例
     * @param persistedEntity 已经持久化的数据实体
     * @param isFilterNull    是否过滤null值属性
     */
    public void init(Class<?> entityClass, Object entity, Object persistedEntity, boolean isFilterNull) {
        //表名注解
        TableEntity tableEntity = entityClass.getAnnotation(TableEntity.class);
        this.tableName = tableEntity == null ? entityClass.getSimpleName() : tableEntity.value();
        //读取属性描述
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(entityClass);
        for (PropertyDescriptor pd : pds) {
            if (pd.getWriteMethod() != null) {

                Property property = new Property();
                property.fieldName = pd.getName();
                property.readMethod = pd.getReadMethod();
                //计算列名
                String columnName = columnName(entityClass, property);
                if (columnName == null) continue;
                //计算列名
                columnName = columnName(property, columnName);
                if (columnName == null) continue;
                try {
                    //读取值
                    property.field.setAccessible(true);
                    Object value = null;
                    if (entity != null) {
                        value = property.field.get(entity);
                    }
                    Object persistedValue = null;
                    if (persistedEntity != null) {
                        persistedValue = property.field.get(persistedEntity);
                    }
                    //                    Object value = pd.getReadMethod().invoke(entity, new Object());
                    if (persistedValue != null && persistedEntity.equals(value)) continue;
//                    System.err.println(columnName);
                    this.add(columnName, value, isFilterNull);
                } catch (Exception e) {
                    logger.warn(e.getMessage());
                }
            }
        }

    }

    /**
     * 计算列名
     *
     * @param column       列注解
     * @param defaultValue 默认值
     * @return mapping列名
     */

    protected String columnName(Column column, String defaultValue) {
        String columnName = defaultValue;
        if (column == null) return columnName;
        if (!isAvailable(column)) return null;
        if (column.value() == null || "".equals(column.value().trim())) return columnName;
        columnName = column.value();
        return columnName;
    }

    /**
     * 计算列名
     *
     * @param property     列注解属性
     * @param defaultValue 默认值
     * @return mapping列名
     */
    protected String columnName(Property property, String defaultValue) {
        Method method = property.readMethod;
        java.beans.Transient aTransient = method.getAnnotation(java.beans.Transient.class);
        if (aTransient != null) return null;
        if (isFilterPk()) {
            Id id = method.getAnnotation(Id.class);
            if (id != null) return null;
        }
        Column column = method.getAnnotation(Column.class);
        return columnName(column, defaultValue);
    }

    /**
     * 计算列名
     *
     * @param entityClass 实体class
     * @param property    列注解属性
     * @return mapping列名
     */
    protected String columnName(Class<?> entityClass, Property property) {
        String fieldName = property.fieldName;
        try {
            property.field = entityClass.getDeclaredField(fieldName);
            Transient t = property.field.getAnnotation(Transient.class);
            if (t != null) return null;
            if (isFilterPk()) {
                Id id = property.field.getAnnotation(Id.class);
                if (id != null) return null;
            }
            Column column = property.field.getAnnotation(Column.class);
            return columnName(column, fieldName);

        } catch (NoSuchFieldException e) {
            logger.warn(e.getMessage());
        }
        return fieldName;
    }

    /**
     * 该列注解是否可用
     *
     * @param column 列注解
     * @return
     */
    protected abstract boolean isAvailable(Column column);
}
