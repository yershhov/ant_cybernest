package com.gmail.yershhov.ant_cybernest.entities;

public class Order {
    private String game;
    private User user;


    public Order(String game) {
        this.game = game;
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


