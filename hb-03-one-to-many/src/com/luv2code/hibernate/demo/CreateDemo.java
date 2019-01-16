package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Instructor instructor = createNewInstructor(session);
		Course course1 = createNewCourse(session, "How To Get Rich");
		Course course2 = createNewCourse(session, "Classic Guitar");
		Course course3 = createNewCourse(session, "Advanced Java 11");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
		
		session.getTransaction().commit();
	}

	private static Instructor createNewInstructor(Session session) {
		Instructor instructor = new Instructor("André", "Marcondes Teixeira", "andremarcondesteixeira@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/channel/UCxv6KfTgYsKsnR3tZbG9LkQ", "Trecking");
		instructor.setDetail(instructorDetail);
		session.save(instructor);
		
		return instructor;
	}

	private static Course createNewCourse(Session session, String courseTitle) {
		Course course = new Course(courseTitle);
		session.save(course);
		return course;
	}
}
