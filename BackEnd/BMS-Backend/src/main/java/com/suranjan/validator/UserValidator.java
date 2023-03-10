package com.suranjan.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.suranjan.controller.AdminController;
import com.suranjan.model.Customer;

@ControllerAdvice(assignableTypes = AdminController.class)
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Customer customer = (Customer) target;
		
		if(customer .getCustomerUserName() == null || customer.getCustomerName() .equals("")) {
			errors.rejectValue("customerUserName", "Customer User Name should not be null", "Enter Your User Name");
			return;
		}
		
		if(customer .getCustomerEmail() == "") {
			errors.rejectValue("emailId", "Customer Email Id should not be null", "Enter your Email Id");
		}
		
		Pattern pattern1= Pattern.compile("^.+@.+\\..+$");
		Matcher matcher1= pattern1.matcher(customer.getCustomerEmail());
		
		if(!matcher1.matches()) {
			errors.rejectValue("emailId", "Invalid Email", "Enter a valid Email address");
		}
	}

	

}
