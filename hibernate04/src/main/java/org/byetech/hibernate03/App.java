package org.byetech.hibernate03;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Student s1 = session.get(Student.class, 11001);
		System.out.println(s1);
		
//		Collection<Laptop> laps = s1.getLaptops();
//		
//		for(Laptop l : laps) {
//			System.out.println(l);
//		}

		tx.commit();

	}
}
