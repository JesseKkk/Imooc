package com.jesse.bbs.controller.front;

import com.jesse.bbs.biz.UserBiz;
import com.jesse.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Kong on 2020/6/15.
 */
@Controller("loginController")
@RequestMapping("/front")
public class LoginController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/to_register")
    public String toRegister(Map<String,Object> map) {
        map.put("user", new User());
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpSession session, User user) {
        userBiz.register(user);
        session.setAttribute("user",user);
        return "redirect:list";
    }

    @RequestMapping("/to_userLogin")
    public String toUserLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        User user = userBiz.login(username,password);
        if (user == null) {
            return "redirect:to_userLogin";
        }
        session.setAttribute("user", user);
        return "redirect:list";
    }

}
