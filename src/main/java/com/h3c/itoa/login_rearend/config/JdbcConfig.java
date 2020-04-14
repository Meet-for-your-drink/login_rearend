package com.h3c.itoa.login_rearend.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("classpath:application.properties")
public class JdbcConfig {
    @Value("${springboot.postgre.web.datasource.url}")
    String url;
    @Value("${springboot.postgre.web.datasource.driverClassName}")
    String driverClassName;
    @Value("${springboot.postgre.web.datasource.username}")
    String username;
    @Value("${springboot.postgre.web.datasource.password}")
    String password;
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
