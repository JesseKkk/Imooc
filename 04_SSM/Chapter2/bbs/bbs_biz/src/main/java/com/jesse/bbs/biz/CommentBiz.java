package com.jesse.bbs.biz;

import com.jesse.bbs.entity.Comment;

import java.util.List;

/**
 * Created by Kong on 2020/6/15.
 */
public interface CommentBiz {
    void add(Comment comment);
    List<Comment> getByPost(int postId);
}
