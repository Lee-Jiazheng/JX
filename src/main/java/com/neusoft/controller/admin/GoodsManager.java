package com.neusoft.controller.admin;

import com.neusoft.mapper.IAdminMapper;
import com.neusoft.model.Category;
import com.neusoft.model.Goods;
import com.neusoft.service.IAdminService;
import org.apache.commons.io.FileUtils;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
@RequestMapping("/admin/")
public class GoodsManager {

    @Value("#{adminService}")
    private IAdminService adminService;



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
