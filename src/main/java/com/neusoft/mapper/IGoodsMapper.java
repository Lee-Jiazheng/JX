package com.neusoft.mapper;

import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IGoodsMapper {
    @Select("select * from goods")
    public List<Goods> getAllGoods();

    @Select("select * from goods where goodsId= #{goodsId}")
    public Goods getGoods(@Param("goodsId") int goodsId);


    @Select("selct * from goods where goodsCategory=#{goodsCategory}")
    List<Goods> getGoodsByCategory(@Param("goodsCategory") int goodsCategory);


    @Select("select * from goods where (goodsName like #{%goodsName%}" +
            "or goodsKeywords like #{%goodsName%})")
    Goods getGoodsByWord(@Param("goodsName") String goodsName);
    /*
    插入一条商品数据时，必须给出名字和数量、种类、原始价格
    自动加上id、时间、状态
     */
    @Insert("insert into goods(goodsId,goodsName,goodsQuantity,goodsStatus," +
            "goodsCreateTime,goodsDescription,goodsKeywords," +
            "goodsPrice,goodsCategory) " +
            "values(#{goodsId},#{goodsName},#{goodsQuantity},#{goodsStatus}," +
            "#{goodsCreateTime},#{goodsDescription},#{goodsKeywords}," +
            "#{goodsPrice},#{goodsCategory})")
    void addGoods(Goods goods);

    /*
    更新一条商品数据时，除了原始价格、上架时间、id外均可更新
     */
    @Update("update goods set goodsName=#{goodsName}," +
            "goodsQuantity=#{goodsQuantity},goodsStatus=#{goodsStatus}," +
            "goodsUpdateTime=#{goodsUpdateTime}," +
            "goodsDescription=#{goodsDescription}," +
            "goodsKeywords=#{goodsKeywords}," +
            "goodsPrice=#{goodsPrice},goodsPromotion=#{goodsPromotion}," +
            "goodsCategory=#{goodsCategory}" +
            "where goodsId=#{goodsId}")
    void updateGoods(Goods goods);

    @Delete("delete from goods where goodsId=#{goodsId}")
    void delGoodsById(@Param("goodsId") int goodsId);


}