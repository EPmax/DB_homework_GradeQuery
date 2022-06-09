package com.example.library_System.servlet;

import com.example.library_System.dao.readerDao;
import com.example.library_System.domain.reader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String reader_name=request.getParameter("reader_name");

        String account_number = request.getParameter("account_number");

        String password = request.getParameter("password1");

        String password2 = request.getParameter("password2");

        String yzm=request.getParameter("yzm");

        HttpSession yzmsession = request.getSession();

        String s= (String) yzmsession.getAttribute("s");

        if(!s.equals(yzm)){

            request.setAttribute("yzm_error","验证码错误");

            request.getRequestDispatcher("register.jsp").forward(request,response);

            return;

        }

        if (!password.equals(password2)){

            request.setAttribute("error","两次输入不一致");

            request.getRequestDispatcher("register.jsp").forward(request,response);

            return;

        }

        reader register_reader=new reader();

        register_reader.setReader_name(reader_name);

        register_reader.setAccount_number(account_number);

        register_reader.setPassword(password);

        (new readerDao()).register(register_reader);

        register_reader=(new readerDao()).login(register_reader);

        HttpSession Session = request.getSession();

        Session.setAttribute("reader",register_reader);

        if(register_reader.getAdmin()==1){

            Session.setAttribute("admin","admin");

        }

        request.setCharacterEncoding("utf-8");

        response.getWriter().write("<script>alert(\"succeed\") ;" +
                "setTimeout(3000);window.onload=function (){window.location.href=\"index.jsp\"}</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
