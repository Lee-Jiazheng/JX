package com.neusoft.controller.admin;

import com.neusoft.config.ModuleConfig;
import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.AdminUser;
import com.neusoft.model.Category;
import com.neusoft.model.Order;
import com.neusoft.model.User;
import com.neusoft.model.extraModel.Admin_order;
import com.neusoft.service.IAdminService;
import com.neusoft.service.IGoodsManagerService;
import com.neusoft.service.IOrderService;
import com.neusoft.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Value("#{adminService}")
    private IAdminService adminService;
    @Value("#{orderService}")
    private IOrderService orderService;
    @Value("#{goodsManagerService}")
    private IGoodsManagerService goodsManagerService;

    @RequestMapping("admin_reg_page.do")
    public ModelAndView admin_reg_page(){
        ModelAndView mav = new ModelAndView("/admin/admin_reg_page");
        return mav;
    }

    //管理员注册的Servlet
    @RequestMapping("admin_register.do")
    public ModelAndView admin_register(AdminUser adminUser) throws IOException {
        return null;
    }

    @RequestMapping("admin_login.do")
    public ModelAndView admin_login(HttpServletRequest request, AdminUser adminUser){
        if(adminService.verify_AdminUser(adminUser) == false){
            return new ModelAndView("/admin/login");
        }
        request.getSession().setAttribute("admin_user", adminUser);
        return new ModelAndView("/admin/main");
    }

    @RequestMapping("admin_chat.do")
    public ModelAndView admin_chat(HttpServletRequest request){
        //官方客服页面
        ModelAndView mav = new ModelAndView("admin/admin_chat");
        return mav;
    }

    @RequestMapping("get_all_categories.do")
    public ModelAndView get_all_categories(){


        ModelAndView modelAndView = new ModelAndView("testFileUpload");
        return null;
    }

    @RequestMapping("admin_log_out.do")
    public ModelAndView admin_log_out(HttpServletRequest request){
        request.getSession().setAttribute("admin_user", null);
        return new ModelAndView("/admin/login");
    }

    @RequestMapping("entry_fahuo.do")
    public ModelAndView entry_fahuo(){
        ModelAndView mav = new ModelAndView("/admin/fahuo");
        mav.addObject("good_orders", adminService.getAllAdminOrdersIsFinished());
        return mav;
    }


    @RequestMapping("entry_weifahuo.do")
    public ModelAndView entry_weifahuo(){
        ModelAndView mav = new ModelAndView("/admin/fahuo");
        mav.addObject("good_orders", adminService.getAllAdminOrdersNotFinished());
        return mav;
    }

    @RequestMapping("entry_allorders.do")
    public ModelAndView entry_allorders(){
        List<Admin_order> orders = adminService.getAllAdminOrders();
        ModelAndView mav = new ModelAndView("/admin/fahuo");
        mav.addObject("good_orders", orders);
        return mav;
    }

    @RequestMapping("delete_order.do")
    public String delete_order(int orderid){
        orderService.delOrderById(orderid);
        return "forward:entry_allorders.do";
    }

    @RequestMapping("fahuo.do")
    public String fahuo(int orderid){
        orderService.updateOrder(true, orderid);
        return "forward:entry_allorders.do";
    }

    //获取所有一级分类
    @RequestMapping("parent_category.do")
    public ModelAndView parent_category(){
        List<Category> categories = adminService.getAllParentCategories();
        ModelAndView mav =   new ModelAndView("/admin/categories");
        mav.addObject("categories", categories);
        return mav;
    }

    @RequestMapping("son_category.do")
    public ModelAndView son_category(){
        List<Category> categories = adminService.getAllSonCategories();
        ModelAndView mav = new ModelAndView("/admin/categories");
        mav.addObject("categories", categories);
        return mav;
    }

    @RequestMapping("add_category.do")
    public String add_category(Category category){
        adminService.addCategory(category);
        return "redirect:parent_category.do";
    }

}


