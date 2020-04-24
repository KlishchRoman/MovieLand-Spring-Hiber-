package persistence.impl;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import persistence.dao.UserDao;
import persistence.mapper.UserAndUserRoleMapper;
import persistence.mapper.UserMapper;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final static UserMapper userMapper = new UserMapper();
    private final static UserAndUserRoleMapper roleMapper = new UserAndUserRoleMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllUser}")
    private String findAllUser;

    @Value("${findUserByEmil}")
    private String findUserByEmil;

    @Value("${findUserByUserId}")
    private String findUserByUserId;

    @Override
    public List<User> findAllUser() {
        List<User> users = jdbcTemplate.query(findAllUser,userMapper);
        return users;
    }

    @Override
    public User findUserByEmil(String mail) {
        SqlParameterSource source = new MapSqlParameterSource("email", mail);
        User user = parameterJdbcTemplate.queryForObject(findUserByEmil,source,roleMapper);
        return user;
    }

    @Override
    public User findUserByUserId(int user_id) {
        SqlParameterSource source = new MapSqlParameterSource("user_id", user_id);
        User user = parameterJdbcTemplate.queryForObject(findUserByUserId,source,roleMapper);
        return user;
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
