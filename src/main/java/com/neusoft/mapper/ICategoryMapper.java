package com.neusoft.mapper;

import com.neusoft.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICategoryMapper {

    @Select("select * from category where categoryId= #{categoryId}")
    public Category getCategory(@Param("categoryId") int categoryId);

    @Select("select * from category where parentId = #{parentId}")
    public List<Category> getCategoriesByParentId(int parentId);

    @Insert("insert into category(categoryId,categoryName,parentFlag,parentId" +
            "values(#{categoryId},#{categoryName},#{parentFlag},#{parentId}")
    public void addCategory(Category category);

    @Update("update category set categoryName=#{categoryName}," +
            "parentFlag=#{parentFlag},parentId=#{parentId}")
    public void updateCategory(Category category);

    @Delete("delete from category where categoryId=#{categoryId}")
    public void delCategoryById(@Param("categoryId") int categoryId);

    @Select("select * from category")
    public List<Category> getAllCategories();



}