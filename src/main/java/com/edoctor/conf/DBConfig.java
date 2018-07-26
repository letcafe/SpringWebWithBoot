package com.edoctor.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Profile("test")
    @Bean
    public DataSource mysqlDataSourceTest() {
        BasicDataSource ds = new BasicDataSource();
        ds.setMaxIdle(6);
        ds.setMinIdle(4);
        ds.setInitialSize(10);
        ds.setDefaultAutoCommit(true);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/alipay?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }

    //DB config
    //MySQL ConnectionFactory
    @Profile("development")
    @Bean
    public DataSource mysqlDataSourceDevelopment() {
        BasicDataSource ds = new BasicDataSource();
        ds.setMaxIdle(6);
        ds.setMinIdle(4);
        ds.setInitialSize(10);
        ds.setDefaultAutoCommit(true);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/edoctor?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("name1");
        ds.setPassword("password1");
        return ds;
    }

    @Profile("production")
    @Bean
    public DataSource mysqlDataSourceProduction() {
        BasicDataSource ds = new BasicDataSource();
        ds.setMaxIdle(6);
        ds.setMinIdle(4);
        ds.setInitialSize(10);
        ds.setDefaultAutoCommit(true);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/edoctor?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("name2");
        ds.setPassword("password2");
        return ds;
    }


}
