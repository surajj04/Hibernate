package org.byetech.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * 
 *
 */
public class App {
	public static void main(String[] args) {

		Student s = new Student();
		s.setId(22);
		s.setMarks(78);
		s.setName("Student 22");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

//		Student s = em.find(Student.class, 6);
//		System.out.println(s);

//		When you want to change the data in database we use Transaction to manage asset Properties
//		before saving we have to start the transaction and after save we need to commit the transaction
    	
    	em.getTransaction().begin();
    	em.persist(s);
    	em.getTransaction().commit();
    	System.out.println(s);

	}
}
