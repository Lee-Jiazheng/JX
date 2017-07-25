package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "ChatUserRecord",table="chat_user_record")
public class ChatUserRecord  implements Serializable {

  @AutoField(alias = "originUser", column = "origin_user", type = "Integer")
  @ExcelVOAttribute(name = "origin_user", column = "A")
  private int originUser;

  @AutoField(alias = "passiveUser", column = "passive_user", type = "Integer")
  @ExcelVOAttribute(name = "passive_user", column = "B")
  private int passiveUser;


  public int getOriginUser() {
    return originUser;
  }
  public void setOriginUser(int originUser){
    this.originUser = originUser;
  }
  public int getPassiveUser() {
    return passiveUser;
  }
  public void setPassiveUser(int passiveUser){
    this.passiveUser = passiveUser;
  }
}
