package com.tinmegali.springdatamongodbmultitenant.config.data;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

/**
 * MongoDB configuration.
 * Uses MultiTenantMongoDbFactory, that fetches the appropriate tenant database.
 * @see MultiTenantMongoDbFactory
 */
@Configuration
public class MongoDbConfiguration {

    @Bean
    @Primary
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://localhost:27017/demo");
        return new MultiTenantMongoDbFactory(mongoClientURI);
    }

    @Bean
    @Primary
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }
}
