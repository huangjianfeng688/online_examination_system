package com.baidu.exam.service;

import com.baidu.exam.common.PageBean;
import com.baidu.exam.mapper.ExamPaperMapper;
import com.baidu.exam.model.ExamPaper;
import com.baidu.exam.model.ExamPaperExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 13:26
 * Description: 业务逻辑层实现
 */@Service
public class ExamPaperServiceImpl implements IExamPaperService{
     @Autowired
     private ExamPaperMapper examPaperMapper;

    @Override //查询所有的试卷.
    public PageBean<ExamPaper> getAllExamPaper(int userid) {
        List<ExamPaper> examPapers = null;

        //开始分页.
        PageHelper.startPage(1,5);
        if (userid==0){
             examPapers = examPaperMapper.selectByExample(null);
        }else{
             examPapers = examPaperMapper.selectExamPapersByUserid(userid);
        }

        Page<ExamPaper> papers = (Page<ExamPaper>) examPapers;

        PageBean<ExamPaper> pageBean= new PageBean<>(
                papers.getTotal() , papers.getResult(),
                papers.getPageNum(),papers.getPages(),
                papers.getPageSize());

        return pageBean;

    }

    @Override
    public PageBean<ExamPaper> searchExamPaper(String keyWord, int pageIndex) {

        ExamPaper examPaper = new ExamPaper();

        examPaper.setPapername("%"+keyWord+"%");

        //开始分页.
        PageHelper.startPage(pageIndex,5);
        List<ExamPaper> examPapers = examPaperMapper.selectExamPapers(examPaper);

        Page<ExamPaper> papers = (Page<ExamPaper>) examPapers;

        PageBean<ExamPaper> pageBean= new PageBean<>(
                papers.getTotal() , papers.getResult(),
                papers.getPageNum(),papers.getPages(),
                papers.getPageSize());

        return pageBean;
    }
}
