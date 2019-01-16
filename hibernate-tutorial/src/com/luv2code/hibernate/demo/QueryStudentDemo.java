package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("starting transaction");
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").list();
			
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Duck'").list();
			
			displayStudents(students);
			
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
			
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
