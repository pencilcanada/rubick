package com.pencilcanada.rubick;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Configuration
@EnableReactiveMongoRepositories
public class AppConfig extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    String mongoUri;

    @Override
    protected String getDatabaseName() {
        return "rubick";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        try {
            return MongoClients.create(URLDecoder.decode(mongoUri,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
