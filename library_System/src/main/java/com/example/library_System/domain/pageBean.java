package com.example.library_System.domain;

import java.util.List;

public class pageBean<T> {



    private int totalCount;//总记录数

    private int totalPage;//总页码

    private List<T> list;//每页数据

    private int activePage;//当前页码

    private int rows;//每页的显示的记录数


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getActivePage() {
        return activePage;
    }

    public void setActivePage(int activePage) {
        this.activePage = activePage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


    @Override
    public String toString() {
        return "pageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", activePage=" + activePage +
                ", rows=" + rows +
                '}';
    }
}
