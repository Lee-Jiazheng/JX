package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Goodsphoto",table="goodsphoto")
public class Goodsphoto  implements Serializable {

  @AutoField(alias = "photoid", column = "photoid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "photoid", column = "A")
  private int photoid;

  @AutoField(alias = "goods", column = "goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods", column = "B")
  private int goods;

  @AutoField(alias = "photo", column = "photo", length = 255)
  @ExcelVOAttribute(name = "photo", column = "C")
  private String photo;


  public int getPhotoid() {
    return photoid;
  }
  public void setPhotoid(int photoid){
    this.photoid = photoid;
  }
  public int getGoods() {
    return goods;
  }
  public void setGoods(int goods){
    this.goods = goods;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo){
    this.photo = photo;
  }
}
