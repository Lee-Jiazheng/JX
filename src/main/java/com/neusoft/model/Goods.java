package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Goods",table="goods")
public class Goods {

  @AutoField(alias = "goodsId", column = "goods_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_id", column = "A")
  private int goodsId;

  @AutoField(alias = "goodsName", column = "goods_name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goods_name", column = "B")
  private String goodsName;

  @AutoField(alias = "goodsQuantity", column = "goods_quantity", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_quantity", column = "C")
  private int goodsQuantity;

  @AutoField(alias = "��Ʒ״̬���������ڳ��ۡ�������", column = "goods_status", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_status", column = "D")
  private int goodsStatus;

  @AutoField(alias = "goodsCreateTime", column = "goods_create_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "goods_create_time", column = "E")
  private Date goodsCreateTime;

  @AutoField(alias = "goodsUpdateTime", column = "goods_update_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "goods_update_time", column = "F")
  private Date goodsUpdateTime;

  @AutoField(alias = "goodsDescription", column = "goods_description", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goods_description", column = "G")
  private String goodsDescription;

  @AutoField(alias = "��Ʒ�ؼ��֣����ڼ���", column = "goods_keywords", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goods_keywords", column = "H")
  private String goodsKeywords;

  @AutoField(alias = "goodsPrice", column = "goods_price", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_price", column = "I")
  private Double goodsPrice;

  @AutoField(alias = "��Ʒ�Ż���Ϣ", column = "goods_promotion", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_promotion", column = "J")
  private int goodsPromotion;

  @AutoField(alias = "goodsCategory", column = "goods_category", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goods_category", column = "K")
  private int goodsCategory;


  public int getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(int goodsId){
    this.goodsId = goodsId;
  }
  public String getGoodsName() {
    return goodsName;
  }
  public void setGoodsName(String goodsName){
    this.goodsName = goodsName;
  }
  public int getGoodsQuantity() {
    return goodsQuantity;
  }
  public void setGoodsQuantity(int goodsQuantity){
    this.goodsQuantity = goodsQuantity;
  }
  public int getGoodsStatus() {
    return goodsStatus;
  }
  public void setGoodsStatus(int goodsStatus){
    this.goodsStatus = goodsStatus;
  }
  public Date getGoodsCreateTime() {
    return goodsCreateTime;
  }
  public void setGoodsCreateTime(Date goodsCreateTime){
    this.goodsCreateTime = goodsCreateTime;
  }
  public Date getGoodsUpdateTime() {
    return goodsUpdateTime;
  }
  public void setGoodsUpdateTime(Date goodsUpdateTime){
    this.goodsUpdateTime = goodsUpdateTime;
  }
  public String getGoodsDescription() {
    return goodsDescription;
  }
  public void setGoodsDescription(String goodsDescription){
    this.goodsDescription = goodsDescription;
  }
  public String getGoodsKeywords() {
    return goodsKeywords;
  }
  public void setGoodsKeywords(String goodsKeywords){
    this.goodsKeywords = goodsKeywords;
  }
  public Double getGoodsPrice() {
    return goodsPrice;
  }
  public void setGoodsPrice(Double goodsPrice){
    this.goodsPrice = goodsPrice;
  }
  public int getGoodsPromotion() {
    return goodsPromotion;
  }
  public void setGoodsPromotion(int goodsPromotion){
    this.goodsPromotion = goodsPromotion;
  }
  public int getGoodsCategory() {
    return goodsCategory;
  }
  public void setGoodsCategory(int goodsCategory){
    this.goodsCategory = goodsCategory;
  }
}
