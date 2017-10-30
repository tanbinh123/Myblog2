package com.onefann.repository;

import com.onefann.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by b1109_000 on 2017/10/19.
 */
public interface UserRepositoty extends JpaRepository<User,Long>{

    User findUserByUsername(String username);
}
