package com.neusoft.service;

import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.CommentsWithUserName;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/23.
 */
public interface ICommentsService {
    public Map<Goods, List<Comments>> getAllCommentsAndGoods();
    public int getCommentsCountByGoodsId(int goodsId);
    public List<CommentsWithUserName> getCommentsByGoodsId(int goodsId);
    public Goods getGoodsInfoByID(int goodsID);
    public int deleteCommentById(int commentId);
    public List<Goods> getAllGoods();
    public List<Goods> getAllGoodsByCategoryId(int cate_id);
}
