package com.itheima.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://frp-bus.com:51631/Staem?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("114514");
        return ds;
    }
}