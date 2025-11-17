package com.bank.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bank.model.*;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

      static
      {
        try {
            // Create configuration instance
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Register annotated entity classes
            configuration.addAnnotatedClass(Bank.class);
            configuration.addAnnotatedClass(Branch.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Loan.class);
            configuration.addAnnotatedClass(Transaction.class);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(Card.class);

            // Build service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Build session factory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Hibernate SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
