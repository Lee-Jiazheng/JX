package com.neusoft.service.impl;

import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IOrderMapper;
import com.neusoft.model.Collections;
import com.neusoft.model.Goods;
import com.neusoft.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
    static Comparator<Goods> QuantityComparator = new Comparator<Goods>() {
        @Override
        public int compare(Goods s1, Goods s2) {
            if(s1.getGoodsquantity() > s2.getGoodsquantity()){
                return 1;
            }
            else if(s1.getGoodsquantity() == s2.getGoodsquantity()){
                return 0;
            }
            else {
                return -1;
            }
        }
    };
    static Comparator<Goods> DateComparator = new Comparator<Goods>() {
        @Override
        public int compare(Goods s1, Goods s2) {
            return s1.getGoodscreatetime().compareTo(s2.getGoodscreatetime());
        }
    };
    static Comparator<Goods> DoubleComparator = new Comparator<Goods>() {
        @Override
        public int compare(Goods s1, Goods s2) {
            return s1.getGoodsprice().compareTo(s2.getGoodsprice());
        }
    };

    public List<Goods> sortByPrice(List<Goods> goodsList, boolean flag) {
        java.util.Collections.sort(goodsList,DoubleComparator);
        if (flag != true) {
            java.util.Collections.reverse(goodsList);

        }
        return goodsList;
    }

    public List<Goods> sortByTime(List<Goods> goodsList, boolean flag) {
        java.util.Collections.sort(goodsList,DateComparator);
        if (flag != true) {
            java.util.Collections.reverse(goodsList);

        }
        return goodsList;
    }

    public List<Goods> sortBySales(List<Goods> goodsList, boolean flag) {
        java.util.Collections.sort(goodsList,QuantityComparator);
        if (flag != true) {
            java.util.Collections.reverse(goodsList);

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
