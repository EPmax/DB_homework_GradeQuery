package com.example.library_System.service;

import com.example.library_System.dao.readerDao;
import com.example.library_System.domain.pageBean;
import com.example.library_System.domain.reader;

import java.util.List;

public class readerService {

    private readerDao dao=new readerDao();

    public List<reader> findall(){

        return dao.findAll();

    }

    public void delReader(int id){
        dao.deleteReader(id);
    }


    public pageBean<reader> findReaderByPage(String activePage,String rows){

        int aP=Integer.parseInt(activePage);

        int r=Integer.parseInt(rows);

        pageBean<reader> pageBean = new pageBean<>();

        pageBean.setActivePage(aP);

        pageBean.setRows(r);

        int totalCount=dao.findTotalCount();

        pageBean.setTotalCount(totalCount);

        int start=(aP-1)*r;

        List<reader> list=dao.findByPage(start,r);

        pageBean.setList(list);

        int totalPage=(totalCount% r) ==0 ? (totalCount/r):(totalCount/r+1);

        pageBean.setTotalPage(totalPage);

        return pageBean;

    }

}
