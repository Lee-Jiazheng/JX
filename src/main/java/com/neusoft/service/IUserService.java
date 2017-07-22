package com.neusoft.service;

import com.neusoft.model.User;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IUserService {
    public boolean user_login(User user);
    public boolean user_register(User user);

}
