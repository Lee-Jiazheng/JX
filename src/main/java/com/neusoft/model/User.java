package com.neusoft.model;

import com.tgb.lk.annotation.AutoBean;
import com.tgb.lk.annotation.AutoField;
import com.tgb.lk.annotation.ExcelVOAttribute;

import java.util.Date;

@AutoBean(alias = "User",table="user")
public class User {

  @AutoField(alias = "userId", column = "user_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "user_id", column = "A")
  private int userId;

  @AutoField(alias = "password", column = "password", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "password", column = "B")
  private String password;

  @AutoField(alias = "nickName", column = "nick_name", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "nick_name", column = "C")
  private String nickName;

  @AutoField(alias = "realname", column = "realname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "realname", column = "D")
  private String realname;

  @AutoField(alias = "createTime", column = "create_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "create_time", column = "E")
  private Date createTime;

  @AutoField(alias = "email", column = "email", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "email", column = "F")
  private String email;

  @AutoField(alias = "phone", column = "phone", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "phone", column = "G")
  private String phone;

  @AutoField(alias = "credit", column = "credit", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "credit", column = "H")
  private int credit;


  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId){
    this.userId = userId;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName){
    this.nickName = nickName;
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
