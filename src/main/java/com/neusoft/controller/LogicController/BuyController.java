package com.neusoft.controller.LogicController;

import com.neusoft.mapper.IShopcartMapper;
import com.neusoft.model.*;
import com.neusoft.model.extraModel.CommentsWithUserName;
import com.neusoft.model.extraModel.Good_with_photo;
import com.neusoft.model.extraModel.OrderWithGood_Goodpicture;
import com.neusoft.service.*;
import com.sun.javafx.sg.prism.NGShape;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.*;

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
    @Value("#{addressService}")
    private IAddressService addressService;


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


    //点击直接购买后，进入订单页面
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
        User user = (User)request.getSession().getAttribute("user");
        List<Address> addresses = addressService.getAllAddressByUserId(user.getUserid());

        mav.addObject("total_price", order_price);
        mav.addObject("addresses", addresses);
        request.getSession().setAttribute("current_orders", orders);
        return mav;
    }


    //加入购物车的ajax
    @RequestMapping("add_to_shopcart.do")
    public void add_to_shopcart(int goodId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            //未登录放入session中
            shopCartService.addShopCartToCookie(request, response, goodId);
        }else{
            Shopcart shopcart = new Shopcart();
            shopcart.setShopcartbuyer(user.getUserid());
            shopcart.setShopcartgoods(goodId);
            shopcart.setShopcarttime(new Date());
            shopCartService.addShopcart(shopcart);
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("ok");
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

        List<Good_with_photo> goods = new ArrayList<>();
        for(int goodId: goodIds){
            Goods temp_good = commentsService.getGoodsInfoByID(goodId);
            Good_with_photo good = new Good_with_photo();
            good.setPhoto(adminService.getGoodPhotoByGoodId(goodId));
            good.setGoodsprice(temp_good.getGoodsprice());
            good.setGoodsname(temp_good.getGoodsname());
            good.setGoodsid(goodId);
            good.setGoodsquantity(temp_good.getGoodsquantity());
            goods.add(good);
        }

        //goodIds存放的是该用户的全部购物车数据，
        request.getSession().setAttribute("shop_cart_goods", goods);
        return new ModelAndView("cart");
    }

    @RequestMapping("evaluate.do")
    public void Evaluate(int orderID){

    }

    //点击支付后应该把选中物品加入Order数据库后，
    @RequestMapping("close_acount.do")
    public ModelAndView close_count(HttpServletRequest request, int addressid){
        List<OrderWithGood_Goodpicture> orders= (List<OrderWithGood_Goodpicture>)request.getSession().getAttribute("current_orders");
        for(OrderWithGood_Goodpicture origin_order : orders){
            Order order = new Order();
            order.setOrderbuyer(((User)request.getSession().getAttribute("user")).getUserid());
            order.setOrdertime(new Date());
            order.setOrderprice(origin_order.getOrderprice());
            order.setOrderfinished(false);
            order.setAddressid(addressid);
            orderService.addOrder(order);
        }
        return new ModelAndView("pay");
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


    //处理传入的选中购物车数据
    @RequestMapping("process_shop_cart.do")
    public ModelAndView process_shop_cart(String shop_cart_json, HttpServletRequest request) throws JSONException {

        User user = (User)request.getSession().getAttribute("user");
        List<Address> addresses = addressService.getAllAddressByUserId(user.getUserid());
        ModelAndView mav = new ModelAndView("order");
        mav.addObject("addresses", addresses);

        List<OrderWithGood_Goodpicture> orders = getJson(shop_cart_json);

        double total_price = 0;
        for(OrderWithGood_Goodpicture order : orders){
            total_price += order.getOrderprice();
        }
        if(total_price >= 88){
            mav.addObject("express_price", 0.00);
        }else{
            mav.addObject("express_price", 5.00); total_price += 5;
        }
        mav.addObject("total_price", total_price);
        request.getSession().setAttribute("current_orders", orders);



        return mav;


        /*
        JSONArray jsonArray = JSONArray.fromObject(shop_cart_json);
        for(int i = 0; i < jsonArray.size(); ++i){
            JSONObject json = jsonArray.getJSONObject(i);
            int Num = json.getInt("Num");
            int ID = json.getInt("ID");
        }*/
    }



    public List<OrderWithGood_Goodpicture> getJson(String src) throws JSONException {
        String[] stringList = src.substring(2,src.length()-2).split("\\}, " +
                "\\{");

        for (int i = 0; i < stringList.length; ++i) {
            stringList[i] = "{".concat(stringList[i]);
            stringList[i] = stringList[i].concat("}");
        }
        List<OrderWithGood_Goodpicture> orders = new ArrayList<>();




        for(int j = 0; j<stringList.length; ++j){
            OrderWithGood_Goodpicture order = new OrderWithGood_Goodpicture();
            JSONObject jsonObject = new JSONObject(stringList[j]);
            int goodID = jsonObject.getInt("ID");
            int count = jsonObject.getInt("Num");

            Goods good = commentsService.getGoodsInfoByID(goodID);
            double order_price = count * good.getGoodsprice();
            Goodsphoto goodPhoto= adminService.getGoodPhotoByGoodId(good.getGoodsid());
            if(goodPhoto == null){
                order.setPhoto(null);
            }else{
                order.setPhoto(goodPhoto.getPhoto());
            }
            order.setGoodsname(good.getGoodsname());
            order.setReilGoodPrice(good.getGoodsprice());
            order.setAmount(count);
            order.setOrderprice(order_price);
            orders.add(order);
        }
        return orders;
    }
}
