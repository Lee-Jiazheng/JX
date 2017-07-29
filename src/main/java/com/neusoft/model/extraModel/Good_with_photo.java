package com.neusoft.model.extraModel;

import com.neusoft.model.Goodsphoto;

import java.util.Date;

/**
 * Created by Bruce Lee on 2017/7/26.
 */
public class Good_with_photo {
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    private String goodsname;
    private int goodsid;
    private int goodsquantity;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public int getGoodsquantity() {
        return goodsquantity;
    }

    public void setGoodsquantity(int goodsquantity) {
        this.goodsquantity = goodsquantity;
    }

    public Date getGoodscreatetime() {
        return goodscreatetime;
    }

    public void setGoodscreatetime(Date goodscreatetime) {
        this.goodscreatetime = goodscreatetime;
    }

    public String getGoodsdescription() {
        return goodsdescription;
    }

    public void setGoodsdescription(String goodsdescription) {
        this.goodsdescription = goodsdescription;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Goodsphoto getPhoto() {
        return photo;
    }

    public void setPhoto(Goodsphoto photo) {
        this.photo = photo;
    }

    private Date goodscreatetime;
    private String goodsdescription;
    private Double goodsprice;
    private Goodsphoto photo;

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    private int order_count;
}
