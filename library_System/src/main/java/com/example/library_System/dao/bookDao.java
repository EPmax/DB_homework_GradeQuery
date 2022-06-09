package com.example.library_System.dao;

import com.example.library_System.domain.book;
import com.example.library_System.domain.reader;
import com.example.library_System.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class bookDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());


    public List<book> findByPage(int start, int r) {

        try {
            String sql = "select * from  book limit ? , ?";

            return template.query(sql,new BeanPropertyRowMapper<book>(book.class),start,r);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int findTotalCount() {

        String sql="select count(*) from book";

        return template.queryForObject(sql,Integer.class);
    }

    public void  deleteBook(int id){

        try {
            String sql="delete from book where b_id= ?";

            template.update(sql,id);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void addbook(book book){
        try {
            String sql="insert into book(b_name,b_author,call_nun,classify,Time_to_enter_the_library,press,Publication_date,stock)" +
                    " values(?,?,?,?,?,?,?,?)";
            template.update(sql,book.getB_name(),book.getB_author(),book.getCall_nun(),
                    book.getClassify(), book.getTime_to_enter_the_library(),book.getPress(),book.getPublication_date(),book.getStock());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }


    public List<book> searchByBookName(String info){
        try {
            String sql = "select * from  book where b_name=?";

            return template.query(sql,new BeanPropertyRowMapper<book>(book.class),info);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public List<book> searchByBookAuthor(String info){
        try {
            String sql = "select * from  book where b_author=?";

            return template.query(sql,new BeanPropertyRowMapper<book>(book.class),info);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public List<book> searchByBookClassify(String info){
        try {
            String sql = "select * from  book where classify=?";

            return template.query(sql,new BeanPropertyRowMapper<book>(book.class),info);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public List<book> searchByBookNum(String info){
        try {
            String sql = "select * from  book where call_nun=?";

            return template.query(sql,new BeanPropertyRowMapper<book>(book.class),info);
        } catch (DataAccessException e) {
            return null;
        }
    }

}
