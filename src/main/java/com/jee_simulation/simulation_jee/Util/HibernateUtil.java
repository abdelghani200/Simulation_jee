package com.jee_simulation.simulation_jee.Util;

import com.jee_simulation.simulation_jee.Dto.Client;
import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Dto.Employe;
import com.jee_simulation.simulation_jee.Dto.Personne;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            // Configure Hibernate properties
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/EazyBank");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "youcode2023");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty("hibernate.show_sql", "true");

            // Add annotated classes
            configuration.addAnnotatedClass(Personne.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Employe.class);
            configuration.addAnnotatedClass(Credit.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
