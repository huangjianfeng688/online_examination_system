package com.baidu.exam.controller;

import com.baidu.exam.except.MyException;
import com.baidu.exam.model.ExamUser;
import com.baidu.exam.service.IExamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 14:03
 * Description:
 */@Controller
@RequestMapping("/user")
public class ExamUserController {
     @Autowired
     private IExamUserService iExamUserService;

     //去登录界面,
    @RequestMapping("/tologin")
    public String tologin(){

     return "user/login";
    }

    //实现登录功能.
    @RequestMapping("/login")
    public String login(String uname, String upwd, HttpSession session){
        //查询该用户是否存在.
        ExamUser examUser = iExamUserService.searchExamUser(uname, upwd);
        if (examUser==null){
         throw new MyException("用户名或者密码错误");
        }else{
            session.setAttribute("online",examUser);
            return "redirect:/home/papers.action";
        }
    }

    //去注册界面
    @RequestMapping("/toregister")
    public String toregister(){

        return "user/register";
    }

    //注册功能
    @RequestMapping("/register")
    public String register(String uname, String upwd){
        iExamUserService.saveExamUser(new ExamUser(uname,upwd));
        return "redirect:tologin.action";
    }
}
