package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

@AutoBean(alias = "Promotion",table="promotion")
public class Promotion {

  @AutoField(alias = "promotionId", column = "promotion_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotion_id", column = "A")
  private int promotionId;

  @AutoField(alias = "promotionName", column = "promotion_name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "promotion_name", column = "B")
  private String promotionName;

  @AutoField(alias = "promotionThreshold", column = "promotion_threshold", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotion_threshold", column = "C")
  private Double promotionThreshold;

  @AutoField(alias = "promotionDeduction", column = "promotion_deduction", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "promotion_deduction", column = "D")
  private Double promotionDeduction;

  @AutoField(alias = "effectiveTime", column = "effective_time", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "effective_time", column = "E")
  private int effectiveTime;


  public int getPromotionId() {
    return promotionId;
  }
  public void setPromotionId(int promotionId){
    this.promotionId = promotionId;
  }
  public String getPromotionName() {
    return promotionName;
  }
  public void setPromotionName(String promotionName){
    this.promotionName = promotionName;
  }
  public Double getPromotionThreshold() {
    return promotionThreshold;
  }
  public void setPromotionThreshold(Double promotionThreshold){
    this.promotionThreshold = promotionThreshold;
  }
  public Double getPromotionDeduction() {
    return promotionDeduction;
  }
  public void setPromotionDeduction(Double promotionDeduction){
    this.promotionDeduction = promotionDeduction;
  }
  public int getEffectiveTime() {
    return effectiveTime;
  }
  public void setEffectiveTime(int effectiveTime){
    this.effectiveTime = effectiveTime;
  }
}
