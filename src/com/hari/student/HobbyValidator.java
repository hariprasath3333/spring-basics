package com.hari.student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
	private String listOfValidHobbies; 
	public void initialize(IsValidHobby IsValidHobby){
		listOfValidHobbies = IsValidHobby.listOfValidHobbies();
	}
	
	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		if(studentHobby.isEmpty()){
			return false;
		}
		if(studentHobby.matches(listOfValidHobbies)){
			return true;
		}
		return false;
	}
	
}
