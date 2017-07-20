package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Order",table="order")
public class Order {

  @AutoField(alias = "orderId", column = "order_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "order_id", column = "A")
  private int orderId;

  @AutoField(alias = "orderGoods", column = "order_goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "order_goods", column = "B")
  private int orderGoods;

  @AutoField(alias = "orderBuyer", column = "order_buyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "order_buyer", column = "C")
  private int orderBuyer;

  @AutoField(alias = "orderTime", column = "order_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "order_time", column = "D")
  private Date orderTime;

  @AutoField(alias = "orderFinished", column = "order_finished", isRequired = true)
  @ExcelVOAttribute(name = "order_finished", column = "E")
  private Boolean orderFinished;

  @AutoField(alias = "orderDestination", column = "order_destination", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "order_destination", column = "F")
  private String orderDestination;

  @AutoField(alias = "�����ɽ�ʱ����Ʒ�۸�", column = "order_price", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "order_price", column = "G")
  private Double orderPrice;

  @AutoField(alias = "orderCompany", column = "order_company", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "order_company", column = "H")
  private String orderCompany;


  public int getOrderId() {
    return orderId;
  }
  public void setOrderId(int orderId){
    this.orderId = orderId;
  }
  public int getOrderGoods() {
    return orderGoods;
  }
  public void setOrderGoods(int orderGoods){
    this.orderGoods = orderGoods;
  }
  public int getOrderBuyer() {
    return orderBuyer;
  }
  public void setOrderBuyer(int orderBuyer){
    this.orderBuyer = orderBuyer;
  }
  public Date getOrderTime() {
    return orderTime;
  }
  public void setOrderTime(Date orderTime){
    this.orderTime = orderTime;
  }
  public Boolean getOrderFinished() {
    return orderFinished;
  }
  public void setOrderFinished(Boolean orderFinished){
    this.orderFinished = orderFinished;
  }
  public String getOrderDestination() {
    return orderDestination;
  }
  public void setOrderDestination(String orderDestination){
    this.orderDestination = orderDestination;
  }
  public Double getOrderPrice() {
    return orderPrice;
  }
  public void setOrderPrice(Double orderPrice){
    this.orderPrice = orderPrice;
  }
  public String getOrderCompany() {
    return orderCompany;
  }
  public void setOrderCompany(String orderCompany){
    this.orderCompany = orderCompany;
  }
}
