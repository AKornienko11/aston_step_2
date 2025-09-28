package module_2.dao;

import module_2.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    private UserDaoImpl service;


    @BeforeEach
    void setup() {
        service = new UserDaoImpl();
    }

    @AfterEach
    void cleanup() {
        List<User> users = service.findAll();
        for (User u : users) {
            service.delete(u.getId());
        }
    }

    @Test
    void whenCreateAndFindById() {
        User user = new User("Fyodor_Konyukhov", "fedor@mail.ru", 60);
        service.create(user);
        assertNotNull(user.getId()); // После сохранения объект получает ID

        User foundUser = service.findById(user.getId());
        assertEquals(foundUser.getName(), "Fyodor_Konyukhov");
        assertEquals(foundUser.getEmail(), "fedor@mail.ru");
    }

    @Test
    void whenUpdate() {
        User user = new User("Nikolai Drozdov", "Nikolai_Drozdov@yandex.ru", 88);
        service.create(user);

        user.setName("Nikolai Nikolaevich");
        service.update(user);

        User updatedUser = service.findById(user.getId());
        assertEquals(updatedUser.getName(), "Nikolai Nikolaevich");
        assertEquals(updatedUser.getAge(), 88);
    }

    @Test
    void whenDelete() {
        User user = new User("Fyodor_Konyukhov", "fedor@mail.ru", 60);
        service.create(user);

        int id = user.getId();
        service.delete(id);

        User deletedUser = service.findById(id);
        assertNull(deletedUser); // Пользователь удалён
    }

    @Test
    void whenFindAll() {
        User user1 = new User("Fyodor_Konyukhov", "fedor@mail.ru", 60);
        User user2 = new User("Nikolay_Drozdov", "nikolay_drozdov@mail.ru", 88);
        service.create(user1);
        service.create(user2);

        List<User> allUsers = service.findAll();
        assertEquals(allUsers.size(), 2);
    }
}