package com.neusoft.mapper;

import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85715 on 2017/7/26.
 */
public interface IIndexMapper {
    @Select("select * from goods order by goodscreatetime desc limit 0,8")
    public List<Goods> getTopEightNew();

    @Select("select photo from goodsphoto where goods=#{goodID}")
    public String getPhotoByGoodID(@Param("goodID") int goodID);

    @Select("select * from goods where goodsid=#{goodID}")
    public Goods getTopPop(@Param("goodID") int goodID);

    @Select("select ordergoods from myorder group by ordergoods order by count(ordergoods) desc limit 0,7")
    public ArrayList<Integer> getTopSevenPopIDs();
}
