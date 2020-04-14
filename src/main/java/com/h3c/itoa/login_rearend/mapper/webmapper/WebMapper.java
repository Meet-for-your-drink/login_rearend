package com.h3c.itoa.login_rearend.mapper.webmapper;

import com.h3c.itoa.login_rearend.pojo.Loginer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WebMapper {
    @Select("select * from login")
    public List<Loginer> queryLoginer();
}
