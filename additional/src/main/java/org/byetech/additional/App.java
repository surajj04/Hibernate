package org.byetech.additional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Get v/s Load methods in Hibernate
 * These two methods perform similar operations.
 * Their performance perspective are differnt.
 * 
 * get --> Executes a query each time to fetch data from the database. It provides you an object.
 * load --> It will not execute the query until you use that object. It provides you a proxy object.
 */

public class App {
	public static void main(String[] args) throws InterruptedException {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Student s = session.get(Student.class, 600);
//		Thread.sleep(3000);
		System.out.println(s);
		
		s = session.load(Student.class, 6000);
		Thread.sleep(3000);
		System.out.println(s );
			
		session.getTransaction().commit();
	}
}
