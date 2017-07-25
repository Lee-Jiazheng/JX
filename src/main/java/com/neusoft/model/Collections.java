package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Collections",table="collections")
public class Collections  implements Serializable {

  @AutoField(alias = "���", column = "user", isKey = true , isRequired = true , type="Integer", length=0)
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
