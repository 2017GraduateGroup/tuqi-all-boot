package com.tuqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tuqi on 17/3/20.
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("sayHelloTools")
    public String sayHelloTools(Model model){
        return "/hello";
    }
}
