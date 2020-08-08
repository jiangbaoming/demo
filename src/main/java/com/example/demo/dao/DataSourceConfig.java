package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
/**
 * @Author: 江宝明
 * @Description:
 * @Date:2020/08/08
 * @Modified By：
 */

@Configuration
public class DataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @Qualifier("mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysql(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleDataSource")
    @Qualifier("oracleDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource oracle(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("mysqlDataSource")DataSource mysqlDataSource){
        return new JdbcTemplate(mysqlDataSource);
    }

    @Bean(name = "oracleJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("oracleDataSource")DataSource oracleDataSource){
        return new JdbcTemplate(oracleDataSource);
    }
}
