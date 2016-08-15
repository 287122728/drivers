package com.drivers.jdbc;

/**
 * 通过线程本地变量存取当前使用的数据源名称
 *
 * @author shuwei
 * @version 1.0
 * @date 2015/5/11 10:04
 */
public class JdbcContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public enum JdbcType {
        Read("readDataSource"),
        Write("writeDataSource");
        String name;

        JdbcType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void setJdbcType(String jdbcType) {
        contextHolder.set(jdbcType);
//        System.out.println("set dataSource : " + jdbcType);
    }

    public static void setReadOnly() {
        contextHolder.set(JdbcType.Read.getName());
//        System.out.println("set dataSource : " + JdbcType.Read.getName());
    }

    public static void setWriteRead() {
        contextHolder.set(JdbcType.Write.getName());
    }

    public static void reset() {
        contextHolder.set(JdbcType.Write.getName());
//        System.out.println("reset dataSource to writeDataSource");
    }

    public static String getJdbcType() {
        return contextHolder.get();
    }

    /**
     * 恢复成默认的数据源，即defaultTargetDataSource，执行此方法
     */
    public static void clearJdbcType() {
        contextHolder.remove();
//        System.out.println("clear dataSource to writeDataSource");
    }
}
