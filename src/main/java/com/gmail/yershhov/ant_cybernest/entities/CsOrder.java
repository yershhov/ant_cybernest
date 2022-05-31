package com.gmail.yershhov.ant_cybernest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cs_order")
@Table(name = "cs_order")
public class CsOrder implements Comparable<CsOrder>{
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
    private String winRate;
    @Column
    private String bestMap;
    @Column
    private String hoursPlayed;

    @Override
    public int compareTo(CsOrder o) {
        return this.orderId - o.orderId;
    }
}
