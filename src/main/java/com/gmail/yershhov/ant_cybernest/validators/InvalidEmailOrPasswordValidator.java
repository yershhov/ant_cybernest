package com.gmail.yershhov.ant_cybernest.validators;

import com.gmail.yershhov.ant_cybernest.controllers.EncryptionController;
import com.gmail.yershhov.ant_cybernest.entities.User;
import com.gmail.yershhov.ant_cybernest.entities.UserToLogin;
import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.validators.constraints.InvalidEmailOrPasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class InvalidEmailOrPasswordValidator implements ConstraintValidator<InvalidEmailOrPasswordConstraint, UserToLogin> {
    private final UserRepository userRepository;

    public InvalidEmailOrPasswordValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean isValid(UserToLogin userToLogin, ConstraintValidatorContext constraintValidatorContext) {
        List<User> user = userRepository.findByEmail(userToLogin.getEmail());
        if(user.size() == 0){
            return false;
        }

        boolean isValid = false;
        try {
            isValid = EncryptionController.encrypt(userToLogin.getPassword()).equals(user.get(0).getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(!isValid){
//            constraintValidatorContext.disableDefaultConstraintViolation();
//            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
//                    .addPropertyNode( "invalidEmailOrPassword" ).addConstraintViolation();
            return false;
        }

        return true;
    }
}
