package com.h3c.itoa.login_rearend.mapper;


import com.h3c.itoa.login_rearend.pojo.Loginer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Mapper
@Component
public interface LoginMapper {
    @Results(id="loginResult",value = {
            @Result(property = "loginName",column = "username"),
            @Result(property = "password",column = "password")
    })
    @Select("select username,password from login where username=#{loginName} and password = #{password}")
    public Loginer loginCheck(String loginName, String password);
}
