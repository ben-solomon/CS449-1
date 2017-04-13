package com.example.cooper.baseballbuddy.models;

/**
 * Created by Cooper on 2/21/2017.
 * Used to load fantasyData web service call into variables. Specifically for a singular game's stats
 */

public class ScoresModel {
    private String GameID;
    private String season;
    private int seasonType;
    private String status;
    private String Day;
    private String dateTime;
    private String awayTeam;
    private String homeTeam;
    private String awayTeamID;
    private String homeTeamID;
    private String rescheduledGameID;
    private String stadiumID;
    private String channel;
    private int inning;
    private String inningHalf;
    private int awayTeamRuns;
    private int homeTeamRuns;
    private int awayTeamHits;
    private int homeTeamHits;
    private int awayTeamErrors;
    private int homeTeamErrors;
    private String winningPitcherID;
    private String losingPitcherID;
    private String savingPitcherID;
    private String attendance;
    private String awayTeamProbablePitcherID;
    private String homeTeamProbablePitcherID;
    private int outs;
    private int balls;
    private int strikes;
    private String currentPitcherID;
    private String currentHitterID;
    private String awayTeamStartingPitcherID;
    private String homeTeamStartingPitcherID;
    private String currentPitchingTeamID;
    private String currentHittingTeamID;
    private int pointSpread;
    private int overUnder;
    private int awayTeamMoneyLine;
    private int homeTeamMoneyLine;
    private int forecastTempLow;
    private int forecastTempHigh;
    private String forecastDescription;
    private String forecastWindChill;
    private int forecastWindSpeed;
    private String forecastWindDirection;
    private String rescheduledFromGameID;
    private boolean runnerOnFirst;// This may not be of type bool, can't currently tell.
    private boolean runnerOnSecond;//ditto
    private boolean runnerOnThird;//also ditto
    private String awayTeamStartingPitcher;
    private String homeTeamStartingPitcher;
    private String currentPitcher;
    private String currentHitter;
    private String winningPitcher;
    private String losingPitcher;
    private String savingPitcher;
    private String dueUpHitterID1;
    private String dueUpHitterID2;
    private String dueUpHitterID3;
    private String globalGameID;
    private int globalAwayTeamID;
    private int globalHomeTeamID;
    private String awayLogoURL;
    private String homeLogoURL;

    public String getHomeLogoURL() {
        return homeLogoURL;
    }

    public void setHomeLogoURL(String homeLogoURL) {
        this.homeLogoURL = homeLogoURL;
    }

    public String getAwayLogoURL() {
        return awayLogoURL;
    }

    public void setAwayLogoURL(String awayLogoURL) {
        this.awayLogoURL = awayLogoURL;
    }

    public int getGlobalHomeTeamID() {
        return globalHomeTeamID;
    }

    public void setGlobalHomeTeamID(int globalHomeTeamID) {
        this.globalHomeTeamID = globalHomeTeamID;
    }

    public String getGameID() {
        return GameID;
    }

