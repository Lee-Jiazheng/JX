package com.neusoft.controller;

import com.neusoft.mapper.IUserMapper;
import com.neusoft.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
 * 例如，用户登录及注册*/
@Controller
public class UserManager {

    @RequestMapping("user_login")
    public ModelAndView user_login(HttpServletRequest request){
        HttpSession session = request.getSession();
        return null;
    }

    @RequestMapping("user_register")
    public ModelAndView user_register(HttpServletRequest request){
        return null;
    }

    @RequestMapping("test")
    public ModelAndView test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂,传入Mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        List<User> users = userMapper.getSelectUser();
        ModelAndView mav = new ModelAndView("index.jsp");
        return mav;
    }

    @RequestMapping("chat")
    public ModelAndView chat() {
        ModelAndView mav = new ModelAndView("chat");

        return mav;
    }
}
