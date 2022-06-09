package com.example.library_System.servlet;

import com.example.library_System.domain.book;
import com.example.library_System.domain.pageBean;
import com.example.library_System.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findBookByPageServlet", value = "/findBookByPageServlet")
public class findBookByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String activePage=request.getParameter("activePage");

        String rows=request.getParameter("rows");

        String li=request.getParameter("li");

        if(li==null||"".equals(li)){
            li="1";
        }

        request.getSession().setAttribute("li",li);

        if(activePage==null||"".equals(activePage)){
            activePage="1";
        }

        if(rows==null||"".equals(rows)){
            rows="5";
        }

        bookService service=new bookService();

        pageBean<book> pageBean=service.findBookByPage(activePage,rows);

        request.getSession().setAttribute("pBb",pageBean);

        request.getRequestDispatcher("/findBorrowHistoryServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
