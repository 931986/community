package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Mapper.questionMapper;
import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.dto.PaginationDTO;
import com.example.spring_.commnity.dto.QuestionDTO;
import com.example.spring_.commnity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="sunyifan") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }
    public String greeting(HttpServletRequest request,
                           Model model,
                                       @RequestParam(name ="page",defaultValue = "1") Integer page,
                                     @RequestParam(name ="size",defaultValue = "5") Integer  size

                           ) {

        Cookie[] cookies=request.getCookies();
        if(cookies!=null && cookies.length!=0){
         for(Cookie cookie:cookies) {
        if (cookie.getName().equals("token")) {
            String token = cookie.getValue();
            User user = userMapper.findToken(token);
            if (user != null) {
                request.getSession().setAttribute("user", user);

            }
            break;
        }
    }
    }

        PaginationDTO pagination=questionService.list(page,size);
//        for(QuestionDTO question:questionList){
//            question.setDescription("change");
//        }

        model.addAttribute("pagination",pagination);



        return "index";
    }

}