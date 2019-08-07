package com.bookstoreWeb.utility;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.bookstoreWeb.model.AddBookModel;
 
@Component 
public class ColourValidator implements Validator {
 
	
	
	@Override
	   public boolean supports(Class<?> clazz) {
	      return AddBookModel.class.equals(clazz);
	   }

	   @Override
	   public void validate(Object obj, Errors err) {

	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "bookName", "Select Book");
	      //ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
	      //ValidationUtils.rejectIfEmpty(err, "gender", "user.gender.empty");
	      //ValidationUtils.rejectIfEmpty(err, "languages", "user.languages.empty");

	      /*AddBookModel user = (AddBookModel) obj;
	      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(pattern.matcher(user.getEmail()).matches())) {
	         err.rejectValue("email", "user.email.invalid");
	      }*/

	   }
        /*public boolean supports(Class<?> paramClass) {
            return AddBookModel.class.equals(paramClass);
        }
 
        public void validate(Object obj, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colourName", "Please select a colour!");
        }*/
}