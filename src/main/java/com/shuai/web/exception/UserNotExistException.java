package com.shuai.web.exception;
/**
 *  @Description：自定义异常类
 *  @Author: guai
 *  @Date：2020/6/2 15:14
**/
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在");
    }
}
