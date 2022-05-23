package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserToLogin {
    private String email;
    private String password;
}
