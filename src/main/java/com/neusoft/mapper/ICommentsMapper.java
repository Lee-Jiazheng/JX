package com.neusoft.mapper;

import com.neusoft.model.Comments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICommentsMapper {
    /*
    三种获取评论的方式：评论id，评论者id，被评论的商品id
     */

    @Select("select * from comments where commentsBuyer= #{commentsbuyer}")
    public List<Comments> getCommentsByUser(@Param("commentsbuyer") int
                                                        commentsbuyer);


    @Select("select * from Comments where commentsgoods= #{commentsgoods}")
    public List<Comments> getCommentsByGoods(@Param("commentsgoods") int
                                                         commentsgoods);

    @Insert("insert into Comments(commentsid,commentsbuyer,commentsgoods," +
            "commentscontent,commentstime)" +
            "values(#{commentsid},#{commentsbuyer},#{commentsgoods}," +
            "#{commentscontent},#{commentstime})")
    public void addComment(Comments comments);

    @Update("update comments set commentscontent=#{commentscontent} where " +
            "commentsId=#{commentsid}")
    public void updateComment(@Param("commentsContent") String commentscontent,
                              @Param("commentsid") int commentsId);

    @Delete("delete from comments where commentsId=#{commentsid}")
    public int delComment(@Param("commentsid") int commentsid);

    /*
    三种获取评论的方式：评论id，评论者id，被评论的商品id
     */
    @Select("select * from comments where commentsId= #{commentsid}")
    public Comments getCommentsById(@Param("commentsid") int commentsid);




}