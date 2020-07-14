package com.jesse.bbs.biz.impl;

import com.jesse.bbs.biz.PostBiz;
import com.jesse.bbs.dao.PostDao;
import com.jesse.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
@Service("postBiz")
public class PostBizImpl implements PostBiz {

    @Autowired
    private PostDao postDao;

    public void add(Post post) {
        post.setCreateTime(new Date());
        postDao.insert(post);
    }

    public void remove(int id) {
        postDao.delete(id);
    }

    public Post get(int id) {
        return postDao.select(id);
    }

    public List<Post> getAll() {
        return postDao.selectAll();
    }
}
