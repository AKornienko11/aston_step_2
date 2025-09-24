package modul_2.dao;


import modul_2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.config.xml").build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public UserDaoImpl() {
    }

    @Override
    public void create(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Ошибка при создании пользователя.", e);
        } finally {
            session.close();
        }
    }

    @Override
    public User findById(Long id) {
        User rsl = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery("FROM User WHERE id = :fId", User.class)
                    .setParameter("fId", id)
                    .getSingleResult();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

//    @Override
//    public void update(User user) {
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.update(user);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException("Ошибка при обновлении пользователя.", e);
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            User user = session.load(User.class, id);
//            session.delete(user);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw new RuntimeException("Ошибка при удалении пользователя.", e);
//        }
//    }
//
//    @Override
//    public List<User> findAll() {
//        return session.createQuery("FROM User", User.class).list();
//    }
}
