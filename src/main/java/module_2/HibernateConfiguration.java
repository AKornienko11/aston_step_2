package module_2;

import module_2.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new Configuration();

        configuration
                .addAnnotatedClass(User.class)
                .addPackage("module_2")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Users")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "password")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update");

        return configuration.buildSessionFactory();
    }
}
