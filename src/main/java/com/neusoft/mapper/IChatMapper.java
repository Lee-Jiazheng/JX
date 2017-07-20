package com.neusoft.mapper;

import com.neusoft.model.ChatUserRecord;
import com.neusoft.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/19.
 */
public interface IChatMapper {
    @Select("select * from user where userid in (select passive_user from chat_user_record where origin_user = #{id})")
    List<User> getAllChatUserByUserId(int id);
}
