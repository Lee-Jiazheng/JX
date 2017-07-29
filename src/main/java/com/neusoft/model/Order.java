package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Order",table="order")
public class Order  implements Serializable {

  @AutoField(alias = "orderid", column = "orderid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "orderid", column = "A")
  private int orderid;

  @AutoField(alias = "ordergoods", column = "ordergoods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "ordergoods", column = "B")
  private int ordergoods;

  @AutoField(alias = "orderbuyer", column = "orderbuyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "orderbuyer", column = "C")
  private int orderbuyer;

  @AutoField(alias = "ordertime", column = "ordertime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "ordertime", column = "D")
  private Date ordertime;

  @AutoField(alias = "orderfinished", column = "orderfinished", isRequired = true)
  @ExcelVOAttribute(name = "orderfinished", column = "E")
  private Boolean orderfinished;

  @AutoField(alias = "orderdestination", column = "orderdestination", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "orderdestination", column = "F")
  private String orderdestination;

  @AutoField(alias = "�����ɽ�ʱ����Ʒ�۸�", column = "orderprice", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "orderprice", column = "G")
  private Double orderprice;

  @AutoField(alias = "ordercompany", column = "ordercompany", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "ordercompany", column = "H")
  private String ordercompany;

  public int getAddressid() {
    return addressid;
  }

  public void setAddressid(int addressid) {
    this.addressid = addressid;
  }

  private int addressid;

  public int getGoodcount() {
    return goodcount;
  }

  public void setGoodcount(int goodcount) {
    this.goodcount = goodcount;
  }

  private int goodcount;

  public boolean getIscommented() {
    return iscommented;
  }

  public void setIscommented(boolean iscommented) {
    this.iscommented = iscommented;
  }

  private boolean iscommented;


  public int getOrderid() {
    return orderid;
  }
  public void setOrderid(int orderid){
    this.orderid = orderid;
  }
  public int getOrdergoods() {
    return ordergoods;
  }
  public void setOrdergoods(int ordergoods){
    this.ordergoods = ordergoods;
  }
  public int getOrderbuyer() {
    return orderbuyer;
  }
  public void setOrderbuyer(int orderbuyer){
    this.orderbuyer = orderbuyer;
  }
  public Date getOrdertime() {
    return ordertime;
  }
  public void setOrdertime(Date ordertime){
    this.ordertime = ordertime;
  }
  public Boolean getOrderfinished() {
    return orderfinished;
  }
  public void setOrderfinished(Boolean orderfinished){
    this.orderfinished = orderfinished;
  }
  public String getOrderdestination() {
    return orderdestination;
  }
  public void setOrderdestination(String orderdestination){
    this.orderdestination = orderdestination;
  }
  public Double getOrderprice() {
    return orderprice;
  }
  public void setOrderprice(Double orderprice){
    this.orderprice = orderprice;
  }
  public String getOrdercompany() {
    return ordercompany;
  }
  public void setOrdercompany(String ordercompany){
    this.ordercompany = ordercompany;
  }
}
