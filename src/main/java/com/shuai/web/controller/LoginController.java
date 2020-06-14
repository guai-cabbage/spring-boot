package com.shuai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *  @Description：登录控制器
 *  @Author: guai
 *  @Date：2020/5/29 10:07
**/
@Controller

public class LoginController {

                       // @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String loginguai(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Map<String,Object> errorMessage,
                        HttpSession session){
        if(!StringUtils.isEmpty(userName)&&("123").equals(password)){
            session.setAttribute("userName",userName);
            return "redirect:/dashboard.html";
        }else{
            //登陆失败
            errorMessage.put("msg","用户名密码错误");
            return "login";
        }

    }
}
