package com.neusoft.service.impl;

import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IIndexMapper;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.GoodsWithPhotos;
import com.neusoft.service.IShowIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85715 on 2017/7/26.
 */
@Service("iShowIndex")
@Transactional
public class ShowIndex implements IShowIndex {
    @Autowired
    private IIndexMapper indexMapper;

    @Override
    public List<GoodsWithPhotos> getNewProduct(){
        List<Goods> goodsList =indexMapper.getTopEightNew();
        List<GoodsWithPhotos> goodsWithPhotosList =new ArrayList<GoodsWithPhotos>();
        for(Goods goods:goodsList){
            GoodsWithPhotos goodsWithPhotos =new GoodsWithPhotos();
            goodsWithPhotos.setPhoto(indexMapper.getPhotoByGoodID(goods.getGoodsid()));
            goodsWithPhotos.setGoodsid(goods.getGoodsid());
            goodsWithPhotos.setGoodsname(goods.getGoodsname());
            goodsWithPhotos.setGoodsprice(goods.getGoodsprice());
            goodsWithPhotosList.add(goodsWithPhotos);
        }
        return goodsWithPhotosList;
    }

    @Override
    public List<GoodsWithPhotos> getPopProduct(){
        Goods goods=new Goods();
        ArrayList<Integer> integerArrayList=indexMapper.getTopSevenPopIDs();
        List<GoodsWithPhotos> goodsWithPhotosList=new ArrayList<GoodsWithPhotos>();
        for(Integer integer:integerArrayList){
            GoodsWithPhotos goodsWithPhotos=new GoodsWithPhotos();
            goods=indexMapper.getTopPop(integer.intValue());
            goodsWithPhotos.setPhoto(indexMapper.getPhotoByGoodID(goods.getGoodsid()));
            goodsWithPhotos.setGoodsid(goods.getGoodsid());
            goodsWithPhotos.setGoodsname(goods.getGoodsname());
            goodsWithPhotos.setGoodsprice(goods.getGoodsprice());
            goodsWithPhotosList.add(goodsWithPhotos);
        }
        return goodsWithPhotosList;
    }


}
