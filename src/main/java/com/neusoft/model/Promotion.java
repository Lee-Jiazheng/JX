package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Promotion",table="promotion")
public class Promotion  implements Serializable {

  @AutoField(alias = "promotionid", column = "promotionid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotionid", column = "A")
  private int promotionid;

  @AutoField(alias = "", column = "promotionname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "promotionname", column = "B")
  private String promotionname;

  @AutoField(alias = "???????", column = "promotionthreshold", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotionthreshold", column = "C")
  private Double promotionthreshold;

  @AutoField(alias = "????????", column = "promotiondeduction", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotiondeduction", column = "D")
  private Double promotiondeduction;

  @AutoField(alias = "???????????????15??", column = "effectivetime", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "effectivetime", column = "E")
  private int effectivetime;


  public int getPromotionid() {
    return promotionid;
  }
  public void setPromotionid(int promotionid){
    this.promotionid = promotionid;
  }
  public String getPromotionname() {
    return promotionname;
  }
  public void setPromotionname(String promotionname){
    this.promotionname = promotionname;
  }
  public Double getPromotionthreshold() {
    return promotionthreshold;
  }
  public void setPromotionthreshold(Double promotionthreshold){
    this.promotionthreshold = promotionthreshold;
  }
  public Double getPromotiondeduction() {
    return promotiondeduction;
  }
  public void setPromotiondeduction(Double promotiondeduction){
    this.promotiondeduction = promotiondeduction;
  }
  public int getEffectivetime() {
    return effectivetime;
  }
  public void setEffectivetime(int effectivetime){
    this.effectivetime = effectivetime;
  }
}
