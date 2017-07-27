package com.neusoft.service;

import com.neusoft.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IGoodsManagerService {
    public List<Goods> getAllGoods();

    public Goods getGoods(int goodsId);

    void addGoodsPhoto(int goodsId,String photo);

    void delGoodsPhoto(int goodsId);

    List<Goods> getGoodsByWord(String goodsName);
    /*
    插入一条商品数据时，必须给出名字和数量、种类、原始价格
    自动加上id、时间、状态
     */
    void addGoods(Goods goods);

    /*
    更新一条商品数据时，除了原始价格、上架时间、id外均可更新
     */
    void updateGoods(Goods goods);

    void delGoodsById(int goodsId);

}
