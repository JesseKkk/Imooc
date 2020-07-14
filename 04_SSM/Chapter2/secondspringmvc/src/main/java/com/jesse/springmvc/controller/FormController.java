package com.jesse.springmvc.controller;

import com.jesse.springmvc.entity.Form;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/5/25.
 */
@Controller
public class FormController {
    //@PostMapping("/apply")
    @ResponseBody
    public String apply(@RequestParam(value = "n",defaultValue = "ANON") String name, String course, Integer[] purpose){
        System.out.println(name);
        System.out.println(course);
        for (Integer p : purpose) {
            System.out.println(p);
        }
        return "SUCCESS";
    }

    //@PostMapping("/apply")
    @ResponseBody
    public String apply(String name, String course, @RequestParam List<Integer> purpose){
        System.out.println(name);
        System.out.println(course);
        for (Integer p : purpose) {
            System.out.println(p);
        }
        return "SUCCESS";
    }

    //@PostMapping("/apply")
    @ResponseBody
    public String apply(Form form){
        return "SUCCESS";
    }

    //Map接收复合数据，存在数据丢失问题
    //@PostMapping("/apply")
    @ResponseBody
    public String apply(@RequestParam Map map){
        return "SUCCESS";
    }

    @PostMapping("/apply")
    @ResponseBody
    public String applyDelivery(Form form){
        System.out.println(form.getDelivery().getName());
        return "SUCCESS";
    }
}
