package com.neusoft.model.extraModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bruce Lee on 2017/7/29.
 */
public class Admin_order implements Serializable {
    private int orderid;

    private String goodsname;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public boolean isOrderfinished() {
        return orderfinished;
    }

    public void setOrderfinished(boolean orderfinished) {
        this.orderfinished = orderfinished;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public int getGoodcount() {
        return goodcount;
    }

    public void setGoodcount(int goodcount) {
        this.goodcount = goodcount;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    private String nickname;
    private Date ordertime;
    private boolean orderfinished;
    private double orderprice;
    private int goodcount;
    private String addressname;
}
