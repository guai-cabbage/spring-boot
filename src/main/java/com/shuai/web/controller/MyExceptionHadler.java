package com.shuai.web.controller;

import com.shuai.web.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  @Description：异常处理器
 *  @Author: guai
 *  @Date：2020/6/2 18:51
**/
@ControllerAdvice
public class MyExceptionHadler  {
    //浏览器客户端返回的都是json
    //指定要处理的异常
    //@ExceptionHandler(UserNotExistException.class)
    //@ResponseBody
//    public Map<String, Object> handlerException(Exception e){
//        //创建异常页面的json信息
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        map.put("exception",e.getClass());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        //创建异常页面的json信息
        Map<String,Object> map=new HashMap<>();

        map.put("code","user.notexist");
        map.put("message",e.getMessage()+"guai");
        map.put("exception",e.getClass());
        //将自定义的异常信息放到request域中，MyErrorAttributes组件将从请求域中获取该异常信息
        request.setAttribute("ext",map);
        //转发到error界面达到自适应的效果
        return "/error";
    }


}
