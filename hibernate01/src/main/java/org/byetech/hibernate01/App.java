package org.byetech.hibernate01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);


        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        Student s1 = new Student();
        s1.setStudent_id(101);
        s1.setName("ADITYA");
        s1.setMarks(74.63);
        s1.setPin(4004);

        Transaction tx = session.beginTransaction();

        session.save(s1);

        tx.commit();
    }
}