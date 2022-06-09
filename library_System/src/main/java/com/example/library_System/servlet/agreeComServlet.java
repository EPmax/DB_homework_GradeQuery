package com.example.library_System.servlet;

import com.example.library_System.service.historyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "agreeComServlet", value = "/agreeComServlet")
public class agreeComServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String id=request.getParameter("id");

        String regex="[^0-9]";

        Pattern p=Pattern.compile(regex);

        Matcher matcher=p.matcher(id);

        id= matcher.replaceAll("").trim();

        historyService service=new historyService();

        service.com(Integer.parseInt(id));

        request.getRequestDispatcher("/findReaderByPageServlet?li=4").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    doGet(request,response);
    }
}