    public void setGameID(String gameID) {
        GameID = gameID;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(int seasonType) {
        this.seasonType = seasonType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeamID() {
        return awayTeamID;
    }

    public void setAwayTeamID(String awayTeamID) {
        this.awayTeamID = awayTeamID;
    }

    public String getHomeTeamID() {
        return homeTeamID;
    }

    public void setHomeTeamID(String homeTeamID) {
        this.homeTeamID = homeTeamID;
    }

    public String getRescheduledGameID() {
        return rescheduledGameID;
    }

    public void setRescheduledGameID(String rescheduledGameID) {
        this.rescheduledGameID = rescheduledGameID;
    }

    public String getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(String stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getInningHalf() {
        return inningHalf;
    }

    public void setInningHalf(String inningHalf) {
        this.inningHalf = inningHalf;
    }

    public int getAwayTeamRuns() {
        return awayTeamRuns;
    }

    public void setAwayTeamRuns(int awayTeamRuns) {
        this.awayTeamRuns = awayTeamRuns;
    }

    public int getHomeTeamRuns() {
        return homeTeamRuns;
    }

    public void setHomeTeamRuns(int homeTeamRuns) {
        this.homeTeamRuns = homeTeamRuns;
    }

    public int getAwayTeamHits() {
        return awayTeamHits;
    }

    public void setAwayTeamHits(int awayTeamHits) {
        this.awayTeamHits = awayTeamHits;
    }

    public int getHomeTeamHits() {
        return homeTeamHits;
    }

    public void setHomeTeamHits(int homeTeamHits) {
        this.homeTeamHits = homeTeamHits;
    }

    public int getAwayTeamErrors() {
        return awayTeamErrors;
    }

    public void setAwayTeamErrors(int awayTeamErrors) {
        this.awayTeamErrors = awayTeamErrors;
    }

    public int getHomeTeamErrors() {
        return homeTeamErrors;
    }

    public void setHomeTeamErrors(int homeTeamErrors) {
        this.homeTeamErrors = homeTeamErrors;
    }

    public String getWinningPitcherID() {
        return winningPitcherID;
    }

    public void setWinningPitcherID(String winningPitcherID) {
        this.winningPitcherID = winningPitcherID;
    }

    public String getLosingPitcherID() {
        return losingPitcherID;
    }

    public void setLosingPitcherID(String losingPitcherID) {
        this.losingPitcherID = losingPitcherID;
    }

    public String getSavingPitcherID() {
        return savingPitcherID;
    }

    public void setSavingPitcherID(String savingPitcherID) {
        this.savingPitcherID = savingPitcherID;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getAwayTeamProbablePitcherID() {
        return awayTeamProbablePitcherID;
    }

    public void setAwayTeamProbablePitcherID(String awayTeamProbablePitcherID) {
        this.awayTeamProbablePitcherID = awayTeamProbablePitcherID;
    }

    public String getHomeTeamProbablePitcherID() {
        return homeTeamProbablePitcherID;
    }

    public void setHomeTeamProbablePitcherID(String homeTeamProbablePitcherID) {
        this.homeTeamProbablePitcherID = homeTeamProbablePitcherID;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public String getCurrentPitcherID() {
        return currentPitcherID;
    }

    public void setCurrentPitcherID(String currentPitcherID) {
        this.currentPitcherID = currentPitcherID;
    }

    public String getCurrentHitterID() {
        return currentHitterID;
    }

    public void setCurrentHitterID(String currentHitterID) {
        this.currentHitterID = currentHitterID;
    }

    public String getAwayTeamStartingPitcherID() {
        return awayTeamStartingPitcherID;
    }

    public void setAwayTeamStartingPitcherID(String awayTeamStartingPitcherID) {
        this.awayTeamStartingPitcherID = awayTeamStartingPitcherID;
    }

    public String getHomeTeamStartingPitcherID() {
        return homeTeamStartingPitcherID;
    }

    public void setHomeTeamStartingPitcherID(String homeTeamStartingPitcherID) {
        this.homeTeamStartingPitcherID = homeTeamStartingPitcherID;
    }

    public String getCurrentPitchingTeamID() {
        return currentPitchingTeamID;
    }

    public void setCurrentPitchingTeamID(String currentPitchingTeamID) {
        this.currentPitchingTeamID = currentPitchingTeamID;
    }

    public String getCurrentHittingTeamID() {
        return currentHittingTeamID;
    }

    public void setCurrentHittingTeamID(String currentHittingTeamID) {
        this.currentHittingTeamID = currentHittingTeamID;
    }

    public int getPointSpread() {
        return pointSpread;
    }

    public void setPointSpread(int pointSpread) {
        this.pointSpread = pointSpread;
    }

    public int getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(int overUnder) {
        this.overUnder = overUnder;
    }

    public int getAwayTeamMoneyLine() {
        return awayTeamMoneyLine;
    }

    public void setAwayTeamMoneyLine(int awayTeamMoneyLine) {
        this.awayTeamMoneyLine = awayTeamMoneyLine;
    }

    public int getHomeTeamMoneyLine() {
        return homeTeamMoneyLine;
    }

    public void setHomeTeamMoneyLine(int homeTeamMoneyLine) {
        this.homeTeamMoneyLine = homeTeamMoneyLine;
    }

    public int getForecastTempLow() {
        return forecastTempLow;
    }

    public void setForecastTempLow(int forecastTempLow) {
        this.forecastTempLow = forecastTempLow;
    }

    public int getForecastTempHigh() {
        return forecastTempHigh;
    }

    public void setForecastTempHigh(int forecastTempHigh) {
        this.forecastTempHigh = forecastTempHigh;
    }

    public String getForecastDescription() {
        return forecastDescription;
    }

    public void setForecastDescription(String forecastDescription) {
        this.forecastDescription = forecastDescription;
    }

    public String getForecastWindChill() {
        return forecastWindChill;
    }

    public void setForecastWindChill(String forecastWindChill) {
        this.forecastWindChill = forecastWindChill;
    }

    public int getForecastWindSpeed() {
        return forecastWindSpeed;
    }

    public void setForecastWindSpeed(int forecastWindSpeed) {
        this.forecastWindSpeed = forecastWindSpeed;
    }

    public String getForecastWindDirection() {
        return forecastWindDirection;
    }

    public void setForecastWindDirection(String forecastWindDirection) {
        this.forecastWindDirection = forecastWindDirection;
    }

    public String getRescheduledFromGameID() {
        return rescheduledFromGameID;
    }

    public void setRescheduledFromGameID(String rescheduledFromGameID) {
        this.rescheduledFromGameID = rescheduledFromGameID;
    }

    public boolean isRunnerOnFirst() {
        return runnerOnFirst;
    }

    public void setRunnerOnFirst(boolean runnerOnFirst) {
        this.runnerOnFirst = runnerOnFirst;
    }

    public boolean isRunnerOnSecond() {
        return runnerOnSecond;
    }

    public void setRunnerOnSecond(boolean runnerOnSecond) {
        this.runnerOnSecond = runnerOnSecond;
    }

    public boolean isRunnerOnThird() {
        return runnerOnThird;
    }

    public void setRunnerOnThird(boolean runnerOnThird) {
        this.runnerOnThird = runnerOnThird;
    }

    public String getAwayTeamStartingPitcher() {
        return awayTeamStartingPitcher;
    }

    public void setAwayTeamStartingPitcher(String awayTeamStartingPitcher) {
        this.awayTeamStartingPitcher = awayTeamStartingPitcher;
    }

    public String getHomeTeamStartingPitcher() {
        return homeTeamStartingPitcher;
    }

    public void setHomeTeamStartingPitcher(String homeTeamStartingPitcher) {
        this.homeTeamStartingPitcher = homeTeamStartingPitcher;
    }

    public String getCurrentPitcher() {
        return currentPitcher;
    }

    public void setCurrentPitcher(String currentPitcher) {
        this.currentPitcher = currentPitcher;
    }

    public String getCurrentHitter() {
        return currentHitter;
    }

    public void setCurrentHitter(String currentHitter) {
        this.currentHitter = currentHitter;
    }

    public String getWinningPitcher() {
        return winningPitcher;
    }

    public void setWinningPitcher(String winningPitcher) {
        this.winningPitcher = winningPitcher;
    }

    public String getLosingPitcher() {
        return losingPitcher;
    }

    public void setLosingPitcher(String losingPitcher) {
        this.losingPitcher = losingPitcher;
    }

    public String getSavingPitcher() {
        return savingPitcher;
    }

    public void setSavingPitcher(String savingPitcher) {
        this.savingPitcher = savingPitcher;
    }

    public String getDueUpHitterID1() {
        return dueUpHitterID1;
    }

    public void setDueUpHitterID1(String dueUpHitterID1) {
        this.dueUpHitterID1 = dueUpHitterID1;
    }

    public String getDueUpHitterID2() {
        return dueUpHitterID2;
    }

    public void setDueUpHitterID2(String dueUpHitterID2) {
        this.dueUpHitterID2 = dueUpHitterID2;
    }

    public String getDueUpHitterID3() {
        return dueUpHitterID3;
    }

    public void setDueUpHitterID3(String dueUpHitterID3) {
        this.dueUpHitterID3 = dueUpHitterID3;
    }

    public String getGlobalGameID() {
        return globalGameID;
    }

    public void setGlobalGameID(String globalGameID) {
        this.globalGameID = globalGameID;
    }

    public int getGlobalAwayTeamID() {
        return globalAwayTeamID;
    }

    public void setGlobalAwayTeamID(int globalAwayTeamID) {
        this.globalAwayTeamID = globalAwayTeamID;
    }

    /*  public int getForecastWindSpeed() {
        return forecastWindSpeed;
    }

    public void setForecastWindSpeed(int forecastWindSpeed) {
        this.forecastWindSpeed = forecastWindSpeed;
    }
    public int getGlobalHomeTeamID() {
        return globalHomeTeamID;
    }

    public void setGlobalHomeTeamID(int globalHomeTeamID) {
        this.globalHomeTeamID = globalHomeTeamID;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {
        GameID = gameID;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(int seasonType) {
        this.seasonType = seasonType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        this.awayTeamID = awayTeamID;
    }

    public int getHomeTeamID() {
        return homeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        this.homeTeamID = homeTeamID;
    }

    public String getRescheduledGameID() {
        return rescheduledGameID;
    }

    public void setRescheduledGameID(String rescheduledGameID) {
        this.rescheduledGameID = rescheduledGameID;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(int stadiumID) {
        this.stadiumID = stadiumID;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getInningHalf() {
        return inningHalf;
    }

    public void setInningHalf(String inningHalf) {
        this.inningHalf = inningHalf;
    }

    public int getAwayTeamRuns() {
        return awayTeamRuns;
    }

    public void setAwayTeamRuns(int awayTeamRuns) {
        this.awayTeamRuns = awayTeamRuns;
    }

    public int getHomeTeamRuns() {
        return homeTeamRuns;
    }

    public void setHomeTeamRuns(int homeTeamRuns) {
        this.homeTeamRuns = homeTeamRuns;
    }

    public int getAwayTeamHits() {
        return awayTeamHits;
    }

    public void setAwayTeamHits(int awayTeamHits) {
        this.awayTeamHits = awayTeamHits;
    }

    public int getHomeTeamHits() {
        return homeTeamHits;
    }

    public void setHomeTeamHits(int homeTeamHits) {
        this.homeTeamHits = homeTeamHits;
    }

    public int getAwayTeamErrors() {
        return awayTeamErrors;
    }

    public void setAwayTeamErrors(int awayTeamErrors) {
        this.awayTeamErrors = awayTeamErrors;
    }

    public int getHomeTeamErrors() {
        return homeTeamErrors;
    }

    public void setHomeTeamErrors(int homeTeamErrors) {
        this.homeTeamErrors = homeTeamErrors;
    }

    public int getWinningPitcherID() {
        return winningPitcherID;
    }

    public void setWinningPitcherID(int winningPitcherID) {
        this.winningPitcherID = winningPitcherID;
    }

    public int getLosingPitcherID() {
        return losingPitcherID;
    }

    public void setLosingPitcherID(int losingPitcherID) {
        this.losingPitcherID = losingPitcherID;
    }

    public int getSavingPitcherID() {
        return savingPitcherID;
    }

    public void setSavingPitcherID(int savingPitcherID) {
        this.savingPitcherID = savingPitcherID;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getAwayTeamProbablePitcherID() {
        return awayTeamProbablePitcherID;
    }

    public void setAwayTeamProbablePitcherID(int awayTeamProbablePitcherID) {
        this.awayTeamProbablePitcherID = awayTeamProbablePitcherID;
    }

    public int getHomeTeamProbablePitcherID() {
        return homeTeamProbablePitcherID;
    }

    public void setHomeTeamProbablePitcherID(int homeTeamProbablePitcherID) {
        this.homeTeamProbablePitcherID = homeTeamProbablePitcherID;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getCurrentPitcherID() {
        return currentPitcherID;
    }

    public void setCurrentPitcherID(int currentPitcherID) {
        this.currentPitcherID = currentPitcherID;
    }

    public int getCurrentHitterID() {
        return currentHitterID;
    }

    public void setCurrentHitterID(int currentHitterID) {
        this.currentHitterID = currentHitterID;
    }

    public int getAwayTeamStartingPitcherID() {
        return awayTeamStartingPitcherID;
    }

    public void setAwayTeamStartingPitcherID(int awayTeamStartingPitcherID) {
        this.awayTeamStartingPitcherID = awayTeamStartingPitcherID;
    }

    public int getHomeTeamStartingPitcherID() {
        return homeTeamStartingPitcherID;
    }

    public void setHomeTeamStartingPitcherID(int homeTeamStartingPitcherID) {
        this.homeTeamStartingPitcherID = homeTeamStartingPitcherID;
    }

    public int getCurrentPitchingTeamID() {
        return currentPitchingTeamID;
    }

    public void setCurrentPitchingTeamID(int currentPitchingTeamID) {
        this.currentPitchingTeamID = currentPitchingTeamID;
    }

    public int getCurrentHittingTeamID() {
        return currentHittingTeamID;
    }

    public void setCurrentHittingTeamID(int currentHittingTeamID) {
        this.currentHittingTeamID = currentHittingTeamID;
    }

    public int getPointSpread() {
        return pointSpread;
    }

    public void setPointSpread(int pointSpread) {
        this.pointSpread = pointSpread;
    }

    public int getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(int overUnder) {
        this.overUnder = overUnder;
    }

    public int getAwayTeamMoneyLine() {
        return awayTeamMoneyLine;
    }

    public void setAwayTeamMoneyLine(int awayTeamMoneyLine) {
        this.awayTeamMoneyLine = awayTeamMoneyLine;
    }

    public int getHomeTeamMoneyLine() {
        return homeTeamMoneyLine;
    }

    public void setHomeTeamMoneyLine(int homeTeamMoneyLine) {
        this.homeTeamMoneyLine = homeTeamMoneyLine;
    }

    public int getForecastTempLow() {
        return forecastTempLow;
    }

    public void setForecastTempLow(int forecastTempLow) {
        this.forecastTempLow = forecastTempLow;
    }

    public int getForecastTempHigh() {
        return forecastTempHigh;
    }

    public void setForecastTempHigh(int forecastTempHigh) {
        this.forecastTempHigh = forecastTempHigh;
    }

    public String getForecastDescription() {
        return forecastDescription;
    }

    public void setForecastDescription(String forecastDescription) {
        this.forecastDescription = forecastDescription;
    }

    public String getForecastWindChill() {
        return forecastWindChill;
    }

    public void setForecastWindChill(String forecastWindChill) {
        this.forecastWindChill = forecastWindChill;
    }

    public String getForecastWindDirection() {
        return forecastWindDirection;
    }

    public void setForecastWindDirection(String forecastWindDirection) {
        this.forecastWindDirection = forecastWindDirection;
    }

    public int getRescheduledFromGameID() {
        return rescheduledFromGameID;
    }

    public void setRescheduledFromGameID(int rescheduledFromGameID) {
        this.rescheduledFromGameID = rescheduledFromGameID;
    }

    public boolean isRunnerOnFirst() {
        return runnerOnFirst;
    }

    public void setRunnerOnFirst(boolean runnerOnFirst) {
        this.runnerOnFirst = runnerOnFirst;
    }

    public boolean isRunnerOnSecond() {
        return runnerOnSecond;
    }

    public void setRunnerOnSecond(boolean runnerOnSecond) {
        this.runnerOnSecond = runnerOnSecond;
    }

    public boolean isRunnerOnThird() {
        return runnerOnThird;
    }

    public void setRunnerOnThird(boolean runnerOnThird) {
        this.runnerOnThird = runnerOnThird;
    }

    public String getAwayTeamStartingPitcher() {
        return awayTeamStartingPitcher;
    }

    public void setAwayTeamStartingPitcher(String awayTeamStartingPitcher) {
        this.awayTeamStartingPitcher = awayTeamStartingPitcher;
    }

    public String getHomeTeamStartingPitcher() {
        return homeTeamStartingPitcher;
    }

    public void setHomeTeamStartingPitcher(String homeTeamStartingPitcher) {
        this.homeTeamStartingPitcher = homeTeamStartingPitcher;
    }

    public String getCurrentPitcher() {
        return currentPitcher;
    }

    public void setCurrentPitcher(String currentPitcher) {
        this.currentPitcher = currentPitcher;
    }

    public String getCurrentHitter() {
        return currentHitter;
    }

    public void setCurrentHitter(String currentHitter) {
        this.currentHitter = currentHitter;
    }

    public String getWinningPitcher() {
        return winningPitcher;
    }

    public void setWinningPitcher(String winningPitcher) {
        this.winningPitcher = winningPitcher;
    }

    public String getLosingPitcher() {
        return losingPitcher;
    }

    public void setLosingPitcher(String losingPitcher) {
        this.losingPitcher = losingPitcher;
    }

    public String getSavingPitcher() {
        return savingPitcher;
    }

    public void setSavingPitcher(String savingPitcher) {
        this.savingPitcher = savingPitcher;
    }

    public int getDueUpHitterID1() {
        return dueUpHitterID1;
    }

    public void setDueUpHitterID1(int dueUpHitterID1) {
        this.dueUpHitterID1 = dueUpHitterID1;
    }

    public int getDueUpHitterID2() {
        return dueUpHitterID2;
    }

    public void setDueUpHitterID2(int dueUpHitterID2) {
        this.dueUpHitterID2 = dueUpHitterID2;
    }

    public int getDueUpHitterID3() {
        return dueUpHitterID3;
    }

    public void setDueUpHitterID3(int dueUpHitterID3) {
        this.dueUpHitterID3 = dueUpHitterID3;
    }

    public int getGlobalGameID() {
        return globalGameID;
    }

    public void setGlobalGameID(int globalGameID) {
        this.globalGameID = globalGameID;
    }

    public int getGlobalAwayTeamID() {
        return globalAwayTeamID;
    }

    public void setGlobalAwayTeamID(int globalAwayTeamID) {
        this.globalAwayTeamID = globalAwayTeamID;
    }*/
}



