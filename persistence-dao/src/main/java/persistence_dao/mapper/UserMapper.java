package persistence_dao.mapper;

import domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
         User user = new User();
         user.setUserId(rs.getInt("user_id"));
         user.setUserName(rs.getString("user_name"));
         user.setEmail(rs.getString("email"));
         user.setPassword(rs.getString("password"));
        return user;
    }
}