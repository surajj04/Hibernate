package org.byetech.HibernateQueryLanguage;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();

//		for list of data you can use the q.list()
		/*
		 * Query q = session.createQuery("from Student where marks < 90"); List<Student>
		 * students = q.list();
		 * 
		 * for(Student st : students) { System.out.println(st); }
		 */

//		using uniqureResult()  you can featch the single row or data 
		Query q = session.createQuery("from Student where id = 04");
		Student s = (Student) q.uniqueResult();
		System.out.println(s);

		Query q1 = session.createQuery("select sum(marks) from Student");
		Long total = (Long) q1.uniqueResult();
		System.out.println(total);

//		if you want to work like a preparedstatement you can use :varname using this syntax in query
		int id = 14;

		Query q2 = session.createQuery("from Student where id = :id");
		q2.setParameter("id", id);
		s = (Student) q2.uniqueResult();
		System.out.println(s);

//		if you want to use sql in hibernate we have to create the object of SQLQuery
//		this is als known as a Native query
		
		SQLQuery query = session.createSQLQuery("Select * from Student where marks < 40");
		query.addEntity(Student.class);
		List<Student> students = query.list();

		for (Student st : students) {
			System.out.println(st);
		}

		session.getTransaction().commit();

	}
}
