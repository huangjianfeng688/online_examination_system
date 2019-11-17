package com.baidu.exam.controller;

import com.baidu.exam.model.ExamScore;
import com.baidu.exam.model.ExamUser;
import com.baidu.exam.service.IExamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 16:11
 * Description:答题卡,控制器.
 */@Controller
@RequestMapping("/exam")
public class ExamPaperCardController {

     @Autowired
     private IExamItemService iExamItemService;

     //答题卷
     @RequestMapping("/paper/{paperid}")
     public String startExam(@PathVariable int paperid,Model model){

         model.addAttribute("items",iExamItemService.getItemsByPaperId(paperid));
         model.addAttribute("paperid",paperid);

         return "paper/testPaper";
     }


     //提交答案，运算分数控制器。
    @RequestMapping("/{paperid}/result")
    public String ExamResult(@PathVariable int paperid, HttpServletRequest request, HttpSession session,Model model){
        // key:题号，value：用户答案
        Map<String,String> userAnswers = new HashMap<>(); //用于存用户提交的答案。

        //对用户的答案和题号进行封装。
        for (int i = 18,j = 0 ; i< 33 ;i++,j++){
            String an = request.getParameter(i+"");
            System.out.println(i+"-->"+an);
            userAnswers.put(i+"",an);
        }
        ExamUser online = (ExamUser) session.getAttribute("online");

        //调用service层接口。获取成绩对象
        ExamScore examScore = iExamItemService.saveScore(userAnswers, paperid, online.getUserid());

        model.addAttribute("score",examScore);

        return "paper/score";
    }


    //查看答案解析；
    @RequestMapping("/{paperid}/check")
    public String  getAngni(@PathVariable int paperid,String papername,Model model,
                                 HttpSession session){
        ExamUser online = (ExamUser) session.getAttribute("online");

        model.addAttribute("items",iExamItemService.getItemsAndScore(paperid,online.getUserid()));

        model.addAttribute("papername",papername);

        return "/paper/chechPaper";

    }

}
