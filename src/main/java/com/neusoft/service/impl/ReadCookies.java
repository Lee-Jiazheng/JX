package com.neusoft.service.impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ReadCookies
 */
@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length > 5) {
            ArrayList<String[]> goodslists = new ArrayList<String[]>();
            int i = 1;
            for (int j = 0; j < cookies.length / 5; j++) {
                String[] strings = new String[5];
                for (int k = 0; k < strings.length; k++) {
                    strings[k] = java.net.URLDecoder.decode(cookies[i++]
                            .getValue(), "UTF-8");
                }
                goodslists.add(strings);
            }
        }

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