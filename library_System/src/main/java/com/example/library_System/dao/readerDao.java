package com.example.library_System.dao;

import com.example.library_System.domain.reader;
import com.example.library_System.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class readerDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDatasource());
    
    public reader login(reader loginreader){
        try {
            String sql="select * from reader where account_number = ? and password = ?";
            reader reader = template.queryForObject(sql, new
                    BeanPropertyRowMapper<reader>(reader.class),
                    loginreader.getAccount_number(), loginreader.getPassword());
            return reader;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void register(reader register_reader){

        try {
            String sql="insert  into reader(reader_name,account_number,password) values(?, ? , ? )";

            template.update(sql,register_reader.getReader_name(),register_reader.getAccount_number(),register_reader.getPassword());

        } catch (DataAccessException e) {
            
        }

    }


    public List<reader> findAll(){

        try {
            String sql="select * from reader";

            List<reader> readerList=template.query(sql,new BeanPropertyRowMapper<reader>(reader.class));

            return readerList;
        } catch (DataAccessException e) {
        }
        return null;
    }

    public List<reader> findByPage(int start, int r) {

        String sql = "select * from  reader limit ? , ?";

        return template.query(sql,new BeanPropertyRowMapper<reader>(reader.class),start,r);
    }

    public int findTotalCount() {

        String sql="select count(*) from reader";

        return template.queryForObject(sql,Integer.class);
    }


    public void  deleteReader(int id){

        try {
            String sql="delete from reader where r_id= ?";

            template.update(sql,id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
