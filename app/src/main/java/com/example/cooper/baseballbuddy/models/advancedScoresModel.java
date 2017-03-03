package com.example.cooper.baseballbuddy.models;

/**
 * Created by Cooper on 2/28/2017.
 */

public class advancedScoresModel {

    private String City;
    private String Name;
    private String WikipediaLogoUrl;
    private int teamID;
    private int globalID;
    private boolean isHomeTeam = false;
    private boolean isAwayTeam = false;

    public boolean isHomeTeam() {
        return isHomeTeam;
    }

    public void setHomeTeam(boolean homeTeam) {
        isHomeTeam = homeTeam;
    }

    public boolean isAwayTeam() {
        return isAwayTeam;
    }

    public void setAwayTeam(boolean awayTeam) {
        isAwayTeam = awayTeam;
    }

    public int getGlobalID() {
        return globalID;
    }

    public void setGlobalID(int globalID) {
        this.globalID = globalID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWikipediaLogoUrl() {
        return WikipediaLogoUrl;
    }

    public void setWikipediaLogoUrl(String wikipediaLogoUrl) {
        WikipediaLogoUrl = wikipediaLogoUrl;
    }
}
