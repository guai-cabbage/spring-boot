package com.shuai.web.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 *  @Description：  在连接上携带区域信息
 *  @Author: guai
 *  @Date：2020/5/28 23:43
**/

public class MyLocaleResolver  implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //从参数中获取国际化属性
        String l=request.getParameter("l");
        //创建默认的locale对象
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            //截取参数获取地区和语言信息
            //http://localhost:8080/crud/login.html?l=en_US
            String[] splits=l.split("_");
            //根据地区语言信息创建locale对象
            locale=new Locale(splits[0],splits[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
