package com.tunidesign.utilisateurmicroservice.model.annotation.passwordmatches;

import com.tunidesign.utilisateurmicroservice.model.entity.User;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    private String message;
  
      @Override
      public void initialize(PasswordMatches passwordMatches) {
        this.message = passwordMatches.message();
      }
  
      @Override
      public boolean isValid(Object obj, ConstraintValidatorContext context) {
  
          final User user = (User) obj;
          boolean isValid = user.getPassword().equals(user.getConfirmPassword());
  
          if (!isValid) {
              context.disableDefaultConstraintViolation();
              context
                      .buildConstraintViolationWithTemplate( message )
                      .addPropertyNode( "matchingPassword" ).addConstraintViolation();
          }
          return isValid;
  
      }
  }
