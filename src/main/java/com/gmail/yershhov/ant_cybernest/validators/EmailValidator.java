package com.gmail.yershhov.ant_cybernest.validators;

import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.validators.constraints.EmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private final UserRepository userRepository;


    public EmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return userRepository.findByEmail(email).size() != 1;
    }
}
