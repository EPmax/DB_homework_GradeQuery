package com.example.library_System.servlet;

import com.example.library_System.domain.borrowHistory;
import com.example.library_System.domain.pageBean;
import com.example.library_System.domain.reader;
import com.example.library_System.service.historyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "readerFindHostoryByPageServlet", value = "/readerFindHostoryByPageServlet")
public class readerFindHostoryByPageServlet extends HttpServlet {
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
            rows="20";
        }

        pageBean<borrowHistory> pageBean;

        historyService service=new historyService();

        reader reader= (reader) request.getSession().getAttribute("reader");

        pageBean=service.readerfindborrowHistoryByPage(activePage,rows,reader.getR_id());

        request.getSession().setAttribute("rbh",pageBean);

        response.sendRedirect("reader.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
