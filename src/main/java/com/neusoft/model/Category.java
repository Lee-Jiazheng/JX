package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Category",table="category")
public class Category implements Serializable{

  @AutoField(alias = "categoryid", column = "categoryid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "categoryid", column = "A")
  private int categoryid;

  @AutoField(alias = "����500��100", column = "categoryname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "categoryname", column = "B")
  private String categoryname;

  @AutoField(alias = "parentflag", column = "parentflag", isRequired = true)
  @ExcelVOAttribute(name = "parentflag", column = "C")
  private Boolean parentflag;

  @AutoField(alias = "parentid", column = "parentid", type = "Integer")
  @ExcelVOAttribute(name = "parentid", column = "D")
  private int parentid;


  public int getCategoryid() {
    return categoryid;
  }
  public void setCategoryid(int categoryid){
    this.categoryid = categoryid;
  }
  public String getCategoryname() {
    return categoryname;
  }
  public void setCategoryname(String categoryname){
    this.categoryname = categoryname;
  }
  public Boolean getParentflag() {
    return parentflag;
  }
  public void setParentflag(Boolean parentflag){
    this.parentflag = parentflag;
  }
  public int getParentid() {
    return parentid;
  }
  public void setParentid(int parentid){
    this.parentid = parentid;
  }
}
