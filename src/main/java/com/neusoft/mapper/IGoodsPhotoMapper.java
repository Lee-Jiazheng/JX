package com.neusoft.mapper;

import com.neusoft.model.Goodsphoto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IGoodsPhotoMapper {
    @Insert("insert into goodsphoto values(#{goods},#{photo},#{number})")
    void addGoodsPhoto(Goodsphoto goodsPhoto);

    @Delete("delete from goodsphoto where goods=#{goods}")
    void delGoodsPhoto(int goods);

    @Update("update goodsphoto set photo=#{photo} where goods=#{goods} and" +
            "number=#{number}")
    void updateGoodsPhoto(@Param("photo") String photo, @Param("goods") int
            goods, @Param("number") int number);

    @Select("select * from goodsphoto where goods=#{goods}")
    List<Goodsphoto> getAllPhoto(int goods);

}