package com.example.library_System.dao;

import com.example.library_System.domain.borrowHistory;
import com.example.library_System.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class historyDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());

    public List<borrowHistory> findByPage(int start, int r){

        String sql = "select bh.b_h_id,r.reader_name,r.account_number,b.b_name,bh.borrow_date,bh.statu from (select \n" +
                "\n" +
                "bh.b_h_id,r.reader_name,r.account_number,b.b_name,bh.borrow_date,bh.r_id,b.b_id,bh.statu from borrowing_history bh \n" +
                "\n" +
                " join reader r on bh.r_id = r.r_id join book b on bh.b_id = b.b_id group by bh.b_h_id limit ? , ?) bh\n" +
                "\n" +
                " join reader r on bh.r_id = r.r_id join book b on bh.b_id = b.b_id\n";

        return template.query(sql,new BeanPropertyRowMapper<borrowHistory>(borrowHistory.class),start,r);
    }


    public List<borrowHistory> readerfindByPage(int start, int r,int id){

        String sql = "select bh.b_h_id,r.reader_name,r.account_number,b.b_name,bh.borrow_date,bh.statu from (select \n" +
                "\n" +
                "bh.b_h_id,r.reader_name,r.account_number,b.b_name,bh.borrow_date,bh.r_id,b.b_id,bh.statu from borrowing_history bh \n" +
                "\n" +
                " join reader r on bh.r_id = r.r_id join book b on bh.b_id = b.b_id group by bh.b_h_id limit ? , ?) bh\n" +
                "\n" +
                " join reader r on bh.r_id = r.r_id join book b on bh.b_id = b.b_id\n where bh.r_id= ? ";

        return template.query(sql,new BeanPropertyRowMapper<borrowHistory>(borrowHistory.class),start,r,id);
    }


    public int findTotalCount(){

        String sql="select count(*) from borrowing_history";

        return template.queryForObject(sql,Integer.class);

    }

    public int readerfindTotalCount(int id){

        String sql="select count(*)  from borrowing_history bh \n" +
                "\n" +
                " join reader r on bh.r_id = r.r_id join book b on bh.b_id = b.b_id where bh.r_id= ? ;";

        return template.queryForObject(sql,Integer.class,id);

    }


    public void  agreeBorrowDao(int id){

        String sql="update borrowing_history set statu=0 where b_h_id=? ";

        String sql1="update book set stock=stock+1  where b_id =(select b_id from borrowing_history where b_h_id=?)";

        template.update(sql,id);

        template.update(sql1,id);
    }

    public void agreeComDao(int id){

        String sql="update borrowing_history set statu=3 where b_h_id=? ";

        String sql1="update book set stock=stock+1  where b_id =(select b_id from borrowing_history where b_h_id=?)";

        template.update(sql,id);

        template.update(sql1,id);

    }


    public void readerComDao(int id){

        String sql="update borrowing_history set statu=1 where b_h_id=? ";

        template.update(sql,id);
    }

    public void  borrowDao(int r_id,int b_id,String date){

        String sql="insert  into borrowing_history(r_id,b_id,borrow_date,statu) values(?, ? , ? ,2)";

        template.update(sql,r_id,b_id,date);

    }

}
