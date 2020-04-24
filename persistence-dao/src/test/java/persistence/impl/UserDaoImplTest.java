package persistence.impl;

import domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import persistence.ApplicationTest;
import persistence.dao.UserDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class UserDaoImplTest {

    @Autowired
    private UserDao userDao;


    @Test
    void findAllUser() {
        List<User> users = userDao.findAllUser();
        assertEquals(users.size(), 10);
    }

    @Test
    void findUserByEmil() {
        User expectedUser = new User();
        expectedUser.setUserId(1);
        expectedUser.setUserName("Рональд Рейнольдс");
        expectedUser.setEmail("ronald.reynolds66@example.com");
        expectedUser.setPassword("paco");

        User userFromDB = userDao.findUserByEmil("ronald.reynolds66@example.com");

        assertEquals(expectedUser,userFromDB);
    }

    @Test
    void findUserByUserId() {
        User expectedUser = new User();
        expectedUser.setUserId(1);
        expectedUser.setUserName("Рональд Рейнольдс");
        expectedUser.setEmail("ronald.reynolds66@example.com");
        expectedUser.setPassword("paco");

        User userFromDB = userDao.findUserByUserId(1);

        assertEquals(expectedUser,userFromDB);
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