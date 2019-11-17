package com.baidu.exam.controller;

import com.baidu.exam.model.ExamUser;
import com.baidu.exam.service.IExamItemService;
import com.baidu.exam.service.IExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 14:39
 * Description:试卷数据的控制器,
 */@Controller
@RequestMapping("/home")
public class ExamPaperController {
     @Autowired
     private IExamPaperService iExamPaperService;

     @Autowired
     private IExamItemService iExamItemService;

     //显示所有试卷,同时分页显示.在首页.
    @RequestMapping("/papers")
    public String home(Model model){
        model.addAttribute("page",iExamPaperService.getAllExamPaper(0));
        return "paper/home";
    }

    //搜索相关的试卷
    @RequestMapping("/search")
    public String search(String keyword,Model model){
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",iExamPaperService.searchExamPaper(keyword,1));
        return "paper/home";
    }

    //搜索相关试卷，同时到指定页面。
    @RequestMapping("/search/{page}")
    public String search(@PathVariable int page, String keyword, Model model){
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",iExamPaperService.searchExamPaper(keyword,page));
        return "paper/home";
    }

    //查看我的试卷。
    @RequestMapping("/mypaper")
    public ModelAndView myPaper(HttpSession session){
        ExamUser online = (ExamUser) session.getAttribute("online");
        return new ModelAndView("/paper/myPaper","page",
                iExamPaperService.getAllExamPaper(online.getUserid()));
    }


}
