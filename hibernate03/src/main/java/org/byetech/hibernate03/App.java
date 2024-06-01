package org.byetech.hibernate03;

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

		Laptop laptop = new Laptop();

		laptop.setLid(101);
		laptop.setLname("Hp");

		Student s = new Student();
		s.setId(11001);
		s.setName("SURAJ");
		s.setMarks(77.34);
		s.getLaptops().add(laptop);

		laptop.getStudent().add(s);

		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(laptop);
		session.save(s);

		tx.commit();

	}
}
