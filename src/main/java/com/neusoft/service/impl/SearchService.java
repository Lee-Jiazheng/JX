package com.neusoft.service.impl;

import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IOrderMapper;
import com.neusoft.model.Goods;
import com.neusoft.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("searchService")
@Transactional
public class SearchService implements ISearchService {
    @Autowired
    private IOrderMapper orderMapper;
    @Autowired
    private IGoodsMapper goodsMapper;


    public String splitGoodsName(String goodsName) {
        String[] goodsNameChars = goodsName.split("");
        goodsName = "%";
        for (int i = 0; i < goodsNameChars.length; ++i) {
            goodsName = goodsName.concat(goodsNameChars[i]);
            goodsName = goodsName.concat("%");
        }
        return goodsName;
    }

    public List<Goods> sortByPrice(List<Goods> goodsList, boolean flag) {
        int size = goodsList.size();
        for (int i = 0; i < size; ++i) {
            int max = 0;
            for (int j = 0; j < size - i; ++j) {
                if (flag == true) {
                    if (goodsList.get(max).getGoodsprice() <= goodsList.get(j)
                            .getGoodsprice()) {
                        Double tmp = goodsList.get(max).getGoodsprice();
                        goodsList.get(max).setGoodsprice(goodsList.get(j)
                                .getGoodsprice());
                        goodsList.get(j).setGoodsprice(tmp);
                    }
                }
                else{
                    if (goodsList.get(max).getGoodsprice() > goodsList.get(j)
                            .getGoodsprice()) {
                        Double tmp = goodsList.get(max).getGoodsprice();
                        goodsList.get(max).setGoodsprice(goodsList.get(j)
                                .getGoodsprice());
                        goodsList.get(j).setGoodsprice(tmp);
                    }
                }
            }
        }
        return goodsList;
    }


    public List<Goods> sortByTime(List<Goods> goodsList, boolean flag) {
        int size = goodsList.size();
        for (int i = 0; i < size; ++i) {
            int max = 0;
            for (int j = 0; j < size - i; ++j) {
                if (flag == true) {
                    if ((goodsList.get(max).getGoodscreatetime().compareTo
                            (goodsList.get(j).getGoodscreatetime())) >= 0) {
                        Date tmp = goodsList.get(max).getGoodscreatetime();
                        goodsList.get(max).setGoodscreatetime(goodsList.get(j)
                                .getGoodscreatetime());
                        goodsList.get(j).setGoodscreatetime(tmp);
                    }
                }
                else{
                    if ((goodsList.get(max).getGoodscreatetime().compareTo
                            (goodsList.get(j).getGoodscreatetime())) < 0) {
                        Date tmp = goodsList.get(max).getGoodscreatetime();
                        goodsList.get(max).setGoodscreatetime(goodsList.get(j)
                                .getGoodscreatetime());
                        goodsList.get(j).setGoodscreatetime(tmp);
                    }
                }
            }
        }
        return goodsList;
    }

    public List<Goods> sortBySales(List<Goods> goodsList, boolean flag) {
        int size = goodsList.size();
        for (int i = 0; i < size; ++i) {
            int max = 0;
            for (int j = 0; j < size - i; ++j) {
                if(flag == true) {
                    if ((goodsList.get(max).getGoodsquantity() >
                            (goodsList.get(j).getGoodsquantity()))) {
                        int tmp = goodsList.get(max).getGoodsquantity();
                        goodsList.get(max).setGoodsquantity(goodsList.get(j)
                                .getGoodsquantity());
                        goodsList.get(j).setGoodsquantity(tmp);
                    }
                }
                else {
                    if ((goodsList.get(max).getGoodsquantity() <
                            (goodsList.get(j).getGoodsquantity()))) {
                        int tmp = goodsList.get(max).getGoodsquantity();
                        goodsList.get(max).setGoodsquantity(goodsList.get(j)
                                .getGoodsquantity());
                        goodsList.get(j).setGoodsquantity(tmp);
                    }
                }
            }
        }
        return goodsList;
    }

    public List<Goods> getGoodsByWord(String goodsName) {
        String goods = splitGoodsName(goodsName);
        return goodsMapper.getGoodsByWord(goods);
    }

    public List<Goods> ascByPrice(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortByPrice(goodsList, true);
        return goodsList;
    }

    public List<Goods> ascBySales(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortBySales(goodsList, true);
        return goodsList;
    }

    public List<Goods> ascByCreateTime(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortByTime(goodsList, true);
        return goodsList;
    }

    public List<Goods> descByPrice(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortByPrice(goodsList, false);
        return goodsList;
    }

    public List<Goods> descBySales(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortBySales(goodsList, false);
        return goodsList;
    }

    public List<Goods> descByCreateTime(String goodsName) {
        List<Goods> goodsList = getGoodsByWord(goodsName);
        goodsList = sortByTime(goodsList, false);
        return goodsList;
    }
}
