package com.example.library_System.servlet;

import com.example.library_System.domain.pageBean;
import com.example.library_System.domain.reader;
import com.example.library_System.service.readerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findReaderByPageServlet", value = "/findReaderByPageServlet")
public class findReaderByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        readerService  service=new readerService();

        pageBean<reader> pageBean=service.findReaderByPage(activePage,rows);

        request .setAttribute("pB",pageBean);

        request.getRequestDispatcher("/findBookByPageServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
