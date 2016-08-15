package com.drivers.manager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.drivers.jdbc.JdbcTemplateExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/7/22
 */
@Configuration
@EnableJpaRepositories("com.drivers.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
    @Value("${spring.datasource.name}")
    private String name;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private String filters = "stat";
    @Value("${spring.datasource.max-active}")
    private int maxActive;
    @Value("${spring.datasource.min-idle:8}")
    private int initialSize;
    @Value("${spring.datasource.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.datasource.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;
    //	@Value("${}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validation-query:SELECT 'x'}")
    private String validationQuery;
    private boolean testWhileIdle = true;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private boolean poolPreparedStatements = true;
    private int maxOpenPreparedStatements = 20;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(name);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setFilters(filters);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWaitMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        return dataSource;
    }
    @Bean
    public JdbcTemplateExt jdbcTemplateExt() throws SQLException {
        return  new JdbcTemplateExt(dataSource());
    }
    /**
     * 配置StatViewServlet
     * 		Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
     * 		这个StatViewServlet的用途包括：
     	 * 		提供监控信息展示的html页面
     	 * 		提供监控信息的JSON API
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new StatViewServlet());
        registration.addUrlMappings("/druid/*");
        registration.addInitParameter("resetEnable", "true");//允许清空统计数据
        registration.addInitParameter("loginUsername", "druid");//用户名
        registration.addInitParameter("loginPassword", "druid");//密码
        return registration;
    }
}
