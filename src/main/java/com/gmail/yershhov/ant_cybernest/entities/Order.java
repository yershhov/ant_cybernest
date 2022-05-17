package com.gmail.yershhov.ant_cybernest.entities;

public class Order {
    private User user;
    private String game;
    private Integer additionalPractice;

    public Order() {
    }

    public Integer getAdditionalPractice() {
        return additionalPractice;
    }

    public void setAdditionalPractice(Integer additionalPractice) {
        this.additionalPractice = additionalPractice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}


