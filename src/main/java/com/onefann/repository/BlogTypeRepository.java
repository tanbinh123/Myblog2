package com.onefann.repository;

import com.onefann.domain.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by one_fann on 2017/10/19.
 */
public interface BlogTypeRepository extends JpaRepository<BlogType,Integer>{

}
