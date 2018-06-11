package com.edoctor.conf;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.edoctor.dao.repository")//此处传入继承MongoRepository<xx,xx>的实现类/接口包
public class MongoConf extends AbstractMongoConfiguration{
    @Override
    protected String getDatabaseName() {
        return "EDoctor";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("59.110.231.87");
    }
}
