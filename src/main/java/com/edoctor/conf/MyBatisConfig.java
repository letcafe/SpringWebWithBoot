package com.edoctor.conf;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置说明：
 * 1.在api中编写转发逻辑，以及简单的处理
 * 2.在Service层中，调用相关操作的服务方法
 * 3.在Dao中定义接口以及附带上SQL语句，不需要DAO层的实现（类似但不等于JPA）
 */
@Configuration
@MapperScan("com.edoctor.dao")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //配置注入的数据源
        sessionFactoryBean.setDataSource(dataSource);
        //配置实体类所在的包
        sessionFactoryBean.setTypeAliasesPackage("com.edoctor.bean");
        //配置驼峰命名与下划线映射（数据库：下划线,实体：驼峰）
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactoryBean.setConfiguration(configuration);

        return sessionFactoryBean;
    }

}
