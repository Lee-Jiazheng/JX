package com.neusoft.model;

import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Comments",table="comments")
public class Comments {

  @AutoField(alias = "commentsId", column = "comments_id", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "comments_id", column = "A")
  private int commentsId;

  @AutoField(alias = "commentsBuyer", column = "comments_buyer", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "comments_buyer", column = "B")
  private int commentsBuyer;

  @AutoField(alias = "commentsGoods", column = "comments_goods", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "comments_goods", column = "C")
  private int commentsGoods;

  @AutoField(alias = "commentsContent", column = "comments_content", isRequired = true, length = 255)
  @ExcelVOAttribute(name = "comments_content", column = "D")
  private String commentsContent;

  @AutoField(alias = "commentsTime", column = "comments_time", isRequired = true, type = "Date")
  @ExcelVOAttribute(name = "comments_time", column = "E")
  private Date commentsTime;


  public int getCommentsId() {
    return commentsId;
  }
  public void setCommentsId(int commentsId){
    this.commentsId = commentsId;
  }
  public int getCommentsBuyer() {
    return commentsBuyer;
  }
  public void setCommentsBuyer(int commentsBuyer){
    this.commentsBuyer = commentsBuyer;
  }
  public int getCommentsGoods() {
    return commentsGoods;
  }
  public void setCommentsGoods(int commentsGoods){
    this.commentsGoods = commentsGoods;
  }
  public String getCommentsContent() {
    return commentsContent;
  }
  public void setCommentsContent(String commentsContent){
    this.commentsContent = commentsContent;
  }
  public Date getCommentsTime() {
    return commentsTime;
  }
  public void setCommentsTime(Date commentsTime){
    this.commentsTime = commentsTime;
  }
}
