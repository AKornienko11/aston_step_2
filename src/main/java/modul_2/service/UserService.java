package modul_2.service;

import modul_2.dao.UserDao;
import modul_2.dao.UserDaoImpl;
import modul_2.entity.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    public void addUser(User user) {
        userDao.create(user);
    }

    public User getUserById(Long id) {
        return userDao.findById(id);
    }

//    public void editUser(User updatedUser) {
//        userDao.update(updatedUser);
//    }
//
//    public void removeUser(Long id) {
//        userDao.delete(id);
//    }
//
//    public List<User> listUsers() {
//        return userDao.findAll();
//    }
//
//    public void close() {
//        sessionFactory.close();
//    }
}
