package com.neusoft.controller.admin;

import com.neusoft.model.Goods;
import com.neusoft.service.IAdminService;
import com.neusoft.service.IGoodsManagerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
public class GoodsController {

    @Value("#{goodsManagerService}")
    private IGoodsManagerService goodsManagerService;
    @Value("#{adminService}")
    private IAdminService adminService;


    @RequestMapping(value="add_goods.do", method = RequestMethod.POST)
    public String add_goods(Goods goods, MultipartFile goods_image, HttpServletRequest request, int categoryid) {

        goods.setGoodscreatetime(new Date());
        goods.setGoodsupdatetime(new Date());
        goods.setGoodscategory(categoryid);
        String path = request.getSession().getServletContext().getRealPath("/good_picture");
        String fileName = UUID.randomUUID().toString().replace("-", "") + goods_image.getOriginalFilename();
        goodsManagerService.addGoods(goods);

        try{
            //FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());
            goods_image.transferTo(new File(path+ '/' + fileName));
            goodsManagerService.addGoodsPhoto (adminService.getGoodsIdByGoodsName(goods.getGoodsname()), fileName);
        }catch (IOException e){
            System.out.println("文件上传失败");
        }
        return "redirect:/admin/good_manager.do";
    }

    @RequestMapping("add_goods_photo.do")
    public ModelAndView add_goods_photo(int goodsId, String photo) {
        ModelAndView mav = new ModelAndView("add_goods_photo");
        if (goodsId != -1 && photo != null) {
            goodsManagerService.addGoodsPhoto(goodsId, photo);
            mav.addObject("add_goods_status", "OK");
        }
        return mav;
    }

    @RequestMapping("del_goods_photo.do")
    public ModelAndView del_goods_photo(int goodsId) {
        ModelAndView mav = new ModelAndView("del_goods_photo");
        goodsManagerService.delGoodsById(goodsId);
        mav.addObject("del_goods_status", "OK");
        return mav;
    }



    @RequestMapping("get_all_goods.do")
    public ModelAndView get_all_goods() {
        ModelAndView mav = new ModelAndView();
        List<Goods> goodsList = goodsManagerService.getAllGoods();
        mav.addObject("all_goods", goodsList);
        return mav;
    }

    @RequestMapping("get_goods_by_word.do")
    public ModelAndView get_goods_by_word(String goodsName) {
        ModelAndView mav = new ModelAndView();
        List<Goods> goods = goodsManagerService.getGoodsByWord(goodsName);
        mav.addObject("search_result", goods);
        return mav;
    }



    @RequestMapping("update_goods.do")
    public ModelAndView update_goods(Goods goods) {
        ModelAndView mav = new ModelAndView("update_goods");
        if (goods != null) {
            goodsManagerService.updateGoods(goods);
            mav.addObject("update_status", "OK");
        }
        return mav;
    }
}
