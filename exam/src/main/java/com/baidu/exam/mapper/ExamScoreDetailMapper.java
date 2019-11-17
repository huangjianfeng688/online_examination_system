package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamScoreDetail;
import com.baidu.exam.model.ExamScoreDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamScoreDetailMapper {
    int countByExample(ExamScoreDetailExample example);

    int deleteByExample(ExamScoreDetailExample example);

    int deleteByPrimaryKey(Integer detailid);

    int insert(ExamScoreDetail record);

    int insertSelective(ExamScoreDetail record);

    List<ExamScoreDetail> selectByExample(ExamScoreDetailExample example);

    ExamScoreDetail selectByPrimaryKey(Integer detailid);

    int updateByExampleSelective(@Param("record") ExamScoreDetail record, @Param("example") ExamScoreDetailExample example);

    int updateByExample(@Param("record") ExamScoreDetail record, @Param("example") ExamScoreDetailExample example);

    int updateByPrimaryKeySelective(ExamScoreDetail record);

    int updateByPrimaryKey(ExamScoreDetail record);

    int insertExamScoreDetailsByList(List<ExamScoreDetail> list);
}