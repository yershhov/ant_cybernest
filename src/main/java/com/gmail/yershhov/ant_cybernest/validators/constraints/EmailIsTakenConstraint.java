package com.gmail.yershhov.ant_cybernest.validators.constraints;

import com.gmail.yershhov.ant_cybernest.validators.EmailIsTakenValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailIsTakenValidator.class)
public @interface EmailIsTakenConstraint {
    //error message
    public String message() default "User with such email already exists";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
