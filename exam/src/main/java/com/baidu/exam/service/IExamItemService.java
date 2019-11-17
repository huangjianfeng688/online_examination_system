package com.baidu.exam.service;

import com.baidu.exam.model.ExamItems;
import com.baidu.exam.model.ExamScore;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 16:22
 * Description:题目的数据逻辑层接口.
 */
public interface IExamItemService {

    //根据试卷id,查询该试卷的所有题目.
    public List<ExamItems> getItemsByPaperId(int paperid);

    //计算分数，同时将分数存到分数表中。，
    public ExamScore saveScore(Map<String,String> map,int paperid,int userid);

    //查询所有题目的信息，分数，答案，以及解析。
    public List<ExamItems> getItemsAndScore(int paperid,int userid);

}
