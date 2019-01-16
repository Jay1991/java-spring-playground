package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int studentId = 1;
			
			System.out.println("getting student with id: " + studentId);
			Student retrieved = session.get(Student.class, studentId);
			
			System.out.println("student retrieved: " + retrieved);
			
			retrieved.setEmail("bob_loblaw@lawblog.com");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("update email of all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
