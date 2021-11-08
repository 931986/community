package com.example.spring_.commnity.controller;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Mapper.questionMapper;
import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public  class PublishController {

    @Autowired
    private questionMapper questionMapper_;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public  String Publish(){
        System.out.println("get运行了");
        return "publish";

    }
    @PostMapping("/publish")
    public  String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tags",required = false) String tags,
            HttpServletRequest request,
            Model model
            ){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tags",tags);
        if(title==null || title==""){
            model.addAttribute("error","标题不能是空");
            return "publish";
        }
        if(description==null || description==""){
            model.addAttribute("error","描述不能是空");
            return "publish";
        }
        if(tags==null || tags==""){
            model.addAttribute("error","标签不能是空");
            return "publish";
        }



        System.out.println("post运行了");


        User user=(User) request.getSession().getAttribute("user");

        if(user==null){
            model.addAttribute("error","用户login失败");
            return  "publish";
        }

        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTags(tags);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionMapper_.create(question);

        return "redirect:/";
    }


}
