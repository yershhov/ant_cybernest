package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "dota_order")
@Table(name = "dota_order")
@Getter
@Setter
@NoArgsConstructor
public class DotaOrder extends Order {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @GeneratedValue
    private Integer orderId;
    @Column
    private String role;
    @Column
    private String communication;


}

