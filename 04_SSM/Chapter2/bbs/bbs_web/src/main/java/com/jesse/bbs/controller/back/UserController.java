package com.jesse.bbs.controller.back;

import com.jesse.bbs.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Kong on 2020/6/11.
 */
@Controller("userController")
@RequestMapping("/back")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/to_userList")
    public String toUserlist(Map<String,Object> map) {
        map.put("userList", userBiz.getAll());
        return "userList";
    }

    @RequestMapping("/removeUser")
    public String removeUser(@RequestParam int id) {
        userBiz.remove(id);
        return "redirect:to_userList";
    }

    @RequestMapping("/lockUser")
    public String lockUser(@RequestParam int id) {
        userBiz.lock(id);
        return "redirect:to_userList";
    }

    @RequestMapping("/unLockUser")
    public String unLockUser(@RequestParam int id) {
        userBiz.unLock(id);
        return "redirect:to_userList";
    }
}
