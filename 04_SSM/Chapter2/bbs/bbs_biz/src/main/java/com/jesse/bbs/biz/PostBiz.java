package com.jesse.bbs.biz;

import com.jesse.bbs.entity.Post;

import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
public interface PostBiz {
    void add(Post post);
    void remove(int id);
    Post get(int id);
    List<Post> getAll();
}
