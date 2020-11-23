package com.zhaoguojiang.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-23 11:02
 * @Modified By:
 */
@Controller
public class IndexController {
    
    /**
    * @Description: 什么都不写访问主页
    * @Param: [name, model] 
    * @Return: java.lang.String
    * @Author: xj0927
    * @Date Created in 2020/11/23 15:03
    */
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
