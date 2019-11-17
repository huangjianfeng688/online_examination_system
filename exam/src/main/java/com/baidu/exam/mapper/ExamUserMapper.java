package com.baidu.exam.mapper;

import com.baidu.exam.model.ExamUser;
import com.baidu.exam.model.ExamUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamUserMapper {
    int countByExample(ExamUserExample example);

    int deleteByExample(ExamUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(ExamUser record);

    int insertSelective(ExamUser record);

    List<ExamUser> selectByExample(ExamUserExample example);

    ExamUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") ExamUser record, @Param("example") ExamUserExample example);

    int updateByExample(@Param("record") ExamUser record, @Param("example") ExamUserExample example);

    int updateByPrimaryKeySelective(ExamUser record);

    int updateByPrimaryKey(ExamUser record);

    ExamUser searchExamUser(ExamUser examUser);
}