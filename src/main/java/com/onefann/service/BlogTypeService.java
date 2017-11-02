package com.onefann.service;

import com.onefann.domain.BlogType;

import java.util.List;

/**
 * Created by one_fann on 2017/10/25.
 */
public interface BlogTypeService {
    List<BlogType> list();

    void deleteBlogType(Integer id);

    void saveBlogtype(BlogType blogType);
}
