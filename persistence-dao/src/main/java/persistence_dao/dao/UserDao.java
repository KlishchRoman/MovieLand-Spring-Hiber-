package persistence_dao.dao;

import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAllUser();
    User findUserByEmil(String mail);
    User findUserByUserId(int user_id);
}
