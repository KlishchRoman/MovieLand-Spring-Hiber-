package persistence.dao;

import domain.Review;
import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAllUser();

    User findUserByEmil(String mail);

    User findUserByUserId(int user_id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
