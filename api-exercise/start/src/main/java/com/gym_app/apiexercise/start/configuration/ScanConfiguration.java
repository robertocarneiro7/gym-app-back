package com.gym_app.apiexercise.start.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = {
        "com.gym_app.apiexercise.api",
        "com.gym_app.apiexercise.application",
        "com.gym_app.apiexercise.infrastructure"
})
@EnableMongoRepositories(basePackages = "com.gym_app.apiexercise.infrastructure")
@EnableMongoAuditing
public class ScanConfiguration {
}
