package com.h3c.itoa.login_rearend;

import com.h3c.itoa.login_rearend.pojo.Member;
//import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class LoginRearendApplicationTests {
    @Autowired
    Member member;

    @Autowired
    ApplicationContext ioc;

    @Test
    void ifContainer(){
        System.out.println(ioc.containsBean("getMember"));
    }
    @Test
    void contextLoads() {
        System.out.println(member.toString());
    }

}
