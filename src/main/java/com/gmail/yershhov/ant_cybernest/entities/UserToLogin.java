package com.gmail.yershhov.ant_cybernest.entities;

import com.gmail.yershhov.ant_cybernest.validators.constraints.NoUserWithSuchEmailConstraint;
import com.gmail.yershhov.ant_cybernest.validators.constraints.PasswordConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordConstraint
public class UserToLogin {
    @NoUserWithSuchEmailConstraint
    private String email;
    private String password;
}
