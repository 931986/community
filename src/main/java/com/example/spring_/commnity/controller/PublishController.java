package com.example.spring_.commnity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public  class PublishController {
    @GetMapping("/publish")
    public  String Publish(){
        return "publish";

    }

}
