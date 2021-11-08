package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Mapper.questionMapper;
import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.dto.PaginationDTO;
import com.example.spring_.commnity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class profileController {
    @Autowired
    QuestionService questionService;

    @Autowired
    UserMapper userMapper;
    @GetMapping(value = "/profile/{action}")

    public  String get_profile(@PathVariable(name="action") String action,
                               Model model, HttpServletRequest request,
                               @RequestParam(name ="page",defaultValue = "1") Integer page,
                               @RequestParam(name ="size",defaultValue = "5") Integer  size

    ){
        if(page==0){
            page=1;
        }
        Cookie[] cookies=request.getCookies();
//        User user=null;
        User user=(User) request.getSession().getAttribute("user");

//        if(cookies!=null && cookies.length!=0){
//            for(Cookie cookie:cookies) {
//                if (cookie.getName().equals("token")) {
//                    String token = cookie.getValue();
//                    user = userMapper.findToken(token);
//                    if (user != null) {
//                        request.getSession().setAttribute("user", user);
//
//                    }
//                    break;
//                }
//            }
//        }
        if(user==null){
            return "redirect:/";
        }
        PaginationDTO pagination=questionService.list_(user.getId(), page,size);


        model.addAttribute("pagination",pagination);

        questionService.list_(user.getId(),page,size);
    if("question".equals(action)){
        model.addAttribute("section","question");
        model.addAttribute("sectionName","个人idea");

    }
        if("reply".equals(action)){
            model.addAttribute("section","reply");
            model.addAttribute("sectionName","回复");

        }
        return "profile";
    }


}
