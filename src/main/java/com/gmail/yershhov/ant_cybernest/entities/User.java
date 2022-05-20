package com.gmail.yershhov.ant_cybernest.entities;

import javax.persistence.*;

@Entity(name = "app_user")
@Table(name = "app_user", uniqueConstraints = {
        @UniqueConstraint(name = "app_user_email_unique", columnNames = "email")
})
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
    private Integer id;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String fullName;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String phone;

    @Column(nullable = false)
    private Boolean registered;

    public User(String fullName,
                String email,
                String phone,
                Boolean registered) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.registered = registered;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registered=" + registered +
                '}';
    }
}
