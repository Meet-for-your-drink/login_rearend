package com.h3c.itoa.login_rearend.controller;

import com.h3c.itoa.login_rearend.pojo.Member;
import com.h3c.itoa.login_rearend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/member")
@Controller
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/loadMemberList",method = RequestMethod.GET)
    public @ResponseBody List<Member> queryMember(){
        return memberService.loadMemberList();
    }
//    @RequestMapping(value = "/deleteMember",method = RequestMethod.POST)
//    public @ResponseBody Boolean deleteMember(@RequestBody Map map){
//        System.out.println(map.get("id"));
//        return memberService.deleteMember((Integer) map.get("id"));
//    }
    @RequestMapping(value = "/deleteMember",method = RequestMethod.DELETE)
    public @ResponseBody Boolean deleteMember(@RequestBody Map map){
        System.out.println(map.get("id"));
        return memberService.deleteMember((Integer) map.get("id"));
    }
}
