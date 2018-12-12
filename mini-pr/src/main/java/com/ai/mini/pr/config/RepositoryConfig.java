package com.ai.mini.pr.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.ai.mini.pr.repository")
@EntityScan(basePackages = "com.ai.mini.pr.model")
@EnableTransactionManagement
public class RepositoryConfig {

}
