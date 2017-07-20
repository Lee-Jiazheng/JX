package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "AdminUser",table="admin_user")
public class AdminUser {

  @AutoField(alias = "id", column = "id", type = "Integer")
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "adminName", column = "admin_name", isRequired = true, length = 20)
  @ExcelVOAttribute(name = "admin_name", column = "B")
  private String adminName;

  @AutoField(alias = "adminPassword", column = "admin_password", length = 16)
  @ExcelVOAttribute(name = "admin_password", column = "C")
  private String adminPassword;

  @AutoField(alias = "phoneNum", column = "phone_num", length = 11)
  @ExcelVOAttribute(name = "phone_num", column = "D")
  private String phoneNum;


  public int getId() {
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getAdminName() {
    return adminName;
  }
  public void setAdminName(String adminName){
    this.adminName = adminName;
  }
  public String getAdminPassword() {
    return adminPassword;
  }
  public void setAdminPassword(String adminPassword){
    this.adminPassword = adminPassword;
  }
  public String getPhoneNum() {
    return phoneNum;
  }
  public void setPhoneNum(String phoneNum){
    this.phoneNum = phoneNum;
  }
}
