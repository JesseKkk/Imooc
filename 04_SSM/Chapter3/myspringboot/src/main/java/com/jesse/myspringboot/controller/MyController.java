package com.jesse.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kong on 2020/6/16.
 */
@Controller
public class MyController {

    @RequestMapping("/out")
    @ResponseBody
    public String out() {
        return "success";
    }
}
