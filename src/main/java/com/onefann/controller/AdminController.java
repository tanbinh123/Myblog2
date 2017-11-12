package com.onefann.controller;

import com.onefann.domain.BlogType;
import com.onefann.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by one_fann on 2017/10/22.
 */
@Controller
public class AdminController {
    @Autowired
    private BlogTypeService blogTypeService;

    @GetMapping("/admin")
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/admin/write_blog")
    public ModelAndView writeBlog(Model model) {
        List<BlogType> types = blogTypeService.list();
        model.addAttribute("types", types);
        return new ModelAndView("/admin/write_blog","typesModel",model);
    }
}
