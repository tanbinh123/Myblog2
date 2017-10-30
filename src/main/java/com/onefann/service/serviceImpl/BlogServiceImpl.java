package com.onefann.service.serviceImpl;

import com.onefann.domain.Blog;
import com.onefann.exception.BlogException;
import com.onefann.repository.BlogRepository;
import com.onefann.service.BlogService;
import com.onefann.vo.BlogTypeArchiveVo;
import com.onefann.vo.DateArchiveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by one_fann on 2017/10/25.
 */
@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<BlogTypeArchiveVo> blogTypeArchive() {
        List<Object[]> list = blogRepository.BlogTypeArchive();
        List<BlogTypeArchiveVo> voList = new ArrayList<>();
        BlogTypeArchiveVo vo = null;
        for (Object[] objects : list) {
            vo = new BlogTypeArchiveVo();
            vo.setBlogTypeName((String) objects[0]);
            vo.setCount( ((BigInteger)objects[1]).intValue());
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<DateArchiveVo> dateArchive() {
        List<Object[]> objects = blogRepository.DateArchive();
        List<DateArchiveVo> volist = new ArrayList<>();
        DateArchiveVo vo = null;
        for (Object[] o : objects) {
            vo = new DateArchiveVo();
            vo.setDate(o[0].toString());
            vo.setCount(((BigInteger)o[1]).intValue());
            volist.add(vo);
        }
        return volist;
    }

    @Override
    public Page<Map<String,Object>> listBlogData(Pageable pageable) {
       return blogRepository.blogDataPage(pageable);

    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Long id) {
        if (id == null) {
            throw new BlogException("博客参数错误");
        }
        blogRepository.delete(id);
    }
}
