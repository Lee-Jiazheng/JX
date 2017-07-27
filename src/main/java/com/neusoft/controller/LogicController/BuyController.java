package com.neusoft.controller.LogicController;

import com.neusoft.mapper.IShopcartMapper;
import com.neusoft.model.*;
import com.neusoft.model.extraModel.CommentsWithUserName;
import com.neusoft.model.extraModel.Good_with_photo;
import com.neusoft.model.extraModel.OrderWithGood_Goodpicture;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import com.neusoft.service.IOrderService;
import com.neusoft.service.IShopCartService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
    @Value("#{shopCartService}")
    private IShopCartService shopCartService;


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
        if(request.getSession().getAttribute("user") != null){
            response.getWriter().write("ok");
            //一切正常，添加订单进入数据库
            //return "forward:entry_order.do";
        }
        else
            response.getWriter().write("unlogin");
        //return null;
    }


    //进入订单页面
    @RequestMapping("entry_order.do")
    public ModelAndView entry_order(HttpServletRequest request) throws Exception{
        int shopID = Integer.parseInt(request.getParameter("shopID"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        ModelAndView mav = new ModelAndView("order");
        List<OrderWithGood_Goodpicture> orders = new ArrayList<>();
        OrderWithGood_Goodpicture order = new OrderWithGood_Goodpicture();
        //进入本页面的订单只能有一个
        Goods good = commentsService.getGoodsInfoByID(shopID);
        double order_price = amount * good.getGoodsprice();
        order.setPhoto(adminService.getGoodPhotoByGoodId(good.getGoodsid()).getPhoto());
        order.setGoodsname(good.getGoodsname());
        order.setReilGoodPrice(good.getGoodsprice());
        order.setAmount(amount);
        order.setOrderprice(order_price);
        orders.add(order);

        if(order.getOrderprice() >= 88){
            mav.addObject("express_price", 0.00);
        }else {
            mav.addObject("express_price", 5.00); order_price += 5;
        }
        mav.addObject("total_price", order_price);
        mav.addObject("current_orders", orders);
        return mav;
    }



    //进入购物车页面
    @RequestMapping("entry_shopcart.do")
    public ModelAndView entry_shopcart(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        //如果没有登录,只从cookie中取出来
        List<Integer> goodIds = shopCartService.getShopCartFromCookie(request);
        if(user != null){
            //从数据库中也取出来
            List<Integer> goodIds_temp = shopCartService.getShopcartById(user.getUserid());
            for(Integer integer : goodIds_temp){
                goodIds.add(integer);
            }
        }
        //goodIds存放的是该用户的全部购物车数据，
        return null;
    }

    @RequestMapping("evaluate.do")
    public void Evaluate(int orderID){

    }

    //点击结算后应该把选中物品加入Order数据库后，
    public String close_count(HttpServletRequest request){


        return "forward:entry_order.do";
    }


    @RequestMapping("entry_detail_list.do")
    public ModelAndView entry_detail_list(int categoryId){
        ModelAndView mav = new ModelAndView("list");
        List<Goods> goods = commentsService.getAllGoodsByCategoryId(categoryId);
        List<Good_with_photo> good_with_photos = new ArrayList<>();

        for(Goods good : goods){
            Good_with_photo good_photo = new Good_with_photo();
            good_photo.setGoodsid(good.getGoodsid());
            good_photo.setGoodsprice(good.getGoodsprice());
            good_photo.setGoodsname(good.getGoodsname());
            good_photo.setPhoto(adminService.getGoodPhotoByGoodId(good.getGoodsid()));
            good_with_photos.add(good_photo);
        }

        mav.addObject("result_goods", good_with_photos);
        return mav;
    }
}
