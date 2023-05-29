package org.example.oneToOne;

import org.example.Employee;
import org.example.oneToOne.model.Parcel;
import org.example.oneToOne.model.ParcelAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class ParcelExample {
    public static void main(String[] args) {


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Parcel parcel = new Parcel("Warszawa", 15);
        ParcelAddress parcelAddress = new ParcelAddress("Polska", "Warszawa",
                "Wilcza", "00001");
        parcel.setParcelAddress(parcelAddress);

       //session.save(parcel);

        Query query = session.createQuery("FROM Parcel");
        List<Parcel> parcels = query.list();

        parcels.stream().forEach(p -> System.out.println(p));

        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
