package com.example.library_System.servlet;

import com.example.library_System.domain.book;
import com.example.library_System.domain.borrowHistory;
import com.example.library_System.domain.pageBean;
import com.example.library_System.service.bookService;
import com.example.library_System.service.historyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findBorrowHistoryServlet", value = "/findBorrowHistoryServlet")
public class findBorrowHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String activePage=request.getParameter("activePage2");

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

        historyService service=new historyService();

        pageBean<borrowHistory> pageBean=service.findborrowHistoryByPage(activePage,rows);

        request.getSession().setAttribute("bh",pageBean);

        request.getRequestDispatcher("admin.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
