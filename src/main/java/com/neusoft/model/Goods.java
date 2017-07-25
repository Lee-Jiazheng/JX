package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Goods",table="goods")
public class Goods  implements Serializable {

  @AutoField(alias = "goodsid", column = "goodsid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodsid", column = "A")
  private int goodsid;

  @AutoField(alias = "goodsname", column = "goodsname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goodsname", column = "B")
  private String goodsname;

  @AutoField(alias = "goodsquantity", column = "goodsquantity", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodsquantity", column = "C")
  private int goodsquantity;

  @AutoField(alias = "��Ʒ״̬���������ڳ��ۡ�������", column = "goodsstatus", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodsstatus", column = "D")
  private int goodsstatus;

  @AutoField(alias = "goodscreatetime", column = "goodscreatetime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "goodscreatetime", column = "E")
  private Date goodscreatetime;

  @AutoField(alias = "goodsupdatetime", column = "goodsupdatetime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "goodsupdatetime", column = "F")
  private Date goodsupdatetime;

  @AutoField(alias = "goodsdescription", column = "goodsdescription", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goodsdescription", column = "G")
  private String goodsdescription;

  @AutoField(alias = "��Ʒ�ؼ��֣����ڼ���", column = "goodskeywords", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "goodskeywords", column = "H")
  private String goodskeywords;

  @AutoField(alias = "goodsprice", column = "goodsprice", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodsprice", column = "I")
  private Double goodsprice;

  @AutoField(alias = "��Ʒ�Ż���Ϣ", column = "goodspromotion", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodspromotion", column = "J")
  private int goodspromotion;

  @AutoField(alias = "goodscategory", column = "goodscategory", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "goodscategory", column = "K")
  private int goodscategory;


  public int getGoodsid() {
    return goodsid;
  }
  public void setGoodsid(int goodsid){
    this.goodsid = goodsid;
  }
  public String getGoodsname() {
    return goodsname;
  }
  public void setGoodsname(String goodsname){
    this.goodsname = goodsname;
  }
  public int getGoodsquantity() {
    return goodsquantity;
  }
  public void setGoodsquantity(int goodsquantity){
    this.goodsquantity = goodsquantity;
  }
  public int getGoodsstatus() {
    return goodsstatus;
  }
  public void setGoodsstatus(int goodsstatus){
    this.goodsstatus = goodsstatus;
  }
  public Date getGoodscreatetime() {
    return goodscreatetime;
  }
  public void setGoodscreatetime(Date goodscreatetime){
    this.goodscreatetime = goodscreatetime;
  }
  public Date getGoodsupdatetime() {
    return goodsupdatetime;
  }
  public void setGoodsupdatetime(Date goodsupdatetime){
    this.goodsupdatetime = goodsupdatetime;
  }
  public String getGoodsdescription() {
    return goodsdescription;
  }
  public void setGoodsdescription(String goodsdescription){
    this.goodsdescription = goodsdescription;
  }
  public String getGoodskeywords() {
    return goodskeywords;
  }
  public void setGoodskeywords(String goodskeywords){
    this.goodskeywords = goodskeywords;
  }
  public Double getGoodsprice() {
    return goodsprice;
  }
  public void setGoodsprice(Double goodsprice){
    this.goodsprice = goodsprice;
  }
  public int getGoodspromotion() {
    return goodspromotion;
  }
  public void setGoodspromotion(int goodspromotion){
    this.goodspromotion = goodspromotion;
  }
  public int getGoodscategory() {
    return goodscategory;
  }
  public void setGoodscategory(int goodscategory){
    this.goodscategory = goodscategory;
  }
}
