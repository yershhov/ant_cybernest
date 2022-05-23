package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Integer userId;
    private String game;
    private Integer orderId;
    private String userExperience;
}


