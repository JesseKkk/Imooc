package com.jesse.bbs.dao;

import com.jesse.bbs.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/11.
 */
@Repository("postDao")
public interface PostDao {
    void insert(Post post);
    void delete(int id);
    Post select(int id);
    List<Post> selectAll();
}

