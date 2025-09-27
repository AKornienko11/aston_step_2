package module_2.dao;

import module_2.entity.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User findById(int id);

    boolean update(User user);

    boolean delete(int id);

    List<User> findAll();

}

