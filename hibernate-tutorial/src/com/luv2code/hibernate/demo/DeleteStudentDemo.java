package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//session.delete(retrieved);
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
