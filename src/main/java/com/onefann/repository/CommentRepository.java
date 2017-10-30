package com.onefann.repository;

import com.onefann.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by one_fann on 2017/10/20.
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
