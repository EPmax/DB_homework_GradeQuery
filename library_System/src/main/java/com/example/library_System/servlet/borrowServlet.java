package com.example.library_System.servlet;

import com.example.library_System.domain.reader;
import com.example.library_System.service.historyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "borrowServlet", value = "/borrowServlet")
public class borrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String b_id=request.getParameter("id");

            HttpSession session=request.getSession();

        reader reader= (reader) session.getAttribute("reader");

        String r_id= String.valueOf(reader.getR_id());

        historyService service=new historyService();

        service.borrow(Integer.parseInt(r_id),Integer.parseInt(b_id));

        request.getRequestDispatcher("search.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
