package com.example.cooper.baseballbuddy.models;

/**
 * Created by Cooper1 on 3/8/2017.
 */

public class inningModel {

    private int inningID;
    private int gameID;
    private int inningNumber;
    private int awayTeamRunsThisInning;
    private int homeTeamRunsThisInning;

    public int getInningID() {
        return inningID;
    }

    public void setInningID(int inningID) {
        this.inningID = inningID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getInningNumber() {
        return inningNumber;
    }

    public void setInningNumber(int inningNumber) {
        this.inningNumber = inningNumber;
    }

    public int getAwayTeamRunsThisInning() {
        return awayTeamRunsThisInning;
    }

    public void setAwayTeamRunsThisInning(int awayTeamRunsThisInning) {
        this.awayTeamRunsThisInning = awayTeamRunsThisInning;
    }

    public int getHomeTeamRunsThisInning() {
        return homeTeamRunsThisInning;
    }

    public void setHomeTeamRunsThisInning(int homeTeamRunsThisInning) {
        this.homeTeamRunsThisInning = homeTeamRunsThisInning;
    }
}
