package com.neusoft.model.extraModel;

import com.neusoft.model.Goods;

import java.io.Serializable;

/**
 * Created by 85715 on 2017/7/26.
 */
public class GoodsWithPhotos extends Goods implements  Serializable {

    private String photo;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) { this.photo = photo; }
}
