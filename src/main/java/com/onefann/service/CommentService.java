package com.onefann.service;

import com.onefann.domain.Comment;

import java.util.List;

/**
 * Created by one_fann on 2017/11/3.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(long id);

    void delteCommentById(Integer id);
}
