package com.neusoft.mapper;

import com.neusoft.model.Shopcart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IShopcartMapper {
    @Select("select * from shopcart where shopcartbuyer= #{shopcartbuyer}")
    public List<Shopcart> getShopcartById(@Param("shopcartbuyer") int
                                                  shopcartbuyer);

    @Insert("insert into shopcart(shopcartbuyer,shopcartGoods,shopcartTime) " +
            "values(#{shopcartbuyer},#{shopcartgoods},#{shopcarttime})")
    public void addShopcart(Shopcart shopcart);


    @Delete("delete from shopcart where shopcartBuyer=#{shopcartBuyer}")
    public void delShopcartById(@Param("shopcartBuyer") int shopcartBuyer);


}