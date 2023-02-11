package com.example.customerwebsite.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    // @Value annotation assigns the value to attribute at the time of bean creation
    @Value("${datasource.driver}") private String datasourceDriver;
    @Value("${datasource.url}") private String datasourceUrl;
    @Value("${datasource.username}") private String datasourceUsername;
    @Value("${datasource.password}") private String datasourcePassword;

    @Bean
    @BatchDataSource
    public DataSource datasource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(datasourceDriver);
        config.setJdbcUrl(datasourceUrl);
        config.setUsername(datasourceUsername);
        config.setPassword(datasourcePassword);
        return new HikariDataSource(config);
    }

}