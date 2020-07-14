package com.jesse.bbs.controller.front;

import com.jesse.bbs.biz.CommentBiz;
import com.jesse.bbs.biz.PostBiz;
import com.jesse.bbs.entity.Comment;
import com.jesse.bbs.entity.Post;
import com.jesse.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Kong on 2020/6/15.
 */
@Controller("defaultController")
@RequestMapping("/front")
public class DefaultController {

    @Autowired
    private PostBiz postBiz;

    @Autowired
    private CommentBiz commentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map) {
        map.put("postList", postBiz.getAll());
        return "list";
    }

    @RequestMapping("/to_addPost")
    public String toAddPost() {
        return "addPost";
    }

    @RequestMapping("/addPost")
    public String addPost(HttpSession session, Post post) {
        User user = (User) session.getAttribute("user");
        post.setUsername(user.getUsername());
        postBiz.add(post);
        return "redirect:list";
    }

    @RequestMapping("/to_post")
    public String toPost(Map<String, Object> map, @RequestParam Integer id) {
        Post post = postBiz.get(id);
        List<Comment> commentList = commentBiz.getByPost(id);
        map.put("post", post);
        map.put("commentList", commentList);
        return "post";
    }

    @RequestMapping("/comment")
    public String comment(HttpSession session, Comment comment) {
        User user = (User) session.getAttribute("user");
        comment.setUserId(user.getId());
        comment.setUsername(user.getUsername());
        commentBiz.add(comment);
        return "redirect:to_post?id=" + comment.getPostId();
    }
}
