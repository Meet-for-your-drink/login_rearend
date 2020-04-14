package com.h3c.itoa.login_rearend.controller;

import com.h3c.itoa.login_rearend.mapper.streammapper.StreamMapper;
import com.h3c.itoa.login_rearend.mapper.webmapper.WebMapper;
import com.h3c.itoa.login_rearend.pojo.Loginer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dualDataSource")
@CrossOrigin
public class DualController {
    @Autowired
    private WebMapper webMapper;
    @Autowired
    private StreamMapper streamMapper;

    @RequestMapping(value = "/queryWeb",method = RequestMethod.GET)
    public @ResponseBody List<Loginer> queryWeb(){
        return webMapper.queryLoginer();
    }

    @RequestMapping(value = "/queryStream",method = RequestMethod.GET)
    public List<Loginer> queryStream(){
        return streamMapper.queryLogin();
    }
}
