package com.neusoft.controller.user;

import com.neusoft.model.*;
import com.neusoft.model.extraModel.GoodsWithPhotos;
import com.neusoft.model.extraModel.OrderWithGood_Goodpicture;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import com.neusoft.service.IOrderService;
import com.neusoft.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Controller
public class UserInfoController {
    @Value("#{userManager}")
    private IUserService userService;
    @Value("#{orderService}")
    private IOrderService orderService;
    @Value("#{adminService}")
    private IAdminService adminService;
    @Value("#{commentsService}")
    private ICommentsService commentsService;

    //进入user_center界面的servlet
    @RequestMapping("user_center.do")
    public ModelAndView user_center(HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        ModelAndView mav = new ModelAndView("user_center");
        //尚未登陆
        if(user == null){
            mav.setViewName("login");
            return mav;
        }

        List<Order> orders = orderService.getOrderByBuyer(user.getUserid());
        List<OrderWithGood_Goodpicture> orderWithGood_goodpictures = new ArrayList<>();
        for(Order order: orders){
            OrderWithGood_Goodpicture orderWithGood_goodpicture = new OrderWithGood_Goodpicture();
            orderWithGood_goodpicture.setOrderid(order.getOrderid());
            orderWithGood_goodpicture.setOrdertime(order.getOrdertime());
            if(order.getOrderfinished() == true){
                orderWithGood_goodpicture.setOrderStatus("已完成");
            }else{
                orderWithGood_goodpicture.setOrderStatus("未完成");
            }
            Goodsphoto goodsphoto = adminService.getGoodPhotoByGoodId(order.getOrdergoods());
            if(goodsphoto == null){
                orderWithGood_goodpicture.setPhoto(null);
            }else{
                orderWithGood_goodpicture.setPhoto(goodsphoto.getPhoto());
            }
            orderWithGood_goodpicture.setOrderprice(order.getOrderprice());

            //商品相关的信息
            Goods good = commentsService.getGoodsInfoByID(order.getOrdergoods());
            orderWithGood_goodpicture.setGoodsname(good.getGoodsname());
            double price = good.getGoodsprice();
            int amount = order.getOrderprice()/price == (int)(order.getOrderprice()/price)? (int)(order.getOrderprice()/price) : (int)(order.getOrderprice()/price) + 1;
            orderWithGood_goodpicture.setAmount(amount);
            orderWithGood_goodpicture.setReilGoodPrice(price);

            orderWithGood_goodpicture.setIscommented(order.getIscommented());
            if(orderWithGood_goodpicture.getIscommented() == true){
                //如果已经评论了获取评论的内容
                orderWithGood_goodpicture.setCommentContent(commentsService.getCommentsContentByOrderId(order.getOrderid()));
            }

            orderWithGood_goodpictures.add(orderWithGood_goodpicture);
        }

        request.getSession().setAttribute("user_orders", orderWithGood_goodpictures);
        /*List<Address> addresses = userService.getAllAddresses(user.getUserid());
        Address default_address = new Address();
        for(Address address : addresses){
            if(address.getIsdefault() == true){
                default_address = address;
                addresses.remove(address);
                break;
            }
        }

        request.getSession().setAttribute("default_address", default_address);*/
        request.getSession().setAttribute("addresses", userService.getAllAddresses(user.getUserid()));

        return mav;
    }

    //修改头像
    @RequestMapping("user_avatar.do")
    public ModelAndView user_avatar(MultipartFile user_image, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("user_center");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(userService.change_avatar(user_image, user, session.getServletContext().getRealPath("/avatar")) == true){
            //上传成功
        }

        return mav;
    }

    @RequestMapping("alter_user_info.do")
    public ModelAndView alter_user_info(HttpServletRequest request, String real_name, String phone, String email){
        User user = (User)request.getSession().getAttribute("user");
        user.setRealname(real_name);
        user.setPhone(phone);
        user.setEmail(email);
        userService.alter_user_info(user);
        ModelAndView mav = new ModelAndView("user_center");
        return mav;
    }

    @RequestMapping("alter_password.do")
    public ModelAndView alter_password(String newpassword, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        user.setPassword(newpassword);
        userService.alter_user_info(user);
        ModelAndView mav = new ModelAndView("user_center");
        return mav;
    }

    //获取用户所有order
    @RequestMapping("get_user_orders.do")
    public ModelAndView get_user_orders(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        ModelAndView mav = new ModelAndView("user_center");
        mav.addObject("user_orders", orderService.getOrderByBuyer(user.getUserid()));
        return mav;
    }

    @RequestMapping("add_address.do")
    public String add_address(Address address,String state, int addressid,HttpServletRequest request){
            address.setAddressownerid(((User)request.getSession().getAttribute("user")).getUserid());
            address.setIsdefault(false);
            userService.addAddress(address,state,addressid);
        return "redirect:user_center.do?type=3";
    }

    @RequestMapping("del_address.do")
    public String delAddress(int addressid){
        userService.delAddress(addressid);
        return  "redirect:user_center.do?type=3";
    }


}
