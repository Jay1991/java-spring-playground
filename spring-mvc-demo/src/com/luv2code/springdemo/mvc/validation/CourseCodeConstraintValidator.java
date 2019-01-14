package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String> {
	
	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefixes = courseCode.value();
	}

	@Override
	public boolean isValid(
		String courseCode,
		ConstraintValidatorContext context
	) {
		boolean result = false;
		
		if (courseCode == null) {
			return result;
		}
		
		for (String code : coursePrefixes) {
			result = courseCode.startsWith(code);
			
			if (result) {
				break;
			}
		}
		
		return result;
	}

}
