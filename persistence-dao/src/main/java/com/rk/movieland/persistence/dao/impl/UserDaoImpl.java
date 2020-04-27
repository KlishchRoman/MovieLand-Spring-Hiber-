package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.User;
import com.rk.movieland.persistence.dao.UserDao;
import com.rk.movieland.persistence.mapper.UserAndUserRoleMapper;
import com.rk.movieland.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final static UserMapper userMapper = new UserMapper();
    private final static UserAndUserRoleMapper roleMapper = new UserAndUserRoleMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllUser}")
    private String findAllUser;

    @Value("${findUserByEmail}")
    private String findUserByEmail;

    @Value("${findUserByUserId}")
    private String findUserByUserId;

    @Override
    public List<User> findAllUser() {
        return jdbcTemplate.query(findAllUser, userMapper);
    }

    @Override
    public User findUserByEmail(String mail) {
        try {
            SqlParameterSource source = new MapSqlParameterSource("email", mail);
            return parameterJdbcTemplate.queryForObject(findUserByEmail, source, roleMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findUserByUserId(int user_id) {
        try {
            SqlParameterSource source = new MapSqlParameterSource("user_id", user_id);
            return parameterJdbcTemplate.queryForObject(findUserByUserId, source, roleMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setParameterJdbcTemplate(NamedParameterJdbcTemplate parameterJdbcTemplate) {
        this.parameterJdbcTemplate = parameterJdbcTemplate;
    }
}
