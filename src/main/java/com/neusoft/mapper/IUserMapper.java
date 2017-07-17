package com.neusoft.mapper;

import com.neusoft.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/16.
 */
public interface IUserMapper {
    @Select("select * from user")
    public List<User> getSelectUser();
}
