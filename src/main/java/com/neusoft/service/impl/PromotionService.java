package com.neusoft.service.impl;

import com.neusoft.mapper.IOrderMapper;
import com.neusoft.mapper.IPromotionMapper;
import com.neusoft.model.Promotion;
import com.neusoft.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("promotionService")
@Transactional
public class PromotionService implements IPromotionService {

    @Autowired
    private IPromotionMapper promotionMapper;
    @Override
    public void addPromotion(Promotion promotion) {
        promotionMapper.addPromotion(promotion);
    }

    @Override
    public void delPromotion(int promotionId) {
        promotionMapper.delPromotionById(promotionId);
    }

    @Override
    public void updatePromotionn(Promotion promotion) {
        promotionMapper.updatePromotion(promotion);
    }

    @Override
    public Promotion getPromotion(int promotionId) {
        return promotionMapper.getPromotion(promotionId);
    }

    @Override
    public List<Promotion> getAllPromotion(){
        return promotionMapper.getAllPromotion();
    }
}
