package com.jesse.springmvc.controller;

import com.jesse.springmvc.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Kong on 2020/5/25.
 */
@Controller
@RequestMapping("/um")
public class URLMappingController {
    @GetMapping("/g")
    //@RequestMapping(value = "/g", method = RequestMethod.GET) 它与GetMapping等价
    @ResponseBody
    public String getMapping(@RequestParam("manager_name") String managerName, Date createTime){
        System.out.println("managerName:" + managerName);
        return "This is get method";
    }

    //@PostMapping("/p")
    @ResponseBody
    public String postMapping(String username, Long password){
        //User u = new User()
        //u.setUsername(username)
        //request.getParameter()
        System.out.println(username + ":" + password);
        return "This is post method";
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(User user, String  username,@DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime){
        System.out.println(user.getUsername() + ":" + user.getPassword());
        return "这是Post响应";
    }

    @GetMapping("/view")
    public ModelAndView showView(Integer id){
        //ModelAndView mav = new ModelAndView("redirect:/view.jsp");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/view.jsp");
        User user = new User();
        if (id == 1){
            user.setUsername("lily");
        }else if (id == 2){
            user.setUsername("smith");
        }
        mav.addObject("USER", user);
        return mav;
    }

    //String与ModelMap
    //Controller方法返回String的情况
    //1. 方法被@ResponseBody描述，SpringMVC直接响应String字符串本身
    //2. 方法不存在@ResponseBody，则SpringMVC处理String指代的视图（页面）
    @GetMapping("/view1")
    //@ResponseBody
    public String showView1(Integer id, ModelMap modelMap){
        String view = "/view.jsp";
        User user = new User();
        if (id == 1){
            user.setUsername("lily");
        }else if (id == 2){
            user.setUsername("smith");
        }
        modelMap.addAttribute("USER", user);
        return view;
    }
}
