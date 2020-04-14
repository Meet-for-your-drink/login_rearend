package com.h3c.itoa.login_rearend.serviceImpl;

import com.h3c.itoa.login_rearend.mapper.MemberMapper;
import com.h3c.itoa.login_rearend.pojo.Member;
import com.h3c.itoa.login_rearend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public List<Member> loadMemberList() {
        return memberMapper.queryMember();
    }

    @Override
    public Boolean deleteMember(Integer id) {
        memberMapper.deleteMember(id);
        return true;
    }
}
