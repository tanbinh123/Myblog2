package com.onefann.service.serviceImpl;

import com.onefann.domain.Comment;
import com.onefann.repository.CommentRepository;
import com.onefann.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by one_fann on 2017/11/3.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> listCommentByBlogId(long id) {
        return null;
    }

    @Override
    public void delteCommentById(Integer id) {
        commentRepository.delete(id);
    }
}
