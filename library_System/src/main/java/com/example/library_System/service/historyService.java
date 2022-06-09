package com.example.library_System.service;

import com.example.library_System.dao.historyDao;
import com.example.library_System.domain.borrowHistory;
import com.example.library_System.domain.pageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class historyService {
    historyDao dao=new historyDao();

    public pageBean<borrowHistory> findborrowHistoryByPage(String activePage, String rows){

        int aP=Integer.parseInt(activePage);

        int r=Integer.parseInt(rows);

        pageBean<borrowHistory> pageBean = new pageBean<>();

        pageBean.setActivePage(aP);

        pageBean.setRows(r);

        int totalCount=dao.findTotalCount();

        pageBean.setTotalCount(totalCount);

        int start=(aP-1)*r;

        List<borrowHistory> list=dao.findByPage(start,r);

        pageBean.setList(list);

        int totalPage=(totalCount% r) ==0 ? (totalCount/r):(totalCount/r+1);

        pageBean.setTotalPage(totalPage);

        return pageBean;

    }


    public pageBean<borrowHistory> readerfindborrowHistoryByPage(String activePage, String rows,int id){

        int aP=Integer.parseInt(activePage);

        int r=Integer.parseInt(rows);

        pageBean<borrowHistory> pageBean = new pageBean<>();

        pageBean.setActivePage(aP);

        pageBean.setRows(r);

        int totalCount=dao.readerfindTotalCount(id);

        pageBean.setTotalCount(totalCount);

        int start=(aP-1)*r;

        List<borrowHistory> list=dao.readerfindByPage(start,r,id);

        pageBean.setList(list);

        int totalPage=(totalCount% r) ==0 ? (totalCount/r):(totalCount/r+1);

        pageBean.setTotalPage(totalPage);

        return pageBean;

    }

    public  void agreeborrow(int id){

        historyDao dao=new historyDao();

        dao.agreeBorrowDao(id);

     }


    public  void com(int id){

        historyDao dao=new historyDao();

        dao.agreeComDao(id);

    }

    public  void readerCom(int id){

        historyDao dao=new historyDao();

        dao.readerComDao(id);

    }

    public  void  borrow(int r_id,int b_di){

        historyDao dao=new historyDao();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(System.currentTimeMillis());

        dao.borrowDao(r_id,b_di,formatter.format(date));
    }
}
