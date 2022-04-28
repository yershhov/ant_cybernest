package com.gmail.yershhov.ant_cybernest.entities;

public class Order {
    private String game;
    private String fullName;
    private String email;
    private String phone;
    private String experience;
    private String preferredRole = "-";

    public String getPreferredRole() {
        return preferredRole;
    }

    public void setPreferredRole(String preferredRole) {
        this.preferredRole = preferredRole;
    }

    public Order(String game) {
        this.game = game;
    }


    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


