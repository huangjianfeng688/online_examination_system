package com.baidu.exam.model;

public class ExamUser {
    private Integer userid;

    private String uname;

    private String upwd;

    public ExamUser(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public ExamUser() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }
}