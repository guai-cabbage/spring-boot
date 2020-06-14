package com.shuai.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 *  @Description：自定义监听器
 *  @Author: guai
 *  @Date：2020/6/14 13:53
**/
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("服务开启");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("服务关闭");
    }
}
