package com.onefann.controller;

import com.onefann.domain.BlogType;
import com.onefann.enums.ResultEnum;
import com.onefann.service.BlogTypeService;
import com.onefann.util.ResultVoUtil;
import com.onefann.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by one_fann on 2017/10/25.
 */
@RestController
@RequestMapping("/blog_type")
@Slf4j
public class BlogTypeController {

    @Autowired
    BlogTypeService blogTypeService;

    @GetMapping("/list")
    public ResultVo list() {
        List<BlogType> blogTypeList = blogTypeService.list();
        return ResultVoUtil.success(blogTypeList);
    }

    @GetMapping("/delete")
    public ResultVo delete(@RequestParam(value = "id",defaultValue = "") Integer id) {
        if (id == null) {
            ResultVoUtil.error(ResultEnum.BLOG_PARAMS_ERROR.getCode(), ResultEnum.BLOG_PARAMS_ERROR.getMsg());
        }
        try {
            blogTypeService.deleteBlogType(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            ResultVoUtil.error(ResultEnum.BLOGTYPE_DELETE_ERROR.getCode(),ResultEnum.BLOGTYPE_DELETE_ERROR.getMsg());
        }
        return ResultVoUtil.success(ResultEnum.BLOGTYPE_DELETE_SUCCESS.getCode(), ResultEnum.BLOGTYPE_DELETE_SUCCESS.getMsg());
    }

}
