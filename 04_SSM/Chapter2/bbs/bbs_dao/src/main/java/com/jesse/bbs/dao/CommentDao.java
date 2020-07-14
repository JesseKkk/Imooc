package com.jesse.bbs.dao;

import com.jesse.bbs.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kong on 2020/6/15.
 */
@Repository("commentDao")
public interface CommentDao {
    void insert(Comment comment);
    List<Comment> selectByPost(int postId);
}
