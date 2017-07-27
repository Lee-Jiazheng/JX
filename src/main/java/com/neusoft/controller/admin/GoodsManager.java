package com.neusoft.controller.admin;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.mapper.ICommentsMapper;
import com.neusoft.model.Category;
import com.neusoft.model.Comments;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.Good_with_photo;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ICommentsService;
import com.sun.javafx.sg.prism.NGShape;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
@RequestMapping("/admin/")
public class GoodsManager {

    @Value("#{adminService}")
    private IAdminService adminService;
    @Value("#{commentsService}")
    private ICommentsService commentsService;

    @RequestMapping("comment_manager.do")
    public ModelAndView comment_manager(){
        Map<Goods, List<Comments>> good_and_comments = commentsService.getAllCommentsAndGoods();
        ModelAndView mav = new ModelAndView("/admin/comments_manager");
        mav.addObject("good_comments_map", good_and_comments);
        return mav;
    }

    @RequestMapping("delete_comment.do")
    public ModelAndView delete_comment(HttpServletRequest request){
        commentsService.deleteCommentById(Integer.parseInt(request.getParameter("commentsid")));
        ModelAndView mav = new ModelAndView("/admin/comments_manager");
        return mav;
    }

    @RequestMapping("good_manager.do")
    public ModelAndView good_manager(){
        List<Goods> goods = commentsService.getAllGoods();
        List<Good_with_photo> good_with_photos = new ArrayList<>();
        for(Goods good : goods){
            Good_with_photo good_with_photo = new Good_with_photo();
            good_with_photo.setGoodsname(good.getGoodsname());
            good_with_photo.setGoodscreatetime(good.getGoodscreatetime());
            good_with_photo.setGoodsdescription(good.getGoodsdescription());
            good_with_photo.setGoodsid(good.getGoodsid());
            good_with_photo.setGoodsprice(good.getGoodsprice());
            good_with_photo.setGoodsquantity(good.getGoodsquantity());
            good_with_photo.setPhoto(adminService.getGoodPhotoByGoodId(good.getGoodsid()));
            good_with_photos.add(good_with_photo);
        }
        ModelAndView mav = new ModelAndView("/admin/goods_manager");
        mav.addObject("goods", good_with_photos);
        return mav;
    }

    //����һ����Ʒ
    @RequestMapping("add_good.do")
    public ModelAndView add_good(Goods good){
       /* Goods good = new Goods();
        good.setGoodsname("����");
        Date date = new Date();

        good.setGoodsCreateTime(date);
        good.setGoodsCategory(2);
        good.setGoodsQuantity(100);
        good.setGoodsPrice(99.9);
        good.setGoodsStatus(0);
        good.setGoodsUpdateTime(date);*/
        adminService.add_good(good);
        return null;
    }




}
