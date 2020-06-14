package com.shuai.web.config;

import com.shuai.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  @Description：使用WebMvcConfigurerAdapter来扩展springMvc的功能
 *  @Author: guai
 *  @Date：2020/5/28 17:12
**/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 浏览器发送wonderful请求，来到success页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wonderful").setViewName("success");
    }




    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //放行以下请求
        //registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
       // .excludePathPatterns("/index.html","/login","/user/login","/webjars/**");

    }


    //所有的WebMvcConfigureAdapter组件都会在一起起作用
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }
        };

        return adapter;
    }
    // @Bean :将组件加载到容器中
//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//     WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
//         @Override
//         public void addViewControllers(ViewControllerRegistry registry) {
//
//         }
//     };
//
//     return adapter;
//    }


    //在配置类中配置地区语言信息
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
