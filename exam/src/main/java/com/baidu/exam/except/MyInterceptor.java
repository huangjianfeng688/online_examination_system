package com.baidu.exam.except;

import com.baidu.exam.model.ExamUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @date 2019-09-16 12:28
 * @desc：拦截处理器
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = request.getSession();
        ExamUser online = (ExamUser) session.getAttribute("online");

        if (online==null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
