package com.neusoft.mapper;

import com.neusoft.model.Promotion;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPromotionMapper {
    @Select("select * from promotion")
    public List<Promotion> getAllPromotion();

    @Select("select * from promotion where promotionId= #{promotionId}")
    public Promotion getPromotion(@Param("promotionId") int promotionId);

    @Insert("insert into promotion(promotionId,promotionName," +
            "promotionThreshold,promotionDeduction,effectiveTime)" +
            "values(#{promotionId},#{promotionName},#{promotionThreshold}," +
            "#{promotionDeduction},#{effectiveTime})")
    public void addPromotion(Promotion promotion);

    @Update("update promotion set promotionName=#{promotionName}," +
            "promotionThreshold=#{promotionThreshold}," +
            "promotionDeduction=#{promotionDeduction}," +
            "effectiveTime=#{effectiveTime} where promotionId=#{promotionId}")
    public void updatePromotion(Promotion promotion);

    @Delete("delete from promotion where promotionId=#{promotionId}")
    public void delPromotionById(@Param("promotionId") int promotionId);


}