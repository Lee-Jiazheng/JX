package com.neusoft.mapper;

import com.neusoft.model.Comments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICommentsMapper {
    /*
    三种获取评论的方式：评论id，评论者id，被评论的商品id
     */

    @Select("select * from comments where commentsBuyer= #{commentsBuyer}")
    public List<Comments> getCommentsByUser(@Param("commentsBuyer") int
                                              commentsBuyer);


    @Select("select * from Comments where commentsgoods= #{commentsGoods}")
    public List<Comments> getCommentsByGoods(@Param("commentsGoods") int
                                               commentsGoods);

    @Insert("insert into Comments(commentsId,commentsBuyer,commentsGoods," +
            "commentsContent,commentsTime)" +
            "values(#{commentsId},#{commentsBuyer},#{commentsGoods}," +
            "#{commentsContent},#{commentsTime})")
    public void addComment(Comments comments);

    @Update("update order set commentsContent=#{commentsContent} where " +
            "commentsId=#{commentsId}")
    public void updateComment(@Param("commentsContent") String commentsContent,
                              @Param("commentsId") int commentsId);

    @Delete("delete from order where commentsId=#{commentsId}")
    public void delComment(@Param("commentsId") int commentsId);

    /*
    三种获取评论的方式：评论id，评论者id，被评论的商品id
     */
    @Select("select * from comments where commentsId= #{commentsId}")
    public Comments getCommentsById(@Param("commentsId") int commentsId);




}