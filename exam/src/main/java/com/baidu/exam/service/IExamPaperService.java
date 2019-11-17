package com.baidu.exam.service;

import com.baidu.exam.common.PageBean;
import com.baidu.exam.model.ExamPaper;
import com.baidu.exam.model.ExamUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 13:16
 * Description: 考试试卷的业务逻辑层接口.
 */
public interface IExamPaperService {

    //查询所有的试卷,同时分页显示.
    public PageBean<ExamPaper> getAllExamPaper(int userid);

    //查找试卷,同时分页显示
    public PageBean<ExamPaper> searchExamPaper(String keyWord,int pageIndex);


}
