package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		try {
			var mapper = new ObjectMapper();
			var student = mapper.readValue(new File("data/sample.json"), Student.class);
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}