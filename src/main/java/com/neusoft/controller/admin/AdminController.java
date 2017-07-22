package com.neusoft.controller.admin;

import com.neusoft.config.ModuleConfig;
import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.AdminUser;
import com.neusoft.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

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
    public ModelAndView admin_login(HttpServletRequest request, User user){
        return null;
    }
}

