package com.h3c.itoa.login_rearend.service;

import com.h3c.itoa.login_rearend.pojo.Member;

import java.util.List;

public interface MemberService {
    List<Member> loadMemberList();

    Boolean deleteMember(Integer id);
}
