package com.neusoft.controller.user;

import com.neusoft.config.ModuleConfig;
import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.IChatMapper;
import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.ChatUserRecord;
import com.neusoft.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.security.pkcs11.Secmod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/17.
 */
/**
 * 本文件是与用户管理相关的所有Servlet
 * 例如，用户登录及注册
 */
@Controller
public class UserManager {

    @RequestMapping("verify_username.do")
    public boolean verify_username(HttpServletRequest request) throws IOException {
        String test_name = (String)request.getParameter("test_name");
        User test_user = new ModuleConfig().getSqlSession().getMapper(IUserMapper.class).getUserByName("test_name");
        if(test_user == null)
            return true;
        return false;
    }

    @RequestMapping("user_login.do")
    public ModelAndView user_login(User user, HttpServletRequest request) throws IOException {
        ModelAndView mav = new ModelAndView();
        if(new ModuleConfig().getSqlSession().getMapper(IUserMapper.class).verifyUser(user) == null){
            //验证失败，返回失败信息，跳转到登陆界面
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        return mav;
    }

    //用户注册
    @RequestMapping("user_register.do")
    public ModelAndView user_register(User user, HttpServletRequest request) throws IOException {
        User test_user = new ModuleConfig().getSqlSession().getMapper(IUserMapper.class).getUserByName(user.getNickName());
        if(test_user == null){
            //把用戶数据添加进入数据库
        }else{

        }
        return null;
    }


    @RequestMapping("chat.do")
    public ModelAndView chat(HttpServletRequest request) throws IOException {
        request.getParameter("user_id");
        HttpSession session = request.getSession();
        //List<User> users = new ModuleConfig().getSqlSession().getMapper(IChatMapper.class).getAllChatUserByUserId(((User)session.getAttribute("user")).getUserId());
        
        List<User> users = new ModuleConfig().getSqlSession().getMapper(IChatMapper.class).getAllChatUserByUserId(1);
        ModelAndView mav = new ModelAndView("chat");
        mav.addObject("chat_users", users);
        mav.setViewName("chat");
        return mav;
    }
}
