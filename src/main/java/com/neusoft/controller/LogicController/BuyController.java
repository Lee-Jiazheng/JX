package com.neusoft.controller.LogicController;

import com.neusoft.model.Category;
import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.User;
import com.neusoft.model.extraModel.CommentsWithUserName;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import com.neusoft.service.IOrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @Value("#{orderService}")
    private IOrderService orderService;


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

    //购买商品
    @RequestMapping("buy_good.do")
    public ModelAndView buy_good(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            mav.setViewName("login");
        }else{
            mav.setViewName("user_center");
            int goodID = Integer.parseInt((String)request.getParameter("shopID"));
            orderService.addOrder(goodID, user.getUserid());
        }
        return mav;
    }

    //点击后进入预订界面，这个是ajax请求
    @RequestMapping("order_good.do")
    public void order_good(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int shopID = Integer.parseInt(request.getParameter("shopID"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        if(request.getSession().getAttribute("user") != null)
            response.getWriter().write("ok");
        else
            response.getWriter().write("unlogin");
    }

}
