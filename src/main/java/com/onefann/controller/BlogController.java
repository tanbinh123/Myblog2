package com.onefann.controller;

import com.onefann.domain.Blog;
import com.onefann.enums.ResultEnum;
import com.onefann.exception.BlogException;
import com.onefann.service.BlogService;
import com.onefann.util.ResultVoUtil;
import com.onefann.vo.BlogTypeArchiveVo;
import com.onefann.vo.DateArchiveVo;
import com.onefann.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by one_fann on 2017/10/25.
 */
@RequestMapping("/blog/")
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public ResultVo listBlog(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "size",defaultValue = "10")Integer size) {
        Pageable pageable = new PageRequest(page-1,size,new Sort(Sort.Direction.DESC,"createTime"));
        Page<Map<String,Object>> pageList = blogService.listBlogData(pageable);
        return ResultVoUtil.success(pageList);
    }

    @GetMapping("/archive_type")
    public ResultVo archiveBlogType() {
        List<BlogTypeArchiveVo> voList = blogService.blogTypeArchive();
        return ResultVoUtil.success(voList);
    }

    @GetMapping("/archive_date")
    public ResultVo archiveDate() {
        List<DateArchiveVo> voList = blogService.dateArchive();
        return ResultVoUtil.success(voList);
    }
    @Secured("ROLE_ADMIN")
    public ResultVo deleteBlog(Long blogId) {
        blogService.deleteBlogById(blogId);
        return ResultVoUtil.success();
    }

    @PostMapping("/save")
    public ResultVo save(@Valid Blog blogForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVoUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        Blog blog = new Blog();
        try {
            if (blogForm.getId() != null) {
                blog = blogService.findById(blogForm.getId());
            }
            BeanUtils.copyProperties(blogForm, blog);
            blogService.save(blog);
        } catch (BlogException e) {
            return ResultVoUtil.error(e.getMessage());
        } catch (Exception e) {
            return ResultVoUtil.error(e.getMessage());
        }

        return ResultVoUtil.success(ResultEnum.BLOG_SAVE_SUCCESS.getCode(),ResultEnum.BLOG_SAVE_SUCCESS.getMsg());
    }


}
