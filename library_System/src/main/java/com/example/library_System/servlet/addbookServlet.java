package com.example.library_System.servlet;

import com.example.library_System.domain.book;
import com.example.library_System.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addbookServlet", value = "/addbookServlet")
public class addbookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        book addbook=new book();

        addbook.setB_name( request.getParameter("b_name"));

        addbook.setB_author(request.getParameter("b_author"));

        addbook.setCall_nun(request.getParameter("call_nun"));

        addbook.setClassify(request.getParameter("classify"));

        addbook.setPress(request.getParameter("press"));

        addbook.setPublication_date(request.getParameter("Publication_date"));

        addbook.setStock(Integer.parseInt(request.getParameter("stock")));

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(System.currentTimeMillis());

        addbook.setTime_to_enter_the_library(formatter.format(date));

        bookService service =new bookService();

        service.addBook(addbook);

        request.getRequestDispatcher("/findReaderByPageServlet?li=3").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
