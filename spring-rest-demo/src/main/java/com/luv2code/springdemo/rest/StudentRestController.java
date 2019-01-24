package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
	private List<Student> students;

	@PostConstruct
	public void initialize() {
		var andre = new Student(1, "André", "Marcondes Teixeira");
		var rafael = new Student(2, "Rafael", "Marcondes Teixdeira");
		var rodrigo = new Student(3, "Rodrigo", "Antônio Marcondes Carlins");

		students = new ArrayList<Student>();
		students.add(andre);
		students.add(rafael);
		students.add(rodrigo);
	}

	@GetMapping("/list-all")
	public List<Student> listStudents() {
		return students;
	}

	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) {
		var student = students.stream().filter(s -> s.getId() == id).findFirst();
		
		if (student.isPresent()) {
			return student.get();
		}
		
		throw new StudentNotFoundException();
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		var response = new StudentErrorResponse();
		response.setMessage("student not found");
		response.setStatus(404);
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
