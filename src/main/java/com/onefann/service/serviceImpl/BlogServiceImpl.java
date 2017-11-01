package com.onefann.service.serviceImpl;

import com.onefann.domain.Blog;
import com.onefann.enums.ResultEnum;
import com.onefann.exception.BlogException;
import com.onefann.repository.BlogRepository;
import com.onefann.service.BlogService;
import com.onefann.vo.BlogTypeArchiveVo;
import com.onefann.vo.DateArchiveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Page<Map<String, Object>> listBlogDataByDate(String date,Pageable pageable) {
        if (date == null) {
            throw new BlogException(ResultEnum.BLOG_PARAMS_ERROR.getMsg());
        }
        //id,title,summary,create_time,read_size,comment_size,blog_type
        Page<Object[]> list = blogRepository.findByCreateTime(date, pageable);
        List<Map<String,Object>> maps = new ArrayList<>();
        Map<String,Object> map = null;
        for (Object[] o : list) {
            map = new HashMap<>();
            map.put("id",o[0]);
            map.put("title",o[1]);
            map.put("summary",o[2]);
            map.put("create_time",o[3]);
            map.put("read_size",o[4]);
            map.put("comment_size",o[5]);
            map.put("blog_type",o[6]);
            map.put("tags",o[7]);
            maps.add(map);
        }
        Page<Map<String, Object>> page = new PageImpl(maps, pageable, list.getTotalElements());
        return page;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(Long id) {
        blogRepository.delete(id);
    }
}
