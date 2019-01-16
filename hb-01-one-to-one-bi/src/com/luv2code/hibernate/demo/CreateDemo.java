package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		saveNewEntities(session);
		
		session.getTransaction().commit();
	}

	private static void saveNewEntities(Session session) {
		Instructor instructor = new Instructor("Fulano", "da Silva", "fulanodasilva@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube", "nothing");
		instructor.setDetail(instructorDetail);
		session.save(instructor);
	}

}
