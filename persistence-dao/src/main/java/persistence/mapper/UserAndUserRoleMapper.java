package persistence.mapper;

import domain.Roles;
import domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAndUserRoleMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        //TODO : second variant use user.setRole(Roles.valueOf(rs.getString("roles")));
        user.setRole(Roles.valueOf(rs.getString("roles")));
        //user.setRole(rs.getObject("roles",Roles.class));
        return user;
    }
}
