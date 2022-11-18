package com.bezf.authorizationservice.dao;

import com.bezf.authorizationservice.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;
    private static final String SELECT = "select righttype from users" +
            "inner join usersrights u on users.id = u.userid" +
            "inner join rights r on r.id = u.rightid" +
            "where users.name=? AND users.password=?";

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Authorities> getUserRights(String user, String password) {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Authorities.class), user, password);
    }
}
