package com.neusoft.controller.index;

import com.neusoft.model.extraModel.GoodsWithPhotos;
import com.neusoft.service.IAdminService;
import com.neusoft.service.IShowIndex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ThornWu on 2017/7/26.
 */

@Controller
public class Index_Controller {
    @Value("#{iShowIndex}")
    private IShowIndex iShowIndex;
    /**



     //转到之后获取商品详情页面
     @RequestMapping("shop_content.do")
     public ModelAndView shop_content(HttpServletRequest request){
     int goodID = Integer.parseInt((String)request.getParameter("shopID"));
     List<CommentsWithUserName> commentsList = commentsService.getCommentsByGoodsId(goodID);
     Goods good = commentsService.getGoodsInfoByID(goodID);
     ModelAndView mav = new ModelAndView("show");
     mav.addObject("comments", commentsList);
     mav.addObject("goodInfo", good);
     mav.addObject("category_map", adminService.getAllCategoriesWithLevel());
     mav.addObject("shopID", goodID);
     mav.addObject("good_photo", adminService.getGoodPhotoByGoodId(goodID));
     return mav;
     }

     **/
    @Value("#{adminService}")
    private IAdminService adminService;


    @RequestMapping("/index.do")
    public ModelAndView showIndex(HttpServletRequest request){

        List<GoodsWithPhotos> newProductList=iShowIndex.getNewProduct();
        List<GoodsWithPhotos> popProductList=iShowIndex.getPopProduct();
        /**
         *
         *         ;
         List<CommentsWithUserName> commentsList = commentsService.getCommentsByGoodsId(goodID);
         Goods good = commentsService.getGoodsInfoByID(goodID);
         ModelAndView mav = new ModelAndView("show");
         mav.addObject("comments", commentsList);
         mav.addObject("goodInfo", good);
         mav.addObject("category_map", adminService.getAllCategoriesWithLevel());
         mav.addObject("shopID", goodID);
         mav.addObject("good_photo", adminService.getGoodPhotoByGoodId(goodID));

         **/
        ModelAndView mav =new ModelAndView("index");
        mav.addObject("newProduct",newProductList);
        mav.addObject("popProduct",popProductList);
        request.getSession().setAttribute("category_map", adminService.getAllCategoriesWithLevel());
        return mav;
    }

}
