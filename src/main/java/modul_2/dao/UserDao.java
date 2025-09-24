package modul_2.dao;

import modul_2.entity.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User findById(Long id);

//    void update(User user);
//
//    void delete(Long id);
//
//    List<User> findAll();
}