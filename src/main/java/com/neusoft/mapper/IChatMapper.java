package com.neusoft.mapper;

import com.neusoft.model.ChatUserRecord;
import com.neusoft.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/19.
 */
public interface IChatMapper {
    @Select("select * from user where userid in (select passiveuser from chatuserrecord where origin_user = #{id})")
    List<User> getAllChatUserByUserId(int id);

    @Insert("insert into passiveuser values(#{userid1}, #{userid2})")
    int insertChatUser(int userid1, int userid2);

    @Delete("delete from passiveuser where passiveuser = #{userid1} and passiveuser = #{userid2}")
    int deleteChatUser(int userid1, int userid2);
}
