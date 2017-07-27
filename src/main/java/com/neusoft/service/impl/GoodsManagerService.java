package com.neusoft.service.impl;

import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IGoodsPhotoMapper;
import com.neusoft.mapper.IOrderMapper;
import com.neusoft.model.Goods;
import com.neusoft.model.Goodsphoto;
import com.neusoft.service.IGoodsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("goodsManagerService")
@Transactional
public class GoodsManagerService implements IGoodsManagerService {
    @Autowired
    private IGoodsMapper goodsMapper;
    @Autowired
    private IGoodsPhotoMapper goodsPhotoMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public Goods getGoods(int goodsId) {
        return goodsMapper.getGoods(goodsId);
    }

    @Override
    public void addGoodsPhoto(int goodsId, String photo) {
        Goodsphoto singleGoodsPhoto = new Goodsphoto();
        singleGoodsPhoto.setGoods(goodsId);
        singleGoodsPhoto.setPhoto(photo);
        goodsPhotoMapper.addGoodsPhoto(singleGoodsPhoto);
    }

    @Override
    public void delGoodsPhoto(int goodsId) {
        goodsPhotoMapper.delGoodsPhoto(goodsId);
    }

    @Override
    public List<Goods> getGoodsByWord(String goodsName) {
        return goodsMapper.getGoodsByWord(goodsName);
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public void delGoodsById(int goodsId) {
        goodsMapper.delGoodsById(goodsId);
    }
}
