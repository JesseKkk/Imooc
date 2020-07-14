package com.jesse.bbs.controller.back;

import com.jesse.bbs.biz.AdminBiz;
import com.jesse.bbs.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Kong on 2020/6/11.
 */
@Controller("adminController")
@RequestMapping("/back")
public class AdminController {

    @Autowired
    private AdminBiz adminBiz;

    @RequestMapping("/to_admin_login")
    public String toAdminLogin(){
        return "adminLogin";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpSession session, @RequestParam String username, @RequestParam String password){
        Admin admin = adminBiz.login(username,password);
        if (admin == null) {
            return "redirect:to_admin_login";
        }
        session.setAttribute("admin", admin);
        return "redirect:to_userList";
    }

    @RequestMapping("/adminQuit")
    public String adminQuit(HttpSession session){
        session.setAttribute("admin",null);
        return "redirect:to_admin_login";
    }

}
