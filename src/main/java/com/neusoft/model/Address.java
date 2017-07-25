package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Address",table="address")
public class Address {

  @AutoField(alias = "addressownerid", column = "addressownerid", type = "Integer")
  @ExcelVOAttribute(name = "addressownerid", column = "A")
  private int addressownerid;

  @AutoField(alias = "addressname", column = "addressname", length = 60)
  @ExcelVOAttribute(name = "addressname", column = "B")
  private String addressname;

  @AutoField(alias = "isdefault", column = "isdefault")
  @ExcelVOAttribute(name = "isdefault", column = "C")
  private boolean isdefault;

  @AutoField(alias = "phonenum", column = "phonenum", length = 11)
  @ExcelVOAttribute(name = "phonenum", column = "D")
  private String phonenum;

  @AutoField(alias = "contactname", column = "contactname", length = 12)
  @ExcelVOAttribute(name = "contactname", column = "E")
  private String contactname;


  public int getAddressownerid() {
    return addressownerid;
  }
  public void setAddressownerid(int addressownerid){
    this.addressownerid = addressownerid;
  }
  public String getAddressname() {
    return addressname;
  }
  public void setAddressname(String addressname){
    this.addressname = addressname;
  }
  public boolean getIsdefault() {
    return isdefault;
  }
  public void setIsdefault(boolean isdefault){
    this.isdefault = isdefault;
  }
  public String getPhonenum() {
    return phonenum;
  }
  public void setPhonenum(String phonenum){
    this.phonenum = phonenum;
  }
  public String getContactname() {
    return contactname;
  }
  public void setContactname(String contactname){
    this.contactname = contactname;
  }
}
