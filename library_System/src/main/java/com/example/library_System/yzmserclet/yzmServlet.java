package com.example.library_System.yzmserclet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "yzmServlet", value = "/yzmServlet")
public class yzmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");//jpeg是图片格式。设置响应内容的类型为jpeg的图片

        int width=64;

        int height=40;

        BufferedImage bImg=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g=bImg.getGraphics();

//背景

        g.setColor(Color.white);

        g.fillRect(0, 0, width, height);

//字体颜色

        g.setFont(new Font("aa", Font.BOLD,18));

//用随机数生成验证码:4个0~9以内的整数

        Random r=new Random();

        String s="";
        for(int i=0;i<4;i++){

            int t=r.nextInt(10);//10以内的随机整数

            s=s+String.valueOf(t);

            int y=10+r.nextInt(20);//上下位置:10~30

            Color c=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

            g.setColor(c);

            g.drawString(""+t, i*16, y);

        }

        request.getSession().setAttribute("s",s);
//画干扰线

        for(int i=1;i<8;i++){

            Color c=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

            g.setColor(c);

            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));

        }
        //把图形刷到bImg对象中

        g.dispose();//相当于IO中的close()方法带自动flush();
        ImageIO.write(bImg,"JPEG", response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
