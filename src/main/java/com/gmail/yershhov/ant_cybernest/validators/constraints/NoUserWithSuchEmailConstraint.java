package com.gmail.yershhov.ant_cybernest.validators.constraints;

import com.gmail.yershhov.ant_cybernest.validators.NoUserWithSuchEmailValidator;
import com.gmail.yershhov.ant_cybernest.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NoUserWithSuchEmailValidator.class)
public @interface NoUserWithSuchEmailConstraint {
    //error message
    String message() default "Email is not registered";
    //represents group of constraints
    Class<?>[] groups() default {};
    //represents additional information about annotation
    Class<? extends Payload>[] payload() default {};
}
