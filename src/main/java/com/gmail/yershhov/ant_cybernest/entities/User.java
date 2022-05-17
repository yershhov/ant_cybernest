package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "User")
@Table
public class User{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE;
            generator = "user_sequence"
    )
    private Integer id;

    private String fullName;
    private String email;
    private String phone;
    private String experience;
    private Boolean registered = false;

    public User(Integer id,
                String fullName,
                String email,
                String phone,
                String experience,
                Boolean registered) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.experience = experience;
        this.registered = registered;
    }
}
