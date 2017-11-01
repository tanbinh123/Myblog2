package com.onefann.form;


import com.onefann.domain.BlogType;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Created by one_fann on 2017/11/1.
 */
public class BlogForm {

    private Long id;

    @NotEmpty(message = "标题不能为空")
    @Size(min=2, max=50)
    @Column(nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;

    @NotEmpty(message = "摘要不能为空")
    @Size(min=2, max=300)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String summary;


    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String content;

    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String htmlContent; // 将 md 转为 html


    @NotEmpty(message = "分类不能为空")
    @JoinColumn(name = "blogType")
    private BlogType blogType;

    @Column(name="tags", length = 100)
    private String tags;  // 标签
}
