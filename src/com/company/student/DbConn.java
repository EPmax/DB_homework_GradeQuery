package com.company.student;


import com.company.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DbConn {
    JdbcTemplate template;
    DbConn() {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    Object[][] getDate(String num){

        String sql ="select c.cno,c.cname,sc.grade from s join sc on s.sno =sc.sno  join c on sc.cno =c.cno where s.sno= ? ;";
        List<Student> list= template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),num);
        System.out.println(list);
        Object[][] data=new Object[list.size()][3];
        for (int i=0;i<list.size();i++){
            data[i][0]=list.get(i).getCno();
            data[i][1]=list.get(i).getCname();
            data[i][2]=list.get(i).getGrade();
        }
        return  data;
    }

    String getname(String num){
        String sql="select sname from s where sno = ? ;";
        String name =template.queryForObject(sql,String.class,num);
        System.out.println(name);
        return name;
    }
}