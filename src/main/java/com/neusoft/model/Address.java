package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Address",table="address")
public class Address {
  @AutoField(alias = "addressid", column = "addressid", type = "Integer")
  @ExcelVOAttribute(name = "addressid", column = "A")
  private int addressid;

  @AutoField(alias = "addressownerid", column = "addressownerid", type = "Integer")
  @ExcelVOAttribute(name = "addressownerid", column = "B")
  private int addressownerid;

  @AutoField(alias = "addressname", column = "addressname", length = 60)
  @ExcelVOAttribute(name = "addressname", column = "C")
  private String addressname;

  @AutoField(alias = "isdefault", column = "isdefault")
  @ExcelVOAttribute(name = "isdefault", column = "D")
  private boolean isdefault;

  @AutoField(alias = "phonenum", column = "phonenum", length = 11)
  @ExcelVOAttribute(name = "phonenum", column = "E")
  private String phonenum;

  @AutoField(alias = "contactname", column = "contactname", length = 12)
  @ExcelVOAttribute(name = "contactname", column = "F")
  private String contactname;


  public int getAddressid() {
    return addressid;
  }

  public void setAddressid(int addressid) {
    this.addressid = addressid;
  }

  public boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(boolean isdefault) {
    this.isdefault = isdefault;
  }

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
