package com.neusoft.service;

import com.neusoft.model.Goods;
import com.neusoft.model.Promotion;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
public interface IPromotionService {
    public void addPromotion(Promotion promotion);

    public void delPromotion(int promotionId);

    public void updatePromotionn(Promotion promotion);

    public List<Promotion> getAllPromotion();

    public Promotion getPromotion(int promotionId);
}
