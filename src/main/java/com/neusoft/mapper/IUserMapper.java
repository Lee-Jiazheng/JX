package com.neusoft.mapper;

import com.neusoft.model.User1;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/16.
 */
public interface IUserMapper {
    @Select("select * from blog_user")
    public List<User1> getSelectUser();
}
