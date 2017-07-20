package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Category",table="category")
public class Category {

  @AutoField(alias = "categoryId", column = "category_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "category_id", column = "A")
  private int categoryId;

  @AutoField(alias = "����500��100", column = "category_name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "category_name", column = "B")
  private String categoryName;

  @AutoField(alias = "parentFlag", column = "parent_flag", isRequired = true)
  @ExcelVOAttribute(name = "parent_flag", column = "C")
  private Boolean parentFlag;

  @AutoField(alias = "parentId", column = "parent_id", type = "Integer")
  @ExcelVOAttribute(name = "parent_id", column = "D")
  private int parentId;


  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId){
    this.categoryId = categoryId;
  }
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName){
    this.categoryName = categoryName;
  }
  public Boolean getParentFlag() {
    return parentFlag;
  }
  public void setParentFlag(Boolean parentFlag){
    this.parentFlag = parentFlag;
  }
  public int getParentId() {
    return parentId;
  }
  public void setParentId(int parentId){
    this.parentId = parentId;
  }
}
