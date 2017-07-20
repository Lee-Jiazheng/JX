package com.neusoft.controller.admin;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Bruce Lee on 2017/7/18.
 */
@Controller
@RequestMapping("/admin/")
public class GoodsManager {

    //@RequestMapping("add_good.do")
    @RequestMapping("upload.do")
    public ModelAndView upload(MultipartFile file, HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
        try{
            FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());
        }catch (IOException e){
            System.out.println("文件上传失败");
        }
        return null;
    }

}
