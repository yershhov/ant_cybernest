package com.gmail.yershhov.ant_cybernest.validators.constraints;

import com.gmail.yershhov.ant_cybernest.validators.EmailIsTakenValidator;
import com.gmail.yershhov.ant_cybernest.validators.InvalidEmailOrPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target( { TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InvalidEmailOrPasswordValidator.class)
public @interface InvalidEmailOrPasswordConstraint {
    //error message
    public String message() default "Invalid email or password";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
