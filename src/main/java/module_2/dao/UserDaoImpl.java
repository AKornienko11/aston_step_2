package module_2.dao;


import module_2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
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
    public User findById(int id) {
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

    @Override
    public boolean update(User user) {
        Session session = sf.openSession();
        boolean rsl = false;
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                            "UPDATE User SET name = :fName, email = :fEmail, age = :fAge"
                                    + " WHERE id = :fId")
                    .setParameter("fName", user.getName())
                    .setParameter("fEmail", user.getEmail())
                    .setParameter("fAge", user.getAge())
                    .setParameter("fId", user.getId());
            rsl = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        boolean rsl = false;
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE User WHERE id = :fId")
                    .setParameter("fId", id);
            rsl = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public List<User> findAll() {
        List<User> rsl = new ArrayList<>();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery("FROM User", User.class).list();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }
}

