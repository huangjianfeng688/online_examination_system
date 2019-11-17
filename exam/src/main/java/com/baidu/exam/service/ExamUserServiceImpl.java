package com.baidu.exam.service;

import com.baidu.exam.mapper.ExamUserMapper;
import com.baidu.exam.model.ExamUser;
import com.baidu.exam.model.ExamUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 12:12
 * Description:service层实现类
 */@Service
public class ExamUserServiceImpl implements IExamUserService {

    @Autowired
    private ExamUserMapper examUserMapper;

    @Override//查询一个用户信息,通过用户名和密码进行查询
    public ExamUser searchExamUser(String uname, String upwd) {
        ExamUser examUser = new ExamUser();
        examUser.setUname(uname);
        examUser.setUpwd(upwd);
        return examUserMapper.searchExamUser(examUser);
    }

    @Override //用于注册,保存一个用户信息.
    public int saveExamUser(ExamUser examUser) {
        return examUserMapper.insertSelective(examUser);
    }
}
