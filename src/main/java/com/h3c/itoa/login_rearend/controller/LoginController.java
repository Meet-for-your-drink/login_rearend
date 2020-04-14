package com.h3c.itoa.login_rearend.controller;

import com.h3c.itoa.login_rearend.pojo.Loginer;
import com.h3c.itoa.login_rearend.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/login/{loginName}/{password}",method = RequestMethod.POST)
    public Boolean login(Map map){
        System.out.println("POST use map");
        return loginService.loginCheck(map.get("loginName").toString(),map.get("password").toString());
    }
//
//    @RequestMapping(value="/login",method = RequestMethod.POST)
//    public @ResponseBody  Boolean login(@RequestBody Loginer loginer){
//        System.out.println(loginer.toString());
//        return loginService.loginCheck(loginer.getLoginName(),loginer.getPassword());
//    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public @ResponseBody Boolean login_GET(HttpServletRequest request){
        System.out.println(request.getParameter("loginName")+":"+request.getParameter("password"));
        return loginService.loginCheck(request.getParameter("loginName"),request.getParameter("password"));
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public @ResponseBody Boolean login_POST(HttpServletRequest request){

        System.out.println(request.getParameter("loginName")+":"+request.getParameter("password"));
        return loginService.loginCheck(request.getParameter("loginName"),request.getParameter("password"));
    }

    @RequestMapping(value="/login",method = RequestMethod.PUT)
    public @ResponseBody Boolean login_PUT(HttpServletRequest request){
        System.out.println(request.getParameter("loginName")+":"+request.getParameter("password"));
        return loginService.loginCheck(request.getParameter("loginName"),request.getParameter("password"));
    }

    @RequestMapping(value="/login",method = RequestMethod.DELETE)
    public @ResponseBody Boolean login_DELETE(@RequestBody Loginer loginer){
        System.out.println("delete "+loginer.getLoginName()+":"+loginer.getPassword());
        return loginService.loginCheck(loginer.getLoginName(),loginer.getPassword());
    }
}
