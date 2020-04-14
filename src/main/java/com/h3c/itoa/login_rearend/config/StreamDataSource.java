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

@Configuration
@MapperScan(basePackages = "com.h3c.itoa.login_rearend.mapper.streammapper",
        sqlSessionTemplateRef = "myStreamSqlSessionTemplate")
public class StreamDataSource {
    @Bean(name="myStreamDataSource")
    @Primary
    @ConfigurationProperties(prefix = "springboot.postgre.stream.datasource")
    public DataSource streamDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="myStreamSqlSessionFactory")
    @Primary
    public SqlSessionFactory streamSqlSessionFactory( @Qualifier(value = "myStreamDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Primary
    @Bean(name="myStreamTransactionManager")
    public DataSourceTransactionManager streamTransactionManager(@Qualifier(value = "myStreamDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name="myStreamSqlSessionTemplate")
    public SqlSessionTemplate streamSqlSessionTemplate(@Qualifier(value="myStreamSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
