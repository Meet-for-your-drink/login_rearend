package com.h3c.itoa.login_rearend.mapper;

import com.h3c.itoa.login_rearend.pojo.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MemberMapper {
    @Select("select id,account,remark from member")
    List<Member> queryMember();
    @Delete("delete from member where id = #{id}")
    void deleteMember(Integer id);
}
