package com.sdu.spittr.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by J on 2017/3/14.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.sdu.spittr.dao")
public class MongoConfig {

    @Bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("192.168.9.194");
        mongo.setPort(27017);
        return mongo;
    }


    @Bean
    public MongoOperations mongoTemplate(Mongo mongo){
        return new MongoTemplate(mongo,"test");
    }
}
