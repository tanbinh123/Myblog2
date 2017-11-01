package com.onefann.service.serviceImpl;

import com.onefann.domain.BlogType;
import com.onefann.repository.BlogTypeRepository;
import com.onefann.service.BlogService;
import com.onefann.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by one_fann on 2017/10/25.
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeRepository blogTypeRepository;
    @Override
    public List<BlogType> list() {
        return blogTypeRepository.findAll();
    }
}
