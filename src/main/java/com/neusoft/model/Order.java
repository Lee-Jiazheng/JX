package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "Order",table="order")
public class Order {

  @AutoField(alias = "id", column = "id", isKey = true , isRequired = true , type="Integer", length=0)
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "goods", column = "goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods", column = "B")
  private int goods;

  @AutoField(alias = "buyer", column = "buyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "buyer", column = "C")
  private int buyer;

  @AutoField(alias = "time", column = "time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "time", column = "D")
  private Date time;

  @AutoField(alias = "isFinished", column = "is_finished", isRequired = true)
  @ExcelVOAttribute(name = "is_finished", column = "E")
  private Boolean isFinished;

  @AutoField(alias = "destiny", column = "destiny", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "destiny", column = "F")
  private String destiny;

  @AutoField(alias = "price", column = "price", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "price", column = "G")
  private int price;


  public int getId() {
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public int getGoods() {
    return goods;
  }
  public void setGoods(int goods){
    this.goods = goods;
  }
  public int getBuyer() {
    return buyer;
  }
  public void setBuyer(int buyer){
    this.buyer = buyer;
  }
  public Date getTime() {
    return time;
  }
  public void setTime(Date time){
    this.time = time;
  }
  public Boolean getIsFinished() {
    return isFinished;
  }
  public void setIsFinished(Boolean isFinished){
    this.isFinished = isFinished;
  }
  public String getDestiny() {
    return destiny;
  }
  public void setDestiny(String destiny){
    this.destiny = destiny;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price){
    this.price = price;
  }
}
