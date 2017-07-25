package com.neusoft.model.extraModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bruce Lee on 2017/7/25.
 */
public class OrderWithGood_Goodpicture implements Serializable{

    private int orderid;
    private Date ordertime;



    private String orderStatus;
    private Double orderprice;
    private int amount;
    private String photo;
    private String goodsname;

    public double getReilGoodPrice() {
        return reilGoodPrice;
    }

    public void setReilGoodPrice(double reilGoodPrice) {
        this.reilGoodPrice = reilGoodPrice;
    }

    private double reilGoodPrice;

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }



    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
