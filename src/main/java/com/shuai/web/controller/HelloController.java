package com.shuai.web.controller;

import com.shuai.web.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 *  @Description：  测试
 *  @Author: guai
 *  @Date：2020/5/28 9:07
**/
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user)
    {
        if("aa".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }
    //指定url请求的页面
//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }
}
