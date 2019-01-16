package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object");
			Student student = new Student("André", "Teixeira", "andremarcondesteixeira@gmail.com");
			
			System.out.println("starting transaction");
			session.beginTransaction();
			
			System.out.println("saving the Student object");
			session.save(student);
			
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
