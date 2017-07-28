package com.neusoft.mapper;

import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IGoodsMapper {
    @Select("select * from goods")
    public List<Goods> getAllGoods();

    @Select("select * from goods where goodsid= #{goodsid}")
    public Goods getGoods(@Param("goodsid") int goodsid);


    @Select("select * from goods where goodscategory=#{goodscategory}")
    List<Goods> getGoodsByCategory(@Param("goodscategory") int goodscategory);


    @Select("select * from goods where (goodsname like #{goodsname}" +
            "or goodsKeywords like #{goodsname})")
    List<Goods> getGoodsByWord(@Param("goodsname") String goodsname);
    /*
    插入一条商品数据时，必须给出名字和数量、种类、原始价格
    自动加上id、时间、状态
     */
    @Insert("insert into goods(goodsid,goodsname,goodsquantity,goodsstatus," +
            "goodscreatetime,goodsdescription,goodskeywords," +
            "goodsprice,goodscategory) " +
            "values(#{goodsid},#{goodsname},#{goodsquantity},#{goodsstatus}," +
            "#{goodscreatetime},#{goodsdescription},#{goodskeywords}," +
            "#{goodsprice},#{goodscategory})")
    void addGoods(Goods goods);

    /*
    更新一条商品数据时，除了原始价格、上架时间、id外均可更新
     */
    @Update("update goods set goodsname=#{goodsname}," +
            "goodsquantity=#{goodsquantity},goodsstatus=#{goodsstatus}," +
            "goodsupdatetime=#{goodsupdatetime}," +
            "goodsdescription=#{goodsdescription}," +
            "goodskeywords=#{goodskeywords}," +
            "goodsprice=#{goodsprice},goodspromotion=#{goodspromotion}," +
            "goodscategory=#{goodscategory}" +
            "where goodsid=#{goodsid}")
    void updateGoods(Goods goods);

    @Delete("delete from goods where goodsid=#{goodsid}")
    void delGoodsById(@Param("goodsid") int goodsid);

    @Select("select goodsid from goods where goodsname = #{goodsname}")
    int getGoodsIdByGoodsName(String goodsname);

}