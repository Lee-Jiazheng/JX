package com.neusoft.mapper;

import com.neusoft.model.Collections;
import org.apache.ibatis.annotations.*;

import java.util.Date;

public interface ICollectionsMapper {
    @Select("select * from collections where user= #{user}")
    public Collections getCollections(@Param("user") int user);

    @Insert("insert into collections(user,goods,time) " + "values(#{user}," +
            "#{goods},#{time})")
    public void addCollections(@Param("user") int user, @Param("goods") int
            goods, @Param("time") Date time);

    @Update("update collections set user=#{user},goods=#{goods},time=#{time}"
            + "where user=#{user and goods=#{goods}")
    public void updateCollections(@Param("user") int user, @Param("goods")
            int goods, @Param("time") Date time);

    @Delete("delete from collections where user=#{user} and goods=#{goods}")
    public void delCollectionsById(@Param("user") int user, @Param("goods")
            int goods);


}