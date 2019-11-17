package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamPaper;
import com.baidu.exam.model.ExamPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamPaperMapper {
    int countByExample(ExamPaperExample example);

    int deleteByExample(ExamPaperExample example);

    int deleteByPrimaryKey(Integer paperid);

    int insert(ExamPaper record);

    int insertSelective(ExamPaper record);

    List<ExamPaper> selectByExample(ExamPaperExample example);

    ExamPaper selectByPrimaryKey(Integer paperid);

    int updateByExampleSelective(@Param("record") ExamPaper record, @Param("example") ExamPaperExample example);

    int updateByExample(@Param("record") ExamPaper record, @Param("example") ExamPaperExample example);

    int updateByPrimaryKeySelective(ExamPaper record);

    int updateByPrimaryKey(ExamPaper record);

    List<ExamPaper> selectExamPapers(ExamPaper examPaper);

    List<ExamPaper> selectExamPapersByUserid(int userid);
}