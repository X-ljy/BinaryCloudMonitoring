package com.binary.servermonitor.data_collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.binary.servermonitor.data_collection.dao")
public class DatacollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatacollectionApplication.class, args);
    }

}
