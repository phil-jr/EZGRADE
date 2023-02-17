package com.example.ezgrade.validators;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.example.ezgrade.model.Student;

import static com.example.ezgrade.constants.RegexExpressions.NAME_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.STATE_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.EMAIL_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.CITY_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.PHONE_NUMBER_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.ZIPCODE_REGEX_PATTERN;
import static com.example.ezgrade.constants.RegexExpressions.PASSWORD_REGEX_PATTERN;

@Configuration
public class ValidateSignUp {
  
  public ArrayList<String> validateSignUp(Student student) {
    ArrayList<String> errors = new ArrayList<>();

    if(!NAME_REGEX_PATTERN.matcher(student.getFirstName()).find()) {
      errors.add("Invalid First Name");
    }

    if(!NAME_REGEX_PATTERN.matcher(student.getLastName()).find()) {
      errors.add("Invalid Last Name");
    }

    if(!EMAIL_REGEX_PATTERN.matcher(student.getEmail()).find()) {
      errors.add("Invalid Email");
    }

    if(student.getPhoneNumber() != "") {
      if(!PHONE_NUMBER_REGEX_PATTERN.matcher(student.getPhoneNumber()).find()) {
        errors.add("Invalid Phone Number");
      }
    } else {
      student.setPhoneNumber(null);
    }

    if(student.getCity() != "") {
      if(!CITY_REGEX_PATTERN.matcher(student.getCity()).find()) {
        errors.add("Invalid City");
      }
    } else {
      student.setCity(null);
    }

    if(student.getState() != "") {
      if(!STATE_REGEX_PATTERN.matcher(student.getState()).find()) {
        errors.add("Invalid State");
      }
    } else {
      student.setState(null);
    }

    if(student.getZipCode() != "") {
      if(!ZIPCODE_REGEX_PATTERN.matcher(student.getZipCode()).find()) {
        errors.add("Invalid Zip Code");
      }
    } else {
      student.setZipCode(null);
    }

    if(!PASSWORD_REGEX_PATTERN.matcher(student.getPassword()).find()) {
      errors.add("Invalid Password");
    }

    return errors;
  }

}
