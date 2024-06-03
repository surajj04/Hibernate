package org.byetech.hibernate_object_state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Student s = new Student();
		
		s.setId(20);
		s.setMarks(90);
		s.setName("Student 20");
		
		session.save(s);
		
//		session.remove(s);
		

		session.getTransaction().commit();
		session.detach(s);
		s.setMarks(99);
	}
}
