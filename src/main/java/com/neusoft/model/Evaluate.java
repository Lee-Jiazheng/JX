package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

@AutoBean(alias = "Evaluate",table="evaluate")
public class Evaluate {

  @AutoField(alias = "goodsId", column = "goods_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_id", column = "A")
  private int goodsId;

  @AutoField(alias = "evaluation", column = "evaluation", length = 65535)
  @ExcelVOAttribute(name = "evaluation", column = "B")
  private String evaluation;

  @AutoField(alias = "buyerId", column = "buyer_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "buyer_id", column = "C")
  private int buyerId;


  public int getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(int goodsId){
    this.goodsId = goodsId;
  }
  public String getEvaluation() {
    return evaluation;
  }
  public void setEvaluation(String evaluation){
    this.evaluation = evaluation;
  }
  public int getBuyerId() {
    return buyerId;
  }
  public void setBuyerId(int buyerId){
    this.buyerId = buyerId;
  }
}
