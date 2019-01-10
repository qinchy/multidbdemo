package com.qinchy.multidbdemo.controller;

import com.qinchy.multidbdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/get")
    public boolean getUserInfo(){
        return userInfoService.getUserInfo();
    }
}
