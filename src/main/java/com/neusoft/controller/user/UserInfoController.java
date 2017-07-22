package com.neusoft.controller.user;

import com.neusoft.model.User;
import com.neusoft.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Bruce Lee on 2017/7/22.
 */
@Controller
public class UserInfoController {
    @Value("#{userManager}")
    private IUserService userService;



    @RequestMapping("user_avatar.do")
    public ModelAndView user_avatar(MultipartFile file, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(userService.change_avatar(file, user, session.getServletContext().getRealPath("/avatar")) == true){
            //上传成功
        }

        return null;
    }
}
