package com.h3c.itoa.login_rearend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.h3c.itoa.login_rearend.mapper")
//@EnableEurekaClient
public class LoginRearendApplication {
    ArrayList list;
    public static void main(String[] args) {
        SpringApplication.run(LoginRearendApplication.class, args);
    }

}
