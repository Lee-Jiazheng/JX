package com.neusoft.controller.LogicController;

import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.Order;
import com.neusoft.model.User;
import com.neusoft.model.extraModel.Good_with_photo;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import com.neusoft.service.IOrderService;
import com.neusoft.service.IUserService;
import com.neusoft.service.impl.AdminService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bruce Lee on 2017/7/17.
 */

/**
 * 本文件是与用户管理相关的所有Servlet
 * 例如，用户登录及注册
 */
@Controller
public class CommentsController {

    @Value("#{commentsService}")
    private ICommentsService commentsService;
    @Value("#{orderService}")
    private IOrderService orderService;
    @Value("#{adminService}")
    private IAdminService adminService;

    @RequestMapping("add_comment.do")
    public ModelAndView add_comment(Comments comments, HttpServletRequest request)
            throws IOException {

        ModelAndView mav = new ModelAndView("user_center");
        comments.setCommentstime(new Date());
        comments.setCommentsbuyer(((User)request.getSession().getAttribute("user")).getUserid());
        commentsService.addComments(comments);

        return mav;
    }

    @RequestMapping("entry_comment.do")
    public ModelAndView entry_comment(int orderID){
        Order order = orderService.getOrderById(orderID);
        Goods good = commentsService.getGoodsInfoByID(order.getOrdergoods());
        Good_with_photo good_with_photo = new Good_with_photo();
        good_with_photo.setPhoto(adminService.getGoodPhotoByGoodId(good.getGoodsid()));
        good_with_photo.setGoodsname(good.getGoodsname());
        good_with_photo.setGoodsid(good.getGoodsid());
        ModelAndView mav = new ModelAndView("comment");
        mav.addObject("order_good", good_with_photo);
        return mav;
    }

}
