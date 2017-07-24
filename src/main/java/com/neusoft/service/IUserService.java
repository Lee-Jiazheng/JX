package com.neusoft.service;

import com.neusoft.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IUserService {
    public boolean check_username(String username);
    public User user_login(User user);
    public boolean user_register(User user);
    public boolean change_avatar(MultipartFile avatar, User _user, String filePath);
    List<User> getChatUsers(User user);
    void alter_user_info(User user);
}
