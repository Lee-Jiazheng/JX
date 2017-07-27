package com.neusoft.mapper;

import com.neusoft.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/16.
 */
public interface IUserMapper {
    @Select("select * from user where nickname = #{user_name}")
    User getUserByName(@Param("user_name") String user_name);
    @Select("select * from user where nickname = #{nickname} and password = #{password}")
    User verifyUser(User user);
    @Insert("insert into user() values()")
    int addUser(User user);

    @Select("select * from user where userId= #{userId}")
    User getUserById(@Param("userId") int userId);

    @Insert("insert into user(userId,password,nickname,realname,createTime," +
            "email,phone,credit,isAdmin) " +
            "values(#{userid},#{password},#{nickname},#{realname}," +
            "#{createTime},#{email},#{phone},#{credit})")
    void registerUser(User user);

    @Update("update user set nickname=#{nickname},realname = #{realname}, password=#{password}," +
            "email=#{email},phone=#{phone},credit=#{credit} where " +
            "userId=#{userid}")
    void updateUser(User user);

    @Update("update user set userphoto=#{userphoto} where nickname = #{nickname}")
    void updateAvatar(User user);

    @Select("select nickname from user, comments where userid=commentsbuyer and userid=#{buyer_id}")
    String getUserNameByCommentsBuyerID(int buyer_id);

}
