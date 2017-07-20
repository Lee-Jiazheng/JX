package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "Collections",table="collections")
public class Collections {

  @AutoField(alias = "user", column = "user", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "user", column = "A")
  private int user;

  @AutoField(alias = "goods", column = "goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods", column = "B")
  private int goods;

  @AutoField(alias = "time", column = "time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "time", column = "C")
  private Date time;


  public int getUser() {
    return user;
  }
  public void setUser(int user){
    this.user = user;
  }
  public int getGoods() {
    return goods;
  }
  public void setGoods(int goods){
    this.goods = goods;
  }
  public Date getTime() {
    return time;
  }
  public void setTime(Date time){
    this.time = time;
  }
}
