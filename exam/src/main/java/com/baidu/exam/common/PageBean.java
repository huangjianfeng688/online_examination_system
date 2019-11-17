package com.baidu.exam.common;

import java.util.List;

/**
 * 分页的bean.
 */
public class PageBean<T> {
    private long total; //总记录数
    private List<T> Row; //当前页数据
    private int pageIndex = 1; //当前页;
    private int pageSize;  //总页数
    private int pagemun = 5;//每页显示的数据条数

    public PageBean() {
    }

    public PageBean(long total, List<T> row, int pageIndex, int pageSize, int pagemun) {
        this.total = total;
        Row = row;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pagemun = pagemun;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRow() {
        return Row;
    }

    public void setRow(List<T> row) {
        Row = row;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPagemun() {
        return pagemun;
    }

    public void setPagemun(int pagemun) {
        this.pagemun = pagemun;
    }
}
