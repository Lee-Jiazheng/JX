package com.neusoft.service.impl;

import com.neusoft.mapper.IAddressMapper;
import com.neusoft.mapper.IChatMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.Address;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private IAddressMapper addressMapper;

    public boolean check_username(String username) {
        if(userMapper.getUserByName(username) == null)
            return true;
        return false;
    }

    public User user_login(User _user) {
        return userMapper.verifyUser(_user);
    }

    public boolean user_register(User user) {
        if(check_username(user.getNickname()) == true)
        {
            user.setCreatetime(new Date());
            userMapper.addUser(user);
            return true;
        }
        return false;
    }

    public boolean change_avatar(MultipartFile file, User _user, String filePath) {
        if(_user == null || file == null)
            return false;
        String fileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
        //改变用户头像时，每个用户的昵称和用户名称相同
        //String fileName = _user.getNickname();
        try{
            //FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());
            file.transferTo(new File(filePath+ '/' + fileName));
            _user.setUserphoto(fileName);
            userMapper.updateAvatar(_user);
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

    @Override
    public List<Address> getAllAddresses(int userid) {
        return addressMapper.getAllAddressByUserid(userid);
    }

    @Override
    public int addAddress(Address address,String state,int addressid) {
        if(state.equals("new_address")){
            return addressMapper.addAddressByAddress(address);
        }
        else if(state.equals("edit_address")){
            address.setAddressid(addressid);
            return addressMapper.editAddressByAddress(address);
        }
        return 0;
    }

    @Override
    public int delAddress(int addressid){
        return addressMapper.delAddressById(addressid);
    }
}
