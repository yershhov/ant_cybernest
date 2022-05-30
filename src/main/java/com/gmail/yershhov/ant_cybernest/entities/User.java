package com.gmail.yershhov.ant_cybernest.entities;

import com.gmail.yershhov.ant_cybernest.validators.constraints.EmailIsTakenConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "app_user")
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "app_user_email_unique", columnNames = "email")
})
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence"
    )
    @Column(updatable = false)
    private Integer userId;

    @OneToMany(mappedBy = "user")
    private List<DotaOrder> orders;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String fullName;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    @EmailIsTakenConstraint
    private String email;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String phone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

}
