package com.neusoft.service.impl;

import com.neusoft.mapper.ICommentsMapper;
import com.neusoft.mapper.IGoodsMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.CommentsWithUserName;
import com.neusoft.service.ICommentsService;
import com.neusoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/23.
 */
@Service("commentsService")
@Transactional
public class CommentsService implements ICommentsService{

    @Autowired
    private ICommentsMapper commentsMapper;
    @Autowired
    private IGoodsMapper goodsMapper;
    @Autowired
    private IUserMapper userMapper;

    @Override
    public Map<Goods, List<Comments>> getAllCommentsAndGoods() {
        Map<Goods, List<Comments>> maps = new HashMap<Goods, List<Comments>>();
        List<Goods> goods = goodsMapper.getAllGoods();
        for(Goods good : goods){
            maps.put(good, commentsMapper.getCommentsByGoods(good.getGoodsid()));
        }
        return maps;
    }

    @Override
    public int getCommentsCountByGoodsId(int goodsId) {
        return commentsMapper.getCommentsByGoods(goodsId).size();
    }

    @Override
    public List<CommentsWithUserName> getCommentsByGoodsId(int goodsId) {
        List<Comments> commentsList = commentsMapper.getCommentsByGoods(goodsId);
        List<CommentsWithUserName> commentsWithUserNames = new ArrayList<CommentsWithUserName>();;
        for(Comments comment : commentsList){
            CommentsWithUserName commentsWithUserName = new CommentsWithUserName();
            commentsWithUserName.userName = userMapper.getUserNameByCommentsBuyerID(comment.getCommentsbuyer());
            commentsWithUserName.setCommentscontent(comment.getCommentscontent());
            commentsWithUserName.setCommentstime(comment.getCommentstime());
            commentsWithUserNames.add(commentsWithUserName);
        }
        return commentsWithUserNames;
    }

    @Override

    public Goods getGoodsInfoByID(int goodsID) {
        return goodsMapper.getGoods(goodsID);
    }

    @Override
    public int deleteCommentById(int commentId) {
        return commentsMapper.delComment(commentId);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public List<Goods> getAllGoodsByCategoryId(int cate_id) {
        return goodsMapper.getGoodsByCategory(cate_id);
    }

}
