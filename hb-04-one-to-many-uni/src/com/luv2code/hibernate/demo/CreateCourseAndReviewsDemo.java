package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();
			createEntities(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}
	}

	private static void createEntities(Session session) {
		Instructor instructor = createNewInstructor(session);
		Course course1 = createNewCourse(session, "How To Get Rich");
		Review review1 = createNewReview(session, "this course is awesome!!!");
		Review review2 = createNewReview(session, "this course sucks!!!");
		Review review3 = createNewReview(session, "this is a course, well... whatever...");
		course1.addReview(review1);
		course1.addReview(review2);
		course1.addReview(review3);
		Course course2 = createNewCourse(session, "Classic Guitar");
		Course course3 = createNewCourse(session, "Advanced Java 11");
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);
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
	
	private static Review createNewReview(Session session, String comment) {
		Review review = new Review(comment);
		session.save(review);
		return review;
	}
}
