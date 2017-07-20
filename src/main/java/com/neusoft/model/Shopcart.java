package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "Shopcart",table="shopcart")
public class Shopcart {

  @AutoField(alias = "shopcartBuyer", column = "shopcart_buyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "shopcart_buyer", column = "A")
  private int shopcartBuyer;

  @AutoField(alias = "shopcartGoods", column = "shopcart_goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "shopcart_goods", column = "B")
  private int shopcartGoods;

  @AutoField(alias = "shopcartTime", column = "shopcart_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "shopcart_time", column = "C")
  private Date shopcartTime;


  public int getShopcartBuyer() {
    return shopcartBuyer;
  }
  public void setShopcartBuyer(int shopcartBuyer){
    this.shopcartBuyer = shopcartBuyer;
  }
  public int getShopcartGoods() {
    return shopcartGoods;
  }
  public void setShopcartGoods(int shopcartGoods){
    this.shopcartGoods = shopcartGoods;
  }
  public Date getShopcartTime() {
    return shopcartTime;
  }
  public void setShopcartTime(Date shopcartTime){
    this.shopcartTime = shopcartTime;
  }
}
