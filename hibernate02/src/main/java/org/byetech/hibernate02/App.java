package org.byetech.hibernate02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {

		StudentName sname = new StudentName();
		sname.setFname("Rohan");
		sname.setLname("Danane");
		
		
		Student s1 = new Student();
		s1.setStudent_id(104);
		s1.setName(sname);
		s1.setMarks(80.32);
		s1.setPin(8177);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(s1);

//		s1 = (Student) session.get(Student.class, 102);

		tx.commit();

		System.out.println(s1);
	}
}
