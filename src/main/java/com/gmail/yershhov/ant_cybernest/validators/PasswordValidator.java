package com.gmail.yershhov.ant_cybernest.validators;

import com.gmail.yershhov.ant_cybernest.controllers.EncryptionController;
import com.gmail.yershhov.ant_cybernest.entities.User;
import com.gmail.yershhov.ant_cybernest.entities.UserToLogin;
import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.validators.constraints.PasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.security.NoSuchAlgorithmException;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, UserToLogin> {
    private final UserRepository userRepository;

    public PasswordValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(UserToLogin userToLogin, ConstraintValidatorContext cxt) {
        try {
            if(EncryptionController.encrypt(userRepository.findByEmail(userToLogin.getEmail()).get(0).getPassword()).
                    equals(userRepository.findByEmail(userToLogin.getEmail()).get(0).getPassword())){
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}