package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimayKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 new Student objects");
			Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student student2 = new Student("Mary", "Public", "marypublic@gmail.com");
			Student student3 = new Student("Bonita", "Applebum", "bonitaapplebum@gmail.com");
			
			System.out.println("starting transaction");
			session.beginTransaction();
			
			System.out.println("saving the Student objects");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
