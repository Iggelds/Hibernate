package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("The person was fetched");
            System.out.println(person);
            System.out.println(person.getItems());

//            Item item = session.get(Item.class, 1);
//            System.out.println("The item was fetched");
//            System.out.println(item.getOwner());

            session.getTransaction().commit();

            System.out.println(person.getItems());
        } finally {
            sessionFactory.close();
        }
    }
}