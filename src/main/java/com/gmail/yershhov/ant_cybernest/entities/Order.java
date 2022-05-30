package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @Column
    private Integer orderId;
    @Column
    private String game;
    @Column
    private String userExperience;
}


