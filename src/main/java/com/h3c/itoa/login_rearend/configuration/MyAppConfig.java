package com.h3c.itoa.login_rearend.configuration;

import com.h3c.itoa.login_rearend.pojo.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.util.ManifestEntryVerifier;

@Configuration
public class MyAppConfig {
    @Bean
    public Member getMember(){
        System.out.println("@Configuration @Bean给容器添加组件");
        return new Member();
    }
}
