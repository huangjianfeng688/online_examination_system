package com.baidu.exam.except;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2019-09-16 11:38
 * @desc：全局统一异常处理
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object o,
                                         Exception e) {
        MyException myException;
        String message = null;

        if (e instanceof MyException){
            myException = (MyException) e;
            message = myException.getMessage();

        }else{
            message = (e.getMessage()==null||"".equals(e.getMessage()))? "未知异常":e.getMessage();
        }
        return new ModelAndView("error/error","msg",message);
    }
}
