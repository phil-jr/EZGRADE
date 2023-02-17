package com.example.ezgrade.constants;

import java.util.regex.Pattern;

public class RegexExpressions {
  
  private RegexExpressions() {
    // restrict instantiation
  }

  public static final Pattern NAME_REGEX_PATTERN =  Pattern.compile("/^[A-Za-z0-9_]{1,20}$/");
  public static final Pattern STATE_REGEX_PATTERN =  Pattern.compile("/^[A-Z]{2}$/");
  public static final Pattern EMAIL_REGEX_PATTERN =  Pattern.compile("/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$/");
  public static final Pattern CITY_REGEX_PATTERN =  Pattern.compile("/^[A-Z][a-zA-Z]*(\s+[A-Z][a-zA-Z]*)*$/");
  public static final Pattern PHONE_NUMBER_REGEX_PATTERN =  Pattern.compile("/^(\\+1\s)?\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/");
  public static final Pattern ZIPCODE_REGEX_PATTERN =  Pattern.compile("/^\\d{5}(?:[-\\s]\\d{4})?$/");
  public static final Pattern PASSWORD_REGEX_PATTERN =  Pattern.compile("/^(?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*^a-zA-Z0-9])(?!.*s)&].{8,20}/");

}
