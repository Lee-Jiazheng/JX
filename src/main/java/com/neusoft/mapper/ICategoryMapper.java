package com.neusoft.mapper;

import com.neusoft.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICategoryMapper {

    @Select("select * from category where categoryId= #{categoryId}")
    public Category getCategory(@Param("categoryId") int categoryId);

    @Select("select * from category where parentId = #{parentId}")
    public List<Category> getCategoriesByParentId(int parentId);

    @Insert("insert into category(categoryname,parentflag,parentid,categoryimg) " +
            "values(#{categoryname},#{parentflag},#{parentid},#{categoryimg})")
    public int addCategory(Category category);

    @Insert("insert into category(categoryname,parentflag,categoryimg) " +
            "values(#{categoryname},#{parentflag},#{categoryimg})")
    public int addCategoryParent(Category category);

    @Update("update category set categoryname=#{categoryname}," +
            "parentflag=#{parentflag},parentid=#{parentid} where categoryid = #{categoryid}")
    public void updateCategory(Category category);

    @Delete("delete from category where categoryid=#{categoryid}")
    public void delCategoryById(@Param("categoryid") int categoryid);

    @Select("select * from category")
    public List<Category> getAllCategories();

    @Select("select * from category where parentflag = true")
    public List<Category> getAllParentCategories();

    @Select("select * from category where parentflag = false")
    public List<Category> getAllSonCategories();


}