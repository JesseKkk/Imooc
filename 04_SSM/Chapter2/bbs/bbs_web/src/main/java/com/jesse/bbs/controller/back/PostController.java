package com.jesse.bbs.controller.back;

import com.jesse.bbs.biz.PostBiz;
import com.jesse.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/6/11.
 */
@Controller("postController")
@RequestMapping("/back")
public class PostController {

    @Autowired
    private PostBiz postBiz;

    @RequestMapping("/to_postList")
    public String toPostList(Map<String,Object> map) {
        List<Post> list = postBiz.getAll();
        map.put("postList", list);
        return "postList";
    }

    @RequestMapping("/removePost")
    public String removePost(@RequestParam int id) {
        postBiz.remove(id);
        return "redirect:to_postList";
    }
}
