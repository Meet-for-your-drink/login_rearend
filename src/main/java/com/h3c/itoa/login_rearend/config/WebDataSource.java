package com.h3c.itoa.login_rearend.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


@Configuration
@MapperScan(basePackages = "com.h3c.itoa.login_rearend.mapper.webmapper",
sqlSessionTemplateRef = "myWebSqlSessionTemplate")
public class WebDataSource {
    @Bean(name="myWebDataSource")
    @ConfigurationProperties(prefix = "springboot.postgre.web.datasource")
    public DataSource webDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="myWebSqlSessionFactory")
    public SqlSessionFactory webSqlSessionFactory(@Qualifier(value = "myWebDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name="myWebTransactionManager")
    public DataSourceTransactionManager webTransactionManager(@Qualifier(value = "myWebDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="myWebSqlSessionTemplate")
    public SqlSessionTemplate webSqlSessionTemplate(@Qualifier(value="myWebSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
