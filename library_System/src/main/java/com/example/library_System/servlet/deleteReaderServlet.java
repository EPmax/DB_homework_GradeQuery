package com.example.library_System.servlet;

import com.example.library_System.service.readerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteServlet", value = "/deleteServlet")
public class deleteReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        (new readerService()).delReader(Integer.parseInt(id));

        request.getRequestDispatcher("/findReaderByPageServlet?li=2").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
