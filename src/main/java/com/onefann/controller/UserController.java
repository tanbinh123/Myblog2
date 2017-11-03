package com.onefann.controller;

import com.onefann.domain.User;
import com.onefann.enums.ResultEnum;
import com.onefann.service.UserService;
import com.onefann.util.ResultVoUtil;
import com.onefann.vo.ResultVo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by one_fann on 2017/11/3.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @Secured("ROLE_ADMIN")
    public ResultVo save(@Valid User userForm) {
        User user = new User();
        if (userForm.getId() != null) {
            user = userService.findById(userForm.getId());
        }
        BeanUtils.copyProperties(userForm,user);
        try {
            userService.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            ResultVoUtil.error(ResultEnum.USER_SAVE_ERROR.getCode(), ResultEnum.USER_SAVE_ERROR.getMsg());
        }
        return ResultVoUtil.success(ResultEnum.USER_SAVE_SUCCESS.getCode(), ResultEnum.USER_SAVE_SUCCESS.getMsg());
    }

}
