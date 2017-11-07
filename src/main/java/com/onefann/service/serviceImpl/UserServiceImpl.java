package com.onefann.service.serviceImpl;

import com.onefann.domain.User;
import com.onefann.repository.UserRepositoty;
import com.onefann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by one_fann on 2017/10/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserDetails userDetails = userRepositoty.findUserByUsername(username);
        return userDetails;
    }

    @Override
    public User save(User user) {
        User result = userRepositoty.save(user);
        return result;
    }

    @Override
    public void delete(long id) {
        userRepositoty.delete(id);
    }

    @Override
    public User findById(long id) {
        return userRepositoty.findOne(id);
    }

    @Override
    public User find() {
        List<User> users = userRepositoty.findAll();
        User result = users.get(0);
        User user = new User();
        user.setId(result.getId());
        user.setAvatar(result.getAvatar());
        user.setUsername(result.getUsername());
        user.setProfile(result.getProfile());
        user.setNickname(result.getNickname());
        return user;
    }
}
