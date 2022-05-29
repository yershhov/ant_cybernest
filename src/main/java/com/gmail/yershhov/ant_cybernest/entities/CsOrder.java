package com.gmail.yershhov.ant_cybernest.entities;

public class CsOrder extends Order{
    private String winRate;
    private String bestMap;
    private String hoursPlayed;

    public String getBestMap() {
        return bestMap;
    }

    public String getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(String hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public String getWinRate() {
        return winRate;
    }

    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }

    public void setBestMap(String bestMap) {
        this.bestMap = bestMap;
    }
}
