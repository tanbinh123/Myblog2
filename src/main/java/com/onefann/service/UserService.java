package com.onefann.service;

import com.onefann.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by one_fann on 2017/10/20.
 */
public interface UserService extends UserDetailsService {

    User save(User user);

    void delete(long id);

    User findById(long id);
}
