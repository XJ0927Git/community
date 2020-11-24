package com.zhaoguojiang.community.community.controller;

import com.zhaoguojiang.community.community.mapper.UserMapper;
import com.zhaoguojiang.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-23 11:02
 * @Modified By:
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    
    /**
    * @Description: 什么都不写访问主页
    * @Date Created in 2020/11/23 15:03
    */
    @GetMapping("/")
    public String hello(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                System.out.println(token);
                User user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("githubUser",user);
                }
            }
        }

        return "index";
    }
}
