package com.example.cooper.baseballbuddy.models;

/**
 * Created by Cooper on 2/28/2017.
 */

public class boxScoreModel {
    private int AwayTeamID;
    private int HomeTeamID;
    private int homeScore;
    private int awayScore;

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        AwayTeamID = awayTeamID;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        HomeTeamID = homeTeamID;
    }
}
