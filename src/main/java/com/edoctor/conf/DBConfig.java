package com.edoctor.conf;

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
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/edoctor?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("123456");
        return ds;
    }

    //DB config
    //MySQL ConnectionFactory
    @Profile("development")
    @Bean
    public DataSource mysqlDataSourceDevelopment() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://ip:port/edoctor?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("name");
        ds.setPassword("password");
        return ds;
    }

    @Profile("production")
    @Bean
    public DataSource mysqlDataSourceProduction() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://ip:port/edoctor?serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8");
        ds.setUsername("name2");
        ds.setPassword("password2");
        return ds;
    }


}