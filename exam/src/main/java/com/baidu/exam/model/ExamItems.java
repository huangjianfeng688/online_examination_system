package com.baidu.exam.model;

public class ExamItems {
    private Integer eid;

    private String ename;

    private int epaperid;

    public int getEpaperid() {
        return epaperid;
    }

    public void setEpaperid(int epaperid) {
        this.epaperid = epaperid;
    }

    private ExamPaper examPaper;

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }


    private ExamScoreDetail examScoreDetail;

    public ExamScoreDetail getExamScoreDetail() {
        return examScoreDetail;
    }

    public void setExamScoreDetail(ExamScoreDetail examScoreDetail) {
        this.examScoreDetail = examScoreDetail;
    }

    private Integer escore;

    private Integer etype;

    private Integer edegree;

    private String ea;

    private String eb;

    private String ec;

    private String ed;

    private String ee;

    private String ef;

    private String ekeys;

    private String ehints;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }


    public Integer getEscore() {
        return escore;
    }

    public void setEscore(Integer escore) {
        this.escore = escore;
    }

    public Integer getEtype() {
        return etype;
    }

    public void setEtype(Integer etype) {
        this.etype = etype;
    }

    public Integer getEdegree() {
        return edegree;
    }

    public void setEdegree(Integer edegree) {
        this.edegree = edegree;
    }

    public String getEa() {
        return ea;
    }

    public void setEa(String ea) {
        this.ea = ea == null ? null : ea.trim();
    }

    public String getEb() {
        return eb;
    }

    public void setEb(String eb) {
        this.eb = eb == null ? null : eb.trim();
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec == null ? null : ec.trim();
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed == null ? null : ed.trim();
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee == null ? null : ee.trim();
    }

    public String getEf() {
        return ef;
    }

    public void setEf(String ef) {
        this.ef = ef == null ? null : ef.trim();
    }

    public String getEkeys() {
        return ekeys;
    }

    public void setEkeys(String ekeys) {
        this.ekeys = ekeys == null ? null : ekeys.trim();
    }

    public String getEhints() {
        return ehints;
    }

    public void setEhints(String ehints) {
        this.ehints = ehints == null ? null : ehints.trim();
    }
}