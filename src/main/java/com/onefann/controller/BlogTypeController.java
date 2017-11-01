package com.onefann.controller;

import com.onefann.domain.BlogType;
import com.onefann.service.BlogTypeService;
import com.onefann.util.ResultVoUtil;
import com.onefann.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by one_fann on 2017/10/25.
 */
@RestController
@RequestMapping("/blog_type")
public class BlogTypeController {

    @Autowired
    BlogTypeService blogTypeService;

    @GetMapping("/list")
    public ResultVo list() {
        List<BlogType> blogTypeList = blogTypeService.list();
        return ResultVoUtil.success(blogTypeList);
    }
}
