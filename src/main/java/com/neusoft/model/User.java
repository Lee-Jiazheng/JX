package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "User",table="user")
public class User {

  @AutoField(alias = "id", column = "id", isKey = true , isRequired = true , type="Integer", length=0)
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "nickname", column = "nickname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "nickname", column = "B")
  private String nickname;

  @AutoField(alias = "realname", column = "realname", length = 45)
  @ExcelVOAttribute(name = "realname", column = "C")
  private String realname;

  @AutoField(alias = "createTime", column = "create_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "create_time", column = "D")
  private Date createTime;

  @AutoField(alias = "email", column = "email", length = 45)
  @ExcelVOAttribute(name = "email", column = "E")
  private String email;

  @AutoField(alias = "phone", column = "phone", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "phone", column = "F")
  private String phone;

  @AutoField(alias = "credit", column = "credit", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "credit", column = "G")
  private int credit;


  public int getId() {
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname){
    this.nickname = nickname;
  }
  public String getRealname() {
    return realname;
  }
  public void setRealname(String realname){
    this.realname = realname;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime){
    this.createTime = createTime;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone){
    this.phone = phone;
  }
  public int getCredit() {
    return credit;
  }
  public void setCredit(int credit){
    this.credit = credit;
  }
}
