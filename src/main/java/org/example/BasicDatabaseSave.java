package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BasicDatabaseSave {
    public static void main(String[] args) {

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        //employee.setId(1); //ponieważ increment
        employee.setName("Adam");
        employee.setSurname("Kowalski");
        employee.setjobTitle("Programmer");
        employee.setSalary(10000);

        session.save(employee);
        transaction.commit();

        System.out.println("Employee saved!");
        sessionFactory.close();
        session.close();

    }
}
