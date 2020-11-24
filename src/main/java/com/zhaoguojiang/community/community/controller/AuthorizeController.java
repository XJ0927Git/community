package com.zhaoguojiang.community.community.controller;

import com.zhaoguojiang.community.community.dto.AccessTokenDto;
import com.zhaoguojiang.community.community.mapper.UserMapper;
import com.zhaoguojiang.community.community.model.User;
import com.zhaoguojiang.community.community.provider.GithubProvider;
import com.zhaoguojiang.community.community.provider.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-23 17:04
 * @Modified By:
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String uri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request
    ) {

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(uri);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            githubUser.setName("小江");
            githubUser.setId(1l);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            System.out.println(user);
            userMapper.insert(user);
            request.getSession().setAttribute("githubUser", githubUser);
            System.out.println(githubUser.getName());
            System.out.println("登陆成功");
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
}
