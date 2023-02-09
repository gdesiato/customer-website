package com.example.customerwebsite.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    // @Value annotation assigns the value to attribute at the time of bean creation
//    @Value("${datasource.driver}") private String datasourceDriver;
//    @Value("${datasource.firstname}") private String datasourceFN;
//    @Value("${datasource.lastname}") private String datasourceLN;
//    @Value("${datasource.email}") private String datasourceEmail;
//    @Value("${datasource.password}") private String datasourcePassword;
//
//    @Bean
//    public DataSource mainDatasource() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(datasourceDriver);
//        config.setJdbcUrl(datasourceFN);
//        config.setUsername(datasourceLN);
//        config.setUsername(datasourceEmail);
//        config.setPassword(datasourcePassword);
//        return new HikariDataSource(config);
//    }

}