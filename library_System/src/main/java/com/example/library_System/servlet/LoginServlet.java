package com.example.library_System.servlet;

import com.example.library_System.dao.readerDao;
import com.example.library_System.domain.reader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                        throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String account_number = request.getParameter("account_number");

        String password = request.getParameter("password");

        String yzm=request.getParameter("yzm");

        HttpSession yzmsession = request.getSession();

        String s= (String) yzmsession.getAttribute("s");

        if(!s.equals(yzm)){

            request.setAttribute("yzm_error","验证码错误");

            request.getRequestDispatcher("login.jsp").forward(request,response);

            return;

        }

        reader loginreader = new reader();

        loginreader.setAccount_number(account_number);

        loginreader.setPassword(password);

        readerDao dao=new readerDao();

        reader reader1 = dao.login(loginreader);

        if(reader1==null){
            //登录失败
            request.setAttribute("error","email或password错误");

            request.getRequestDispatcher("login.jsp").forward(request,response);

            return;

        }

            if(reader1!=null){

                HttpSession Session = request.getSession();


                Session.setAttribute("reader",reader1);

                if(reader1.getAdmin()==1){

                    Session.setAttribute("admin","admin");

                }

                response.sendRedirect(request.getContextPath()+"/index.jsp");

            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);

    }
}
