package com.gmail.yershhov.ant_cybernest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/response")
public class ResponseController {
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
