package com.example.library_System.service;

import com.example.library_System.dao.bookDao;
import com.example.library_System.domain.book;
import com.example.library_System.domain.pageBean;

import java.util.List;

public class bookService {

    private bookDao dao=new bookDao();

    public pageBean<book> findBookByPage(String activePage, String rows){

        int aP=Integer.parseInt(activePage);

        int r=Integer.parseInt(rows);

        pageBean<book> pageBean = new pageBean<>();

        pageBean.setActivePage(aP);

        pageBean.setRows(r);

        int totalCount=dao.findTotalCount();

        pageBean.setTotalCount(totalCount);

        int start=(aP-1)*r;

        List<book> list=dao.findByPage(start,r);

        pageBean.setList(list);

        int totalPage=(totalCount% r) ==0 ? (totalCount/r):(totalCount/r+1);

        pageBean.setTotalPage(totalPage);

        return pageBean;

    }

    public void delBook(int id) {

        dao.deleteBook(id);
    }

    public void addBook(book book){
        dao.addbook(book);
    }

    public  List<book> searchBook(String info){

        List<book> books;

        bookDao dao=new bookDao();

        books=dao.searchByBookName(info);



        if(dao.searchByBookAuthor(info)!=null){

            books.addAll(dao.searchByBookAuthor(info));

        }

        if(dao.searchByBookNum(info)!=null){

            books.addAll(dao.searchByBookNum(info));

        }

        if (dao.searchByBookClassify(info)!=null){

            books.addAll(dao.searchByBookClassify(info));

        }

        return books;
    }


}
