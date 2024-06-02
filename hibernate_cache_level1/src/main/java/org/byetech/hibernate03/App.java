package org.byetech.hibernate03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Student s1 = null;

		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = conf.buildSessionFactory();

//		Session 1
		Session session1 = sf.openSession();
		session1.beginTransaction();

//		 work with query's
		Query q1 = session1.createQuery("From Student where id = 1");
		q1.setCacheable(true);
//		s1 = session1.get(Student.class, 1);
		s1 = (Student) q1.uniqueResult();
		System.out.println(s1);

		session1.getTransaction().commit();
		session1.close();

//		Session 2
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2 = session2.createQuery("From Student where id = 1");
		q2.setCacheable(true);
//		s1 = session2.get(Student.class, 1);
		s1 = (Student) q2.uniqueResult();
		System.out.println(s1);

		session2.getTransaction().commit();
		session2.close();

//		Collection<Laptop> laps = s1.getLaptops();
//
//		for(Laptop l : laps) {
//			System.out.println(l);
//		}

	}
}
