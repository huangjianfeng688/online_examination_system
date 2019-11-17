package com.baidu.exam.common;

import com.baidu.exam.mapper.ExamItemsMapper;
import com.baidu.exam.mapper.ExamScoreDetailMapper;
import com.baidu.exam.mapper.ExamScoreMapper;
import com.baidu.exam.model.ExamItems;
import com.baidu.exam.model.ExamScore;
import com.baidu.exam.model.ExamScoreDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 21:52
 * Description:计算分数类。
 */@Component
public class CalcScore {
     @Autowired
     private ExamItemsMapper examItemsMapper;
     @Autowired
     private ExamScoreMapper examScoreMapper;
     @Autowired
     private ExamScoreDetailMapper examScoreDetailMapper;

     //计算分数的方法。
     public  ExamScore getScore(Map answer, int paperid, int userid){
         int total = 0; //用于存总分。
         int rights = 0; //答对题目数。
         int errors = 0; //答错题目数。

        //查出所有题目的正确答案。
         List<ExamItems> examItemsList = examItemsMapper.searchItems(paperid);
         //存详细信息的集合。
         List<ExamScoreDetail> details = new ArrayList<>();

         //比对答案，计算得分。
         Iterator keys = answer.keySet().iterator();
         while(keys.hasNext()){
             ExamScoreDetail examScoreDetail = new ExamScoreDetail();

             //获取题号，
             String next = (String) keys.next();
             //设置题号。
             examScoreDetail.setEid(Integer.parseInt(next));

            //找到答案对应的题号
             for (int i = 0;i<examItemsList.size();i++){
                 //判断是否是同一道题。
                 if (examItemsList.get(i).getEid()==Integer.parseInt(next)){

                     //是同一道题，就存入用户答案。
                    examScoreDetail.setUanswer((String) answer.get(next));

                     //如果是相同题号，就进行答案的对比
                     if (answer.get(next)!=null&&answer.get(next).equals(examItemsList.get(i).getEkeys())){
                         //答案正确，就累加分数。
                         total+=examItemsList.get(i).getEscore();
                         //同时，正确题数也累加。
                         rights++;

                         //对了，所得分数就是这个题目的分数
                         examScoreDetail.setUpoint(examItemsList.get(i).getEscore());


                     }else{
                         //否则错误题数累加。
                         errors++;

                         //错了，所得分数为0；
                        examScoreDetail.setUpoint(0);
                     }

                 }
             }

             //添加到list集合中。
             details.add(examScoreDetail);
         }

        //将成绩存入数据库中。
         ExamScore examScore = new ExamScore();
            examScore.setPaperid(paperid);
            examScore.setUserid(userid);
            examScore.setScore(total);
            examScore.setRights(rights);
            examScore.setErrors(errors);
         examScoreMapper.insertSelective(examScore);


         //遍历设置成绩的id，
        for (int i = 0; i<details.size();i++){
            //遍历设置成绩id
            details.get(i).setScoreid(examScore.getScoreid());
        }

        //将成绩详情集合存到数据库中
         examScoreDetailMapper.insertExamScoreDetailsByList(details);

         return examScore;
     }
}
