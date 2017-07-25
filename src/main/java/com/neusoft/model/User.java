package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "User",table="user")
public class User implements Serializable {

  @AutoField(alias = "userid", column = "userid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "userid", column = "A")
  private int userid;

  @AutoField(alias = "userphoto", column = "userphoto", length = 255)
  @ExcelVOAttribute(name = "userphoto", column = "B")
  private String userphoto;

  @AutoField(alias = "password", column = "password", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "password", column = "C")
  private String password;

  @AutoField(alias = "nickname", column = "nickname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "nickname", column = "D")
  private String nickname;

  @AutoField(alias = "realname", column = "realname", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "realname", column = "E")
  private String realname;

  @AutoField(alias = "createtime", column = "createtime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "createtime", column = "F")
  private Date createtime;

  @AutoField(alias = "email", column = "email", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "email", column = "G")
  private String email;

  @AutoField(alias = "phone", column = "phone", isRequired = true, length = 45)
  @ExcelVOAttribute(name = "phone", column = "H")
  private String phone;

  @AutoField(alias = "credit", column = "credit", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "credit", column = "I")
  private int credit;


  public int getUserid() {
    return userid;
  }
  public void setUserid(int userid){
    this.userid = userid;
  }
  public String getUserphoto() {
    return userphoto;
  }
  public void setUserphoto(String userphoto){
    this.userphoto = userphoto;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password){
    this.password = password;
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
  public Date getCreatetime() {
    return createtime;
  }
  public void setCreatetime(Date createtime){
    this.createtime = createtime;
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
