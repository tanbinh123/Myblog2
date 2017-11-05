package com.onefann.controller;

import com.onefann.domain.Blog;
import com.onefann.domain.Comment;
import com.onefann.enums.ResultEnum;
import com.onefann.service.BlogService;
import com.onefann.service.CommentService;
import com.onefann.util.ResultVoUtil;
import com.onefann.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by one_fann on 2017/11/3.
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    @Secured("ROLE_ADMIN")
    public ResultVo save(@RequestParam(value = "id") Long blogId, @Valid Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResultVoUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if (blogId == null) {
           return ResultVoUtil.error(ResultEnum.BLOG_PARAMS_ERROR.getCode(), ResultEnum.BLOG_PARAMS_ERROR.getMsg());
        }
        Blog blog = blogService.findById(blogId);
        if (blog == null) {
           return ResultVoUtil.error(ResultEnum.COMMENT_SAVE_ERROR.getCode(), ResultEnum.COMMENT_SAVE_ERROR.getMsg());
        }
        try {
            blog.addComment(comment);
            blogService.save(blog);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultVoUtil.error(ResultEnum.COMMENT_SAVE_ERROR.getCode(), ResultEnum.COMMENT_SAVE_ERROR.getMsg());
        }
        return ResultVoUtil.success(ResultEnum.COMMENT_SAVE_SUCCESS.getCode(),ResultEnum.COMMENT_SAVE_SUCCESS.getMsg());
    }

    @GetMapping("/delete")
    @Secured("ROLE_ADMIN")
    public ResultVo resultVo(@RequestParam(value = "id") Long blogId,@RequestParam(value = "commentId")Integer commentId) {
        if (blogId==null||commentId == null) {
            return ResultVoUtil.error(ResultEnum.BLOG_PARAMS_ERROR.getCode(), ResultEnum.BLOG_PARAMS_ERROR.getMsg());
        }
        Blog blog = blogService.findById(blogId);
        if (blog == null) {
            return ResultVoUtil.error(ResultEnum.COMMENT_DELETE_ERROR.getCode(),ResultEnum.COMMENT_DELETE_ERROR.getMsg());
        }
        try {
            blog.removeComment(commentId);
            commentService.delteCommentById(commentId);
            blogService.save(blog);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultVoUtil.error(ResultEnum.COMMENT_DELETE_ERROR.getCode(),ResultEnum.COMMENT_DELETE_ERROR.getMsg());
        }
        return ResultVoUtil.success(ResultEnum.COMMENT_DELETE_SUCCESS.getCode(), ResultEnum.COMMENT_DELETE_SUCCESS.getMsg());

    }
}
