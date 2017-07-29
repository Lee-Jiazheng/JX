package com.neusoft.service;

import com.neusoft.model.Address;
import com.neusoft.model.Goods;
import com.neusoft.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface ISearchService {
    public static final String cacheName = "searchService";

    String splitGoodsName(String goodsName);

    public List<Goods> sortByPrice(List<Goods> goodsList, boolean flag);

    public List<Goods> sortByTime(List<Goods> goodsList, boolean flag);

    public List<Goods> sortBySales(List<Goods> goodsList, boolean flag);

    List<Goods> getGoodsByWord(String goodsName);

    List<Goods> ascByPrice(String goodsName);

    List<Goods> ascBySales(String goodsName);

    List<Goods> ascByCreateTime(String goodsName);

    List<Goods> descByPrice(String goodsName);

    List<Goods> descBySales(String goodsName);

    List<Goods> descByCreateTime(String goodsName);
}
