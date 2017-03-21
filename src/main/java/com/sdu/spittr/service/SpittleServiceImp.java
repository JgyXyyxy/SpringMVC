package com.sdu.spittr.service;

import com.sdu.spittr.bean.Spitter;
import com.sdu.spittr.bean.Spittle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by J on 2017/1/10.
 */

@Service("spittleService")
public class SpittleServiceImp implements SpittleService {

    private static final String SELECT_SPITTLE =
            "select sp.id, s.id as spitterId, s.username, s.password, s.firstName,s.lastName, s.email, sp.message, sp.postedTime " +
                    "from Spittle sp, Spitter s where sp.spitter = s.id";
    private static final String SELECT_SPITTLE_BY_ID = SELECT_SPITTLE + " and sp.id=?";
    private static final String SELECT_SPITTLES_BY_SPITTER_ID = SELECT_SPITTLE + " and s.id=? order by sp.postedTime desc";
    private static final String SELECT_RECENT_SPITTLES = SELECT_SPITTLE + " order by sp.postedTime desc limit ?";

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbc;

    public SpittleServiceImp() {
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(20);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return jdbc.query(SELECT_RECENT_SPITTLES, new SpittleRowMapper(),new Object[]{count});
    }

    @Override
    public Spittle findOne(long spittleId) {
        return jdbc.queryForObject(SELECT_SPITTLE_BY_ID, new SpittleRowMapper(), new Object[]{spittleId});
    }

    @Override
    public Spittle save(Spittle spittle) {
        Long id = spittle.getId();
        String message = spittle.getMessage();
        Date time = spittle.getTime();
        Spitter spitter = spittle.getSpitter();
        Object[] objects = {id, message, time, spitter};
        String sql = "insert into Spittle values(?,?,?,?)";
        jdbc.update(sql,objects);
        return spittle;
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {

        return jdbc.query(SELECT_SPITTLES_BY_SPITTER_ID, new SpittleRowMapper(), new Object[]{spitterId});
    }


    @Override
    public void delete(long id) {
        jdbc.update("delete from Spittle where id=?", id);

    }

    public class SpittleRowMapper implements RowMapper<Spittle>{

        @Override
        public Spittle mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String message = resultSet.getString("message");
            Date postedTime = resultSet.getTimestamp("postedTime");
            long spitterId = resultSet.getLong("spitterId");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String email = resultSet.getString("email");
            Spitter spitter = new Spitter(spitterId, username, password, firstName,lastName, email);
            return new Spittle(id, message, postedTime,spitter);
        }
    }


}
