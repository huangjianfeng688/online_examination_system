package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamScore;
import com.baidu.exam.model.ExamScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamScoreMapper {
    int countByExample(ExamScoreExample example);

    int deleteByExample(ExamScoreExample example);

    int deleteByPrimaryKey(Integer scoreid);

    int insert(ExamScore record);

    int insertSelective(ExamScore record);

    List<ExamScore> selectByExample(ExamScoreExample example);

    ExamScore selectByPrimaryKey(Integer scoreid);

    int updateByExampleSelective(@Param("record") ExamScore record, @Param("example") ExamScoreExample example);

    int updateByExample(@Param("record") ExamScore record, @Param("example") ExamScoreExample example);

    int updateByPrimaryKeySelective(ExamScore record);

    int updateByPrimaryKey(ExamScore record);
}