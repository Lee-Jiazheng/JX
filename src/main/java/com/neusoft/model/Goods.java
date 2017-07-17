package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "Goods",table="goods")
public class Goods {

  @AutoField(alias = "id", column = "id", isKey = true , isRequired = true , type="Integer", length=0)
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "name", column = "name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "name", column = "B")
  private String name;

  @AutoField(alias = "quantity", column = "quantity", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "quantity", column = "C")
  private int quantity;

  @AutoField(alias = "categoryId", column = "category_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "category_id", column = "D")
  private int categoryId;

  @AutoField(alias = "status", column = "status", type = "Integer")
  @ExcelVOAttribute(name = "status", column = "E")
  private int status;

  @AutoField(alias = "useFlag", column = "use_flag")
  @ExcelVOAttribute(name = "use_flag", column = "F")
  private Boolean useFlag;

  @AutoField(alias = "createTime", column = "create_time", type = "Date")
  @ExcelVOAttribute(name = "create_time", column = "G")
  private Date createTime;

  @AutoField(alias = "updateTime", column = "update_time", type = "Date")
  @ExcelVOAttribute(name = "update_time", column = "H")
  private Date updateTime;

  @AutoField(alias = "description", column = "description", length = 45)
  @ExcelVOAttribute(name = "description", column = "I")
  private String description;

  @AutoField(alias = "keywords", column = "keywords", length = 45)
  @ExcelVOAttribute(name = "keywords", column = "J")
  private String keywords;

  @AutoField(alias = "originalPrice", column = "original_price", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "original_price", column = "K")
  private int originalPrice;

  @AutoField(alias = "currentPrice", column = "current_price", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "current_price", column = "L")
  private int currentPrice;


  public int getId() {
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId){
    this.categoryId = categoryId;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status){
    this.status = status;
  }
  public Boolean getUseFlag() {
    return useFlag;
  }
  public void setUseFlag(Boolean useFlag){
    this.useFlag = useFlag;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime){
    this.createTime = createTime;
  }
  public Date getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description){
    this.description = description;
  }
  public String getKeywords() {
    return keywords;
  }
  public void setKeywords(String keywords){
    this.keywords = keywords;
  }
  public int getOriginalPrice() {
    return originalPrice;
  }
  public void setOriginalPrice(int originalPrice){
    this.originalPrice = originalPrice;
  }
  public int getCurrentPrice() {
    return currentPrice;
  }
  public void setCurrentPrice(int currentPrice){
    this.currentPrice = currentPrice;
  }
}
