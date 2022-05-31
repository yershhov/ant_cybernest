package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dota_order")
@Table(name = "dota_order")
@Getter
@Setter
@NoArgsConstructor
public class DotaOrder implements Comparable<DotaOrder>{
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String game;
    @Column
    private String userExperience;
    @Column
    private String role;
    @Column
    private String communication;

    @Override
    public int compareTo(DotaOrder o) {
        return this.orderId - o.orderId;
    }
}

