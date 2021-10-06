package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="sunyifan") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }
    public String greeting(HttpServletRequest request) {

        Cookie[] cookies=request.getCookies();
    for(Cookie cookie:cookies){
        if(cookie.getName().equals("token")){
            String token=cookie.getValue();
            User user=userMapper.findToken(token);
            if(user!=null){
                request.getSession().setAttribute("user",user);

            }
            break;
        }
    }



        return "index";
    }

}