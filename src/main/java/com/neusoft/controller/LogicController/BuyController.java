package com.neusoft.controller.LogicController;

import com.neusoft.model.Category;
import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.CommentsWithUserName;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/23.
 */
@Controller
public class BuyController {

    @Value("#{commentsService}")
    private ICommentsService commentsService;
    @Value("#{adminService}")
    private IAdminService adminService;

    @RequestMapping("get_category_map.do")
    public ModelAndView get_category_map(HttpServletRequest request){
        Map<Category, List<Category>> map = adminService.getAllCategoriesWithLevel();

        return null;
    }

    //转到之后获取商品信息
    @RequestMapping("shop_content.do")
    public ModelAndView shop_content(HttpServletRequest request){
        int goodID = Integer.parseInt((String)request.getParameter("shopID"));
        List<CommentsWithUserName> commentsList = commentsService.getCommentsByGoodsId(goodID);
        Goods good = commentsService.getGoodsInfoByID(goodID);
        ModelAndView mav = new ModelAndView("show");
        mav.addObject("comments", commentsList);
        mav.addObject("goodInfo", good);
        mav.addObject("category_map", adminService.getAllCategoriesWithLevel());
        return mav;
    }


}
