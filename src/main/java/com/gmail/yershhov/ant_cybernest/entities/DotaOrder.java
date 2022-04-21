package com.gmail.yershhov.ant_cybernest.entities;

public class DotaOrder extends Order{
    private String preferredRole;

    public DotaOrder(String game) {
        super(game);
    }

    public String getPreferredRole() {
        return preferredRole;
    }

    public void setPreferredRole(String preferredRole) {
        this.preferredRole = preferredRole;
    }
}
