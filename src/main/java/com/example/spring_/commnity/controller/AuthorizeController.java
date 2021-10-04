package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Provide.GithubProvider;
import com.example.spring_.commnity.dto.AccessTokenDTO;
import com.example.spring_.commnity.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

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



    @GetMapping("/callback")
//    登录第二步  得到accessstoken携带code
//    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


    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
//        accessToken=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
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_url(redirect_url);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        String accessToken=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        System.out.println(user.getId());
        System.out.println(user.getBio());

        return "index";


    }
//    登录第三步


}
