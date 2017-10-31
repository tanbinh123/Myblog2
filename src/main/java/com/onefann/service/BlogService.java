package com.onefann.service;

import com.onefann.domain.Blog;
import com.onefann.vo.BlogTypeArchiveVo;
import com.onefann.vo.DateArchiveVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by one_fann on 2017/10/25.
 */
public interface BlogService {

    Blog findById(Long id);
    Page<Blog> findAll(Pageable pageable);
    List<BlogTypeArchiveVo> blogTypeArchive();
    List<DateArchiveVo> dateArchive();
    Page<Map<String,Object>> listBlogData(Pageable pageable);
    void deleteBlogById(Long id);
    void save(Blog blog);
    Page<Object[]> listBlogDataByDate(String date,Pageable pageable);
}
