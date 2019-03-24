package com.hari.student;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	String listOfValidHobbies() default "Swimming|swimming";
	String message() default "Please provide a valid hobby:  " +  
	"accepted hobbies are: - music, swimming{choose anyone}.";
	Class<?>[]  groups() default {};
	Class<? extends Payload>[]  payload() default {};

}
