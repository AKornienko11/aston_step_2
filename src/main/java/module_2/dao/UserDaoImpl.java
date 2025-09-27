package module_2.dao;


import module_2.HibernateConfiguration;
import module_2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
    SessionFactory sf = hibernateConfiguration.sessionFactory();

    public UserDaoImpl() {
    }

    @Override
    public void create(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.persist(user);
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
            rsl = session.createQuery("Select s FROM User s WHERE s.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            /* или так */
//            rsl = session.get(User.class, id);

            session.beginTransaction().commit();
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
                            "UPDATE User s SET name.s = :name, s.email = email, s.age = Age"
                                    + " WHERE s.id = id")
                    .setParameter("name", user.getName())
                    .setParameter("email", user.getEmail())
                    .setParameter("age", user.getAge())
                    .setParameter("id", user.getId());
            rsl = query.executeUpdate() > 0;

            /* Так тоже работает */

//            User updateUser = session.get(User.class, user.getId());
//            updateUser.setName(user.getName());
//            updateUser.setEmail(user.getEmail());
//            updateUser.setAge(user.getAge());
//            rsl = true;

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
                            "Delete from User s where s.id = id")
                    .setParameter("id", id);
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

