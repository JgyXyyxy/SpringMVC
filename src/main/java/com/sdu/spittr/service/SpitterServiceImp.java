package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by J on 2017/1/11.
 */

@Service("spitterService")
public class SpitterServiceImp implements SpitterService {

    private static final String SELECT_SPITTER = "select id, username, password, firstName,lastName, email from spitter";

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbc;

    public SpitterServiceImp() {
    }

    @Override
    public long count() {
        return jdbc.queryForObject("select count(id) from Spitter",Long.class);
    }

    @Override
    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null){
            String username = spitter.getUsername();
            String password = spitter.getPassword();
            String firstName = spitter.getFirstName();
            String lastName = spitter.getLastName();
            String email = spitter.getEmail();
            Object[] objects = {username, password,firstName,lastName ,email};
            String sql = "insert into spitter (username, password,firstName,lastName ,email)values(?,?,?,?,?)";
            jdbc.update(sql,objects);
        }
        else{
            jdbc.update("update spitter set username=?, password=?, firstName=?,lastName=? email=? where id=?",
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFirstName(),
                    spitter.getLastName(),
                    spitter.getEmail(),
                    id);
        }
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbc.queryForObject(SELECT_SPITTER+"where id = ?",new SpitterRowMapper(),new Object[]{id});
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbc.queryForObject(SELECT_SPITTER+" where username = ?",new SpitterRowMapper(),new Object[]{username});
    }

    @Override
    public List<Spitter> findAll() {
        return jdbc.query("select * from Spitter ",new SpitterRowMapper());
    }

    public class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            return new Spitter(id, username, password, firstName,lastName, email);
        }
    }
}
