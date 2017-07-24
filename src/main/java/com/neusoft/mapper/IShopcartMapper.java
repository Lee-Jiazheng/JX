package com.neusoft.mapper;

import com.neusoft.model.Shopcart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IShopcartMapper {
    @Select("select * from shopcart where shopcartBuyer= #{shopcartBuyer}")
    public Shopcart getShopcart(@Param("shopcartBuyer") int shopcartBuyer);

    @Insert("insert into shopcart(shopcartBuyer,shopcartGoods,shopcartTime) " +
            "values(#{shopcartBuyer},#{shopcartGoods},#{shopcartTime})")
    public void addShopcart(Shopcart shopcart);


    @Delete("delete from shopcart where shopcartBuyer=#{shopcartBuyer} and " +
            "shopcartGoods=#{shopcartGoods}")
    public void delShopcartById(@Param("shopcartBuyer") int shopcartBuyer,
                                @Param("shopcartGoods") int shopcartGoods);


}