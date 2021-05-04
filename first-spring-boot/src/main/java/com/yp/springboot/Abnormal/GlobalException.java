package com.yp.springboot.Abnormal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration

public class GlobalException implements HandlerExceptionResolver {


    @Override
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        String message = null;
        if (e instanceof ArithmeticException) {
            System.out.println("数学异常");
            message = "数学异常";
        }
        if (e instanceof NullPointerException) {
            System.out.println("空指针异常");
            message = "空指针异常";
        }
        mv.addObject("message", message);
        return mv;
    }
}
