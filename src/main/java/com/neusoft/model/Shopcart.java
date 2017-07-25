package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Shopcart",table="shopcart")
public class Shopcart  implements Serializable {

  @AutoField(alias = "shopcartbuyer", column = "shopcartbuyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "shopcartbuyer", column = "A")
  private int shopcartbuyer;

  @AutoField(alias = "shopcartgoods", column = "shopcartgoods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "shopcartgoods", column = "B")
  private int shopcartgoods;

  @AutoField(alias = "shopcarttime", column = "shopcarttime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "shopcarttime", column = "C")
  private Date shopcarttime;


  public int getShopcartbuyer() {
    return shopcartbuyer;
  }
  public void setShopcartbuyer(int shopcartbuyer){
    this.shopcartbuyer = shopcartbuyer;
  }
  public int getShopcartgoods() {
    return shopcartgoods;
  }
  public void setShopcartgoods(int shopcartgoods){
    this.shopcartgoods = shopcartgoods;
  }
  public Date getShopcarttime() {
    return shopcarttime;
  }
  public void setShopcarttime(Date shopcarttime){
    this.shopcarttime = shopcarttime;
  }
}
