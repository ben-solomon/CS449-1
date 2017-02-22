package com.example.cooper.baseballbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cooper.baseballbuddy.models.NewsModel;
import com.example.cooper.baseballbuddy.models.ScoresModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 2/21/2017.
 */

public class scoreActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        listView = (ListView) findViewById(R.id.lvScores);
        //call my parse function here, create it just inside of the activity function
        new JSONTask().execute("https://api.fantasydata.net/mlb/v2/JSON/GamesByDate/2015-JUL-31");

    }

    public class JSONTask extends AsyncTask<String, String, List<ScoresModel>> {
        @Override
        protected List<ScoresModel> doInBackground(String... params) {
            BufferedReader reader = null;
            HttpURLConnection connect = null;

            try {
                URL url = new URL(params[0]);
                connect = (HttpURLConnection) url.openConnection();
                connect.setRequestProperty("Ocp-Apim-Subscription-Key", "01fb8861e5e8434891609c4f6277a72b");
                connect.connect();
                InputStream stream = connect.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJSON = buffer.toString();
                List<ScoresModel> scoresModelList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(finalJSON);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject finalJSONObject = jsonArray.getJSONObject(i);
                    ScoresModel scoresModel = new ScoresModel();

                    scoresModel.setGameID(finalJSONObject.getInt("GameID"));
                    scoresModel.setSeason(finalJSONObject.getString("Season"));
                    scoresModel.setSeasonType(finalJSONObject.getInt("SeasonType"));
                    scoresModel.setStatus(finalJSONObject.getString("Status"));
                    scoresModel.setDay(finalJSONObject.getString("Day"));
                    scoresModel.setDateTime(finalJSONObject.getString("DateTime"));
                    scoresModel.setAwayTeam(finalJSONObject.getString("AwayTeam"));
                    scoresModel.setHomeTeam(finalJSONObject.getString("HomeTeam"));
                    scoresModel.setRescheduledGameID(finalJSONObject.getInt("RescheduledGameID"));
                    scoresModel.setStadiumID(finalJSONObject.getInt("StadiumID"));
                    scoresModel.setChannel(finalJSONObject.getInt("Channel"));
                    scoresModel.setInning(finalJSONObject.getInt("Inning"));
                    scoresModel.setInningHalf(finalJSONObject.getString("InningHalf"));
                    scoresModel.setAwayTeamRuns(finalJSONObject.getInt("AwayTeamRuns"));
                    scoresModel.setHomeTeamRuns(finalJSONObject.getInt("HomeTeamRuns"));
                    scoresModel.setHomeTeamHits(finalJSONObject.getInt("HomeTeamHits"));
                    scoresModel.setAwayTeamHits(finalJSONObject.getInt("AwayTeamHits"));
                    scoresModel.setAwayTeamErrors(finalJSONObject.getInt("AwayTeamErrors"));
                    scoresModel.setHomeTeamErrors(finalJSONObject.getInt("HomeTeamErrors"));
                    scoresModel.setWinningPitcherID(finalJSONObject.getInt("WinningPitcherID"));
                    scoresModel.setLosingPitcherID(finalJSONObject.getInt("LosingPitcherID"));
                    scoresModel.setSavingPitcherID(finalJSONObject.getInt("SavingPitcherID"));
                    scoresModel.setAttendance(finalJSONObject.getInt("Attendance"));
                    scoresModel.setAwayTeamStartingPitcherID(finalJSONObject.getInt("AwayTeamStartingPitcherID"));
                    scoresModel.setHomeTeamStartingPitcherID(finalJSONObject.getInt("HomeTeamStartingPitcherID"));
                    scoresModel.setCurrentPitchingTeamID(finalJSONObject.getInt("CurrentPitchingTeamID"));
                    scoresModel.setCurrentHittingTeamID(finalJSONObject.getInt("CurrentHittingTeamID"));
                    scoresModel.setPointSpread(finalJSONObject.getInt("PointSpread"));
                    scoresModel.setOverUnder(finalJSONObject.getInt("OverUnder"));
                    scoresModel.setAwayTeamMoneyLine(finalJSONObject.getInt("AwayTeamMoneyLine"));
                    scoresModel.setHomeTeamMoneyLine(finalJSONObject.getInt("HomeTeamMoneyLine"));
                    scoresModel.setForecastTempLow(finalJSONObject.getInt("ForecastTempLow"));
                    scoresModel.setForecastTempHigh(finalJSONObject.getInt("ForecastTempHigh"));
                    scoresModel.setForecastDescription(finalJSONObject.getString("ForecastDescription"));
                    scoresModel.setForecastWindChill(finalJSONObject.getString("ForecastWindChill"));
                    scoresModel.setForecastWindSpeed(finalJSONObject.getInt("ForecastWindSpeed"));
                    scoresModel.setForecastWindDirection(finalJSONObject.getString("ForecastWindDirection"));
                    scoresModel.setRescheduledFromGameID(finalJSONObject.getInt("RescheduledFromGameID"));
                    scoresModel.setRunnerOnFirst(finalJSONObject.getBoolean("RunnerOnFirst"));
                    scoresModel.setRunnerOnSecond(finalJSONObject.getBoolean("RunnerOnSecond"));
                    scoresModel.setRunnerOnThird(finalJSONObject.getBoolean("RunnerOnThird"));
                    scoresModel.setAwayTeamStartingPitcher(finalJSONObject.getString("AwayTeamStartingPitcher"));
                    scoresModel.setHomeTeamStartingPitcher(finalJSONObject.getString("HomeTeamStartingPitcher"));
                    scoresModel.setCurrentPitcher(finalJSONObject.getString("CurrentPitcher"));
                    scoresModel.setCurrentHitter(finalJSONObject.getString("CurrentHitter"));
                    scoresModel.setWinningPitcher(finalJSONObject.getString("WinningPitcher"));
                    scoresModel.setLosingPitcher(finalJSONObject.getString("LosingPitcher"));
                    scoresModel.setSavingPitcher(finalJSONObject.getString("SavingPitcher"));
                    scoresModel.setDueUpHitterID1(finalJSONObject.getInt("DueUpHitterID1"));
                    scoresModel.setDueUpHitterID2(finalJSONObject.getInt("DueUpHitterID2"));
                    scoresModel.setDueUpHitterID3(finalJSONObject.getInt("DueUpHitterID3"));
                    scoresModel.setGlobalGameID(finalJSONObject.getInt("GlobalGameID"));
                    scoresModel.setGlobalAwayTeamID(finalJSONObject.getInt("GlobalAwayTeamID"));
                    scoresModel.setGlobalHomeTeamID(finalJSONObject.getInt("GlobalHomeTeamID"));

                    scoresModelList.add(scoresModel);

                }
                return scoresModelList;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connect != null) {
                    connect.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ScoresModel> result) {
            super.onPostExecute(result);
            ScoresAdapter adapter = new ScoresAdapter(getApplicationContext(), R.layout.score_row, result);
            listView.setAdapter(adapter);

        }
    }

    public class ScoresAdapter extends ArrayAdapter {
        private List<ScoresModel> scoreModelList;
        private int resource;
        private LayoutInflater inflater;

        public ScoresAdapter(Context context, int resource, List<ScoresModel> objects) {
            super(context, resource, objects);
            scoreModelList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, null);
            }
            TextView homeTeamName;
            TextView awayTeamName;
            TextView homeTeamScore;
            TextView awayTeamScore;
            TextView inningTopBot;
            TextView inningNum;

            homeTeamName = (TextView) convertView.findViewById(R.id.tvHomeTeamName);
            awayTeamName = (TextView) convertView.findViewById(R.id.tvAwayTeamName);
            homeTeamScore = (TextView) convertView.findViewById(R.id.tvHomeTeamScore);
            awayTeamScore = (TextView) convertView.findViewById(R.id.tvAwayTeamScore);
            inningTopBot = (TextView) convertView.findViewById(R.id.tvTopBot);
            inningNum = (TextView) convertView.findViewById(R.id.tvInningNum);


            //originally, content declared as textview like above
            // Content = (TextView)convertView.findViewById(R.id.tvContent);
            //Headline = (TextView)convertView.findViewById(R.id.tvHeadline);
            homeTeamScore.setText(scoreModelList.get(position).getHomeTeamRuns());
            awayTeamScore.setText(scoreModelList.get(position).getAwayTeamRuns());
            inningTopBot.setText(scoreModelList.get(position).getInningHalf());
            inningNum.setText(scoreModelList.get(position).getInning());
            awayTeamName.setText(scoreModelList.get(position).getAwayTeam());
            homeTeamName.setText(scoreModelList.get(position).getHomeTeam());
            //Headline.setText(newsModelList.get(position).getTitle());
            //Content.setText(newsModelList.get(position).getContent());

            //maybe click this element in listview to open up further details?
            /*
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scoreModelList.get(position).getUrl()));
                    startActivity(intent);
                }
            });*/
            return convertView;
        }
    }
}
