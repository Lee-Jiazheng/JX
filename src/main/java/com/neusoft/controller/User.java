package com.neusoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Bruce Lee on 2017/7/14.
 */
@Controller
public class User {

    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index.jsp");
        return mav;
    }
}
