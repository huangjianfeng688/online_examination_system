package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamItems;
import com.baidu.exam.model.ExamItemsExample;
import java.util.List;

import com.baidu.exam.model.ExamPaper;
import org.apache.ibatis.annotations.Param;

public interface ExamItemsMapper {
    int countByExample(ExamItemsExample example);

    int deleteByExample(ExamItemsExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(ExamItems record);

    int insertSelective(ExamItems record);

    List<ExamItems> selectByExample(ExamItemsExample example);

    ExamItems selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") ExamItems record, @Param("example") ExamItemsExample example);

    int updateByExample(@Param("record") ExamItems record, @Param("example") ExamItemsExample example);

    int updateByPrimaryKeySelective(ExamItems record);

    int updateByPrimaryKey(ExamItems record);

    //查询所有试题信息,根据试卷查询.
    List<ExamItems> searchItems(int paperid);

    //查询该用户的答卷，以及答案，对应的得分。
    List<ExamItems> findAllItemsAndScore(ExamPaper examPaper);
}