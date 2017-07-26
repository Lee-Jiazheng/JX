package com.neusoft.service.impl;

import com.neusoft.model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShopCartCookies")
public class ShopCartCookies extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        int times = 1 * 24 * 60 * 60;
        List<Goods> goodsList =
                (List<Goods>)request.getSession().getAttribute("goodsList");
        int i = 0;

        for (Goods goods:goodsList) {
            i++;
            Cookie cookie = new Cookie("item_id_" + i,
                    String.valueOf(goods.getGoodsid()));
            cookie.setMaxAge(times);
            response.addCookie(cookie);
            cookie = new Cookie("item_img_" + i, goods.getGoodsdescription());
            cookie.setMaxAge(times);
            response.addCookie(cookie);
            cookie = new Cookie("item_title_" + i, goods.getGoodsname());
            cookie.setMaxAge(times);
            response.addCookie(cookie);
            cookie = new Cookie("item_URL_" + i, String.valueOf(goods.getGoodsid()));
            cookie.setMaxAge(times);
            response.addCookie(cookie);
            cookie = new Cookie("item_price_" + i,
                    String.valueOf(goods.getGoodsprice()));
            cookie.setMaxAge(times);
            response.addCookie(cookie);

        }


        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request,
     * HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
