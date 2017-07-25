package com.neusoft.model;

import java.io.Serializable;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Comments",table="comments")
public class Comments  implements Serializable {

  @AutoField(alias = "commentsid", column = "commentsid", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "commentsid", column = "A")
  private int commentsid;

  @AutoField(alias = "commentsbuyer", column = "commentsbuyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "commentsbuyer", column = "B")
  private int commentsbuyer;

  @AutoField(alias = "commentsgoods", column = "commentsgoods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "commentsgoods", column = "C")
  private int commentsgoods;

  @AutoField(alias = "commentscontent", column = "commentscontent", isRequired = true, length = 255)
  @ExcelVOAttribute(name = "commentscontent", column = "D")
  private String commentscontent;

  @AutoField(alias = "commentstime", column = "commentstime", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "commentstime", column = "E")
  private Date commentstime;


  public int getCommentsid() {
    return commentsid;
  }
  public void setCommentsid(int commentsid){
    this.commentsid = commentsid;
  }
  public int getCommentsbuyer() {
    return commentsbuyer;
  }
  public void setCommentsbuyer(int commentsbuyer){
    this.commentsbuyer = commentsbuyer;
  }
  public int getCommentsgoods() {
    return commentsgoods;
  }
  public void setCommentsgoods(int commentsgoods){
    this.commentsgoods = commentsgoods;
  }
  public String getCommentscontent() {
    return commentscontent;
  }
  public void setCommentscontent(String commentscontent){
    this.commentscontent = commentscontent;
  }
  public Date getCommentstime() {
    return commentstime;
  }
  public void setCommentstime(Date commentstime){
    this.commentstime = commentstime;
  }
}
