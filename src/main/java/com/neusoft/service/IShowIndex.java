package com.neusoft.service;

import com.neusoft.model.extraModel.GoodsWithPhotos;
import java.util.List;

/**
 * Created by 85715 on 2017/7/26.
 */
public interface IShowIndex {

    public List<GoodsWithPhotos> getNewProduct();
    public List<GoodsWithPhotos> getPopProduct();
}
