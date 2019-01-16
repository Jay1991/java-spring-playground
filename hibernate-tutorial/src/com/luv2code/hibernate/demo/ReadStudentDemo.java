package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object");
			Student student = new Student("Daffy", "Duck", "daffyduck@gmail.com");
			
			System.out.println("starting transaction");
			session.beginTransaction();
			
			System.out.println("saving the Student object");
			session.save(student);
			
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
			
			System.out.println("saved Student object's id: " + student.getId());
			
			System.out.println("renewing session");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("getting student with id: " + student.getId());
			Student retrieved = session.get(Student.class, student.getId());
			
			System.out.println("student retrieved: " + retrieved);
			
			session.getTransaction().commit();
			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
