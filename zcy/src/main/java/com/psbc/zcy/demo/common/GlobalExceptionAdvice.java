package com.psbc.zcy.demo.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(HttpServletRequest reg, Exception e){
        // 里面是处理异常的代码，比如返回通用的报错信息，在这只是做一个演示
        System.out.println("GlobalExceptionAdvice");
        return new Result<>(e);
    }
}
