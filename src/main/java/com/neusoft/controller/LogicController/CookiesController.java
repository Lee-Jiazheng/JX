package com.neusoft.controller.LogicController;

import com.neusoft.model.Goods;
import com.neusoft.service.impl.CommentsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

/**
 * Created by Bruce Lee on 2017/7/25.
 */
@Controller
public class CookiesController {

    /*@Value("#{commentsService}")
    private CommentsService commentsService;*/

    @RequestMapping("add_good_to_shop_cart.do")
    public ModelAndView add_good_to_shop_cart( HttpServletRequest request, HttpServletResponse response){
        User user = (User)request.getSession().getAttribute("user");
        //未登录加入到cookie中
        if(user == null){}
        int goodId = Integer.parseInt(request.getParameter("goodId"));
        //Goods good = commentsService.getGoodsInfoByID(goodId);
        Cookie[] cookies = request.getCookies();
        Cookie cookie = new Cookie("shop_cart_good" + cookies.length, String.valueOf(goodId));
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        /*boolean exist = true;
        for(int i = 0; i < cookies.length; ++i){
            if("shop_cart_list" == cookies[i].getName()){
                exist = false; break;
            }
        }
        if(exist == false){

        }*/
        //返回原先商品界面
        //request.getHeader("")
        return null;
    }

    //删除一个商品
    @RequestMapping("delete_shop_cart.do")
    public ModelAndView delete_shop_cart(int goodId, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = null;
        // 获取与该域相关的 Cookie 的数组
        cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getValue() == String.valueOf(goodId)){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        return null;
    }
}
