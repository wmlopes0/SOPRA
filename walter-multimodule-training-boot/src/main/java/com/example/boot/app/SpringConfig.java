package com.example.boot.app;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.infrastructure.repository")
@ComponentScan(basePackages = {
    "com.example.boot",
    "com.example.contract",
    "com.example.application",
    "com.example.domain",
    "com.example.infrastructure"})
@EntityScan("com.example.infrastructure.entity")
public class SpringConfig {

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group("springdoc")
        .packagesToScan("com.example.contract.employee.controller")
        .build();
  }
}