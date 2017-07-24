package com.neusoft.service.impl;

import com.neusoft.mapper.IChatMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.User;
import com.neusoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Service("userManager")
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IChatMapper chatMapper;

    public boolean check_username(String username) {
        if(userMapper.getUserByName(username) == null)
            return true;
        return false;
    }

    public User user_login(User _user) {
        return userMapper.verifyUser(_user);
    }

    public boolean user_register(User user) {
        if(check_username(user.getNickName()) == true)
        {
            userMapper.addUser(user);
            return true;
        }
        return false;
    }

    public boolean change_avatar(MultipartFile file, User _user, String filePath) {
        if(_user == null || file == null)
            return false;
        //String fileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
        //改变用户头像时，每个用户的昵称和用户名称相同
        String fileName = _user.getNickName();
        try{
            //FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());
            file.transferTo(new File(filePath+ '/' + fileName));
        }catch (IOException e){
            System.out.println("文件上传失败");
            return false;
        }
        return true;
    }

    public List<User> getChatUsers(User user) {
        return chatMapper.getAllChatUserByUserId(1);
    }

    @Override
    public void alter_user_info(User user) {
        userMapper.updateUser(user);
    }


}
