package com.health.gymnasium.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ConnectionTest implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {

        String dbName = mongoTemplate.getDb().getName();
        System.out.println("Connected to Database "+ dbName);

        Set<String> collections = mongoTemplate.getDb().listCollectionNames().into(new HashSet<>());

        System.out.println("collections list "+collections);


    }
}
