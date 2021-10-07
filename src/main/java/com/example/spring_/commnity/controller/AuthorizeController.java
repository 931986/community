package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.Provide.GithubProvider;
import com.example.spring_.commnity.dto.AccessTokenDTO;
import com.example.spring_.commnity.dto.GithubUser;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
//@Resource
    private GithubProvider githubProvider;


    @Value("${github.Client.id}")
    private  String  client_id;
    @Value("${github.Client.secret}")
    private String client_secret;
    @Value("${github.redirect_url}")
    private  String redirect_url;
    @Autowired
//    实例化
    private UserMapper userMapper;



    @GetMapping("/callback")
//    登录第二步  得到accessstoken携带code
//    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


    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response

    ) {
//        accessToken=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
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_url(redirect_url);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);

        String accessToken=githubProvider.getAccessToken(accessTokenDTO);

        GithubUser githubUser=githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        System.out.println(githubUser.getId());
        System.out.println(githubUser.getBio());
        if( githubUser!=null && githubUser.getId()!=null){
            User user = new User();
            String token=UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatar_url());

            userMapper.Insert(user);
//            cookie在response里面
//登录成功， 通过reques get到session 设置 session
            response.addCookie(new Cookie("token",token));
           return "redirect:/";
        }else{
            //            登录失败
            return "redirect:/";
        }
//
//        sunyifan
//        27120214
//        Game Of Throne

//        return "index";


    }
//    登录第三步


}
