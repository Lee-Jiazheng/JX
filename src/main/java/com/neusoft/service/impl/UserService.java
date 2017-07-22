package com.neusoft.service.impl;

import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.User;
import com.neusoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Service("userManager")
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserMapper userMapper;
    public boolean user_login(User user) {

        User u1 = userMapper.getUserByName("2");
        return false;
    }

    public boolean user_register(User user) {
        return false;
    }
}
