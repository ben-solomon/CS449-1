package com.example.cooper.baseballbuddy.models;

/**
 * Created by Cooper on 2/14/2017.
 */

public class NewsModel {
    private int NewsID;
    private String Title;
    private String Updated;
    private String Url;
    private String Content;
    private String Source;
    private String TermsOfUse;
    private int PlayerID;
    private int TeamID;
    private String Team;

    public void setTitle(String Title){
        this.Title = Title;
    }
    public String getTitle(){
        return Title;
    }
    public int getPlayerID(){
        return PlayerID;
    }
    public void setPlayerID(int PlayerID){
        this.PlayerID = PlayerID;
    }
    public int getTeamID(){
        return TeamID;
    }
    public void setTeamID(int TeamID){
        this.TeamID = TeamID;
    }
    public int getNewsID(){
        return NewsID;
    }
    public void setNewsID(int NewsID){
        this.NewsID = NewsID;
    }
    public String getUpdated(){
        return Updated;
    }
    public void setUpdated(String Updated){
        this.Updated = Updated;
    }
    public String getUrl(){
        return Url;
    }
    public void setUrl(String Url){
        this.Url = Url;
    }
    public String getContent(){
        return Content;
    }
    public void setContent(String Content){
        this.Content = Content;
    }
    public String getSource(){
        return Source;
    }
    public void setSource(String Source){
        this.Source = Source;
    }
    public String getTermsOfUse(){
        return TermsOfUse;
    }
    public void setTermsOfUse(String TermsOfUse){
        this.TermsOfUse = TermsOfUse;
    }
    public String getTeam(){
        return Team;
    }
    public void setTeam(String Team){
        this.Team = Team;
    }
}
