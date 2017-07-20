package com.neusoft.mapper;

import com.neusoft.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/16.
 */
public interface IUserMapper {
    @Select("select * from user where nickname = #{user_name}")
    User getUserByName(@Param("user_name") String user_name);
    @Select("select * from user where nickname = #{nickname} and password = #{password}")
    User verifyUser(User user);
}
