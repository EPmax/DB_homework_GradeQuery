package com.example.library_System.servlet;

import com.example.library_System.service.historyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "comServlet", value = "/comServlet")
public class comServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        historyService service=new historyService();

        service.readerCom(Integer.parseInt(id));

        request.getRequestDispatcher("readerFindHostoryByPageServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
