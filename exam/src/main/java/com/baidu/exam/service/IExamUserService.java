package com.baidu.exam.service;

import com.baidu.exam.model.ExamUser;
import com.baidu.exam.model.ExamUserExample;

/**
 * Created with IntelliJ IDEA.
 * User: samsung
 * Date: 2019/9/14
 * Time: 12:07
 * Description:用户service接口.
 */
public interface IExamUserService {

    //通过用户查询一个用户信息,用于登录.
    public ExamUser searchExamUser(String uname,String upwd );

    //保存一个用户信息,用于用户注册功能.
    public int saveExamUser(ExamUser examUser);

}
