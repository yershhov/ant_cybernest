package com.gmail.yershhov.ant_cybernest.entities;
import com.gmail.yershhov.ant_cybernest.validators.constraints.InvalidEmailOrPasswordConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@InvalidEmailOrPasswordConstraint
public class UserToLogin {

    private String email;
    private String password;
    private Boolean isValid;
}
