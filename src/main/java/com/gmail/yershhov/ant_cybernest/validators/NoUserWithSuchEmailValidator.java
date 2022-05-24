package com.gmail.yershhov.ant_cybernest.validators;

import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.validators.constraints.NoUserWithSuchEmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoUserWithSuchEmailValidator implements ConstraintValidator<NoUserWithSuchEmailConstraint, String> {
    private final UserRepository userRepository;

    public NoUserWithSuchEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return userRepository.findByEmail(email).size() != 0;
    }
}

