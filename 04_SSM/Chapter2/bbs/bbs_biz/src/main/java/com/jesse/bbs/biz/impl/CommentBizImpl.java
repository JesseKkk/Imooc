package com.jesse.bbs.biz.impl;

import com.jesse.bbs.biz.CommentBiz;
import com.jesse.bbs.dao.CommentDao;
import com.jesse.bbs.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Kong on 2020/6/15.
 */
@Service("commentBiz")
public class CommentBizImpl implements CommentBiz {

    @Autowired
    private CommentDao commentDao;

    public void add(Comment comment) {
        comment.setCreateTime(new Date());
        commentDao.insert(comment);
    }

    public List<Comment> getByPost(int postId) {
        return commentDao.selectByPost(postId);
    }
}
