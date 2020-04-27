package com.rk.movieland.persistence.dao;

import com.rk.movieland.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> findAllUser();

    User findUserByEmail(String mail);

    User findUserByUserId(int user_id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
