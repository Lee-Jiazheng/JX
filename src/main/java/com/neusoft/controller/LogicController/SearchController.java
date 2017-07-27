package com.neusoft.controller.LogicController;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.model.Goods;
import com.neusoft.model.extraModel.Good_with_photo;
import com.neusoft.service.IAdminService;
import com.neusoft.service.ISearchService;
import com.neusoft.service.impl.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Bruce Lee on 2017/7/26.
 */
@Controller
public class SearchController {

    @Value("#{searchService}")
    private ISearchService searchService;
    @Value("#{adminService}")
    private IAdminService adminService;
    /**
     * query_goods_name是查询的商品名称
     * query_type 是查询类型， 例如价格、销量
     * query_flag 是按照升序降序排列，1是升序，0是降序
     */
    @RequestMapping("search.do")
    public ModelAndView search(String query_goods_name, int query_type, int query_flag, HttpServletRequest request){
        //if(query_goods_name == null && request.getSession().get)
        request.getSession().setAttribute("query_goods_name", query_goods_name);
        List<Goods> goodsList = new ArrayList<>();
        switch (query_type){
            case 0://简单地查一下
                goodsList = searchService.getGoodsByWord(query_goods_name); break;
            case 1://按照价格排序
                if(query_flag == 1){//升序
                    goodsList = searchService.ascByPrice(query_goods_name);
                }else{
                    goodsList = searchService.descByPrice(query_goods_name);
                }break;
            case 2://按照销量（数量）排序
                if(query_flag == 1){//升序
                    goodsList = searchService.ascBySales(query_goods_name);
                }else{
                    goodsList = searchService.descBySales(query_goods_name);
                }break;
            case 3://按照创建时间排序
                if(query_flag == 1){//升序
                    goodsList = searchService.ascByCreateTime(query_goods_name);
                }else{
                    goodsList = searchService.descByCreateTime(query_goods_name);
                }break;
        }
        ModelAndView mav = new ModelAndView("list");
        List<Good_with_photo> good_with_photos = new ArrayList<>();
        for (Goods good : goodsList){
            Good_with_photo temp_good_photo = new Good_with_photo();
            temp_good_photo.setGoodsid(good.getGoodsid());
            temp_good_photo.setGoodsprice(good.getGoodsprice());
            temp_good_photo.setGoodsname(good.getGoodsname());
            temp_good_photo.setPhoto(adminService.getGoodPhotoByGoodId(good.getGoodsid()));
            good_with_photos.add(temp_good_photo);
        }
        mav.addObject("result_goods", good_with_photos);
        return mav;
    }
}
