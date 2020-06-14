package com.shuai.web.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 *  @Description： 给容器中加入自己定义的MyErrorAttributes以实现显示自定义的异常信息
 *  @Author: guai
 *  @Date：2020/6/2 20:11
**/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    //返回值的map就是页面和json能获取的所有属性
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company","guai");
        //从request域中获取异常控制器中定义的异常信息
        Map<String,Object> ext= (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }


//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String,Object>map=new HashMap<>();
//        //获取request域中获取map 异常处理器
//         Map<String,Object> ext=(Map<String, Object>) webRequest.getAttribute("ext",0);
//         map.put("code","user.notexist");
//         map.put("ext",map);
//         map.put("message","用户不存在");
//         map.put("exception",map.get("exception"));
//        return map;
//    }
}
