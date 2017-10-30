package com.onefann.service;

import com.onefann.domain.Blog;
import com.onefann.vo.BlogTypeArchiveVo;
import com.onefann.vo.DateArchiveVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by one_fann on 2017/10/25.
 */
public interface BlogService {

    public Blog findById(Long id);
    public Page<Blog> findAll(Pageable pageable);
    public List<BlogTypeArchiveVo> blogTypeArchive();
    public List<DateArchiveVo> dateArchive();
    public Page<Map<String,Object>> listBlogData(Pageable pageable);
    public void deleteBlogById(Long id);
    public void save(Blog blog);
}
