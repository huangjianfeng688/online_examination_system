package com.baidu.exam.service;

import com.baidu.exam.common.CalcScore;
import com.baidu.exam.mapper.ExamItemsMapper;
import com.baidu.exam.model.ExamItems;
import com.baidu.exam.model.ExamItemsExample;
import com.baidu.exam.model.ExamPaper;
import com.baidu.exam.model.ExamScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 16:25
 * Description: 题目的service层,业务逻辑层.
 */@Service
public class ExamItemServiceImpl implements IExamItemService {
     @Autowired
     private ExamItemsMapper examItemsMapper;
     @Autowired
     private CalcScore calcScore;

    @Override //根据试卷,查询题目.
    public List<ExamItems> getItemsByPaperId(int paperid) {
        return  examItemsMapper.searchItems(paperid);
    }

    @Override  //存答案，计算分数。存分数
    public ExamScore saveScore(Map<String, String> map, int paperid, int userid) {
        return calcScore.getScore(map,paperid,userid);
    }

    @Override  //获取试卷的解析，and 答案。
    public List<ExamItems> getItemsAndScore(int paperid,int userid) {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setPaperid(paperid);
        examPaper.setUserid(userid);


        return examItemsMapper.findAllItemsAndScore(examPaper);
    }
}
