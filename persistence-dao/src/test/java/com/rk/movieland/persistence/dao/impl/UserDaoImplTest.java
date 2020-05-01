package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.User;
import com.rk.movieland.persistence.dao.ApplicationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.rk.movieland.persistence.dao.UserDao;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class UserDaoImplTest {

    @Autowired
    private UserDao userDao;
    private User expectedUser;

    @BeforeEach
    public void createUser(){
        expectedUser = new User();
        expectedUser.setUserId(1);
        expectedUser.setUserName("Рональд Рейнольдс");
        expectedUser.setEmail("ronald.reynolds66@example.com");
        expectedUser.setPassword("paco");
    }

    @Test
    void shouldReturnListAllUser() {
        List<User> users = userDao.findAllUser();
        assertEquals(users.size(), 10);
    }

    @Test
    void shouldReturnUser_Email() {
        User userFromDB = userDao.findUserByEmail("ronald.reynolds66@example.com");
        assertEquals(expectedUser,userFromDB);
    }
    @Test
    void shouldReturnNull_IncorrectEmail() {
        User userFromDB = userDao.findUserByEmail("ronald.reynolds66@example");
        assertNull(userFromDB);
    }

    @Test
    void shouldReturnUser_UserId() {
        User userFromDB = userDao.findUserByUserId(1);
        assertEquals(expectedUser,userFromDB);
    }

    @Test
    void shouldReturnNull_IncorrectUserId() {
        User userFromDB = userDao.findUserByUserId(100);
        assertNull(userFromDB);
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> userDao.save(new User()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> userDao.update(new User()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> userDao.delete(new User()),
                "Delete not supported yet.");
    }
}