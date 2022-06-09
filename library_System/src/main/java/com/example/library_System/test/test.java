package com.example.library_System.test;

import com.example.library_System.dao.readerDao;
import com.example.library_System.domain.book;
import com.example.library_System.domain.pageBean;
import com.example.library_System.domain.reader;
import com.example.library_System.service.bookService;
import com.example.library_System.service.historyService;
import com.example.library_System.service.readerService;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void testlogin(){
        reader reader=new reader();
        reader.setAccount_number("123@qq.com");
        reader.setPassword("116");
        readerDao dao=new readerDao();
        reader reader1=dao.login(reader);
        System.out.println(reader1);
    }
    @Test
    public void findbook(){
        bookService service=new bookService();

        pageBean<book> pageBean=service.findBookByPage("1","5");

        System.out.println(pageBean.getList());

    }


    @Test
    public void addbook(){
        bookService service=new bookService();

        book book=new book();

        book.setTime_to_enter_the_library("2020-6-8");

        book.setPress("a");

        book.setB_author("a");

        book.setPublication_date("2020-8-9");

        book.setCall_nun("12.1");

        book.setB_name("da");

        book.setClassify("aaasd");

        service.addBook(book);
    }


    @Test
public void readerfindhistroy(){
    historyService service=new historyService();

    pageBean  pageBean=service.readerfindborrowHistoryByPage("1","5",22);

    System.out.println(pageBean.getList());

}


@Test
public void search(){

    bookService service=new bookService();

    List<book> list =service.searchBook("斗罗大陆");

    System.out.println(list);
}


@Test
public void borrow(){

        historyService service=new historyService();

        service.borrow(22,17);
}

}
