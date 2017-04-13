package com.example.cooper.baseballbuddy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cooper1 on 3/22/2017.
 */

public class userInformation {
    public ArrayList<String>favoriteTeams = new ArrayList<>();
    public String teamName;
    public int teamID; // using the webservice's teamID associated with it to fetch data relevant only to the favorite teams
    public userInformation(){

    }
    public void addTeam(String teamName){
        favoriteTeams.add(teamName);
    }
    public userInformation(String teamName) {
        this.teamName = teamName;
        this.teamID = associateWithID(teamName);

    }

    public ArrayList<String> getFavoriteTeams() {
        return favoriteTeams;
    }

    public String getTeamName() {
        return teamName;
    }
    public int associateWithID(String givenName){
        HashMap<Integer,String> given = new HashMap<Integer, String>();
        given.put(1,"Los Angeles Dodgers" );
        given.put(2, "Cincinnati Reds");
        given.put(3, "Toronto Blue Jays");
        given.put(4, "Pittsburgh Pirates");
        given.put(5, "Kansas City Royals");
        given.put(6, "Retired");
        given.put(7, "National League All Stars");
        given.put(8, "Unknown team");
        given.put(9,"Chicago Cubs" );
        given.put(10, "Cleveland Indians");
        given.put(11, "Tampa Bay Rays");
        given.put(12, "Philadelphia Phillies");
        given.put(13, "Seattle Mariners");
        given.put(14, "Arizona Diamondbacks");
        given.put(15, "San Francisco Giants");
        given.put(16, "Chicago White Sox");
        given.put(17, "Detroit Tigers");
        given.put(18, "New York Mets");
        given.put(19, "Baltimore Orioles");
        given.put(20, "Minnesota Twins");
        given.put(21, "Los Angeles Angels of Anaheim");
        given.put(22,"Miami Marlins" );
        given.put(23, "Colorado Rockies");
        given.put(24,"Oakland Athletics" );
        given.put(25,"Boston Red Sox" );
        given.put(26, "Atlanta Braves" );
        given.put(27,"American League All Stars" );
        given.put(28,"Texas Rangers" );
        given.put(29,"New York Yankees" );
        given.put(30,"Houston Astros" );
        given.put(31,"St. Louis Cardinals" );
        given.put(32,"Milwaukee Brewers" );
        given.put(33,"San Diego Padres" );
        given.put(34,"Minor League" );
        given.put(35,"Washington Nationals");
        for(Integer key : given.keySet()){
            if(given.get(key).equals(teamName)){
                return key; //return the first found
            }
        }
        return 0;
    }
}
