package module_2.service;

import module_2.dao.UserDao;
import module_2.dao.UserDaoImpl;
import module_2.entity.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public void addUser(User user) {
        userDao.create(user);
    }

    public User getUserById(int id) {
        return userDao.findById(id);
    }

    public boolean editUser(User updatedUser) {
        return userDao.update(updatedUser);

    }

    public void removeUser(int id) {
        userDao.delete(id);
    }

    public List<User> listUsers() {
        return userDao.findAll();
    }
}

