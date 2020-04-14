package com.h3c.itoa.login_rearend.serviceImpl;

import com.h3c.itoa.login_rearend.mapper.LoginMapper;
import com.h3c.itoa.login_rearend.pojo.Loginer;
import com.h3c.itoa.login_rearend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Boolean loginCheck(String loginName, String password) {
        Loginer result  = loginMapper.loginCheck(loginName,password);
        if(null == result){
            return false;
        }else{
            System.out.println(result.toString());
            return true;
        }
    }
}
