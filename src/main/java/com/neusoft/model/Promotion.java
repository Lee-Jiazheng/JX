package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

@AutoBean(alias = "Promotion",table="promotion")
public class Promotion {

  @AutoField(alias = "id", column = "id", isKey = true , isRequired = true , type="Integer", length=0)
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "name", column = "name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "name", column = "B")
  private String name;

  @AutoField(alias = "threshold", column = "threshold", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "threshold", column = "C")
  private int threshold;

  @AutoField(alias = "deduction", column = "deduction", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "deduction", column = "D")
  private int deduction;

  @AutoField(alias = "scope", column = "scope", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "scope", column = "E")
  private int scope;


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
  public int getThreshold() {
    return threshold;
  }
  public void setThreshold(int threshold){
    this.threshold = threshold;
  }
  public int getDeduction() {
    return deduction;
  }
  public void setDeduction(int deduction){
    this.deduction = deduction;
  }
  public int getScope() {
    return scope;
  }
  public void setScope(int scope){
    this.scope = scope;
  }
}
