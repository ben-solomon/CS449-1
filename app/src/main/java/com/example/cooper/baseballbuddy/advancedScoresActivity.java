package com.example.cooper.baseballbuddy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooper.baseballbuddy.models.advancedScoresModel;
import com.example.cooper.baseballbuddy.models.boxScoreModel;
import com.example.cooper.baseballbuddy.models.inningModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cooper on 2/28/2017.
 */

public class advancedScoresActivity extends AppCompatActivity {

    TextView homeTeamName;
    TextView awayTeamName;
    TextView homeScore;
    TextView awayScore;
    TextView homeInning1;// Used to display box score at bottom of activity
    TextView homeInning2;
    TextView homeInning3;
    TextView homeInning4;
    TextView homeInning5;
    TextView homeInning6;
    TextView homeInning7;
    TextView homeInning8;
    TextView homeInning9;
    TextView awayInning1;
    TextView awayInning2;
    TextView awayInning3;
    TextView awayInning4;
    TextView awayInning5;
    TextView awayInning6;
    TextView awayInning7;
    TextView awayInning8;
    TextView awayInning9;


    ImageView homeLogo;
    ImageView awayLogo;
    Bitmap bitmapHome;
    Bitmap bitmapAway;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        String awayURL="";
        String homeURL="";
        String gameID;

        setContentView(R.layout.activity_advanced_scores);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gameID = extras.getString("GameID");//taking gameID from the previous activity to concatenate with boxScoreURL to fetch fields
            awayURL = extras.getString("AwayTeamLogoURL");
            homeURL = extras.getString("HomeTeamLogoURL");

        }
        else
        {
            gameID = null;
        }
        String boxScoreURL = "https://api.fantasydata.net/mlb/v2/JSON/BoxScore/"+gameID;
        super.onCreate(savedInstanceState);
        new Matchup().execute(boxScoreURL);
        new getTeamData().execute("https://api.fantasydata.net/mlb/v2/JSON/AllTeams");
        new inningScores().execute(boxScoreURL);

        homeTeamName = (TextView)findViewById(R.id.homeTeamName);
        awayTeamName = (TextView)findViewById(R.id.awayTeamName);
         homeScore = (TextView)findViewById(R.id.homeScore);
         awayScore = (TextView)findViewById(R.id.awayScore);
         homeLogo = (ImageView)findViewById(R.id.homeLogoImageView);
         awayLogo = (ImageView)findViewById(R.id.awayLogoImageView);
        new DownloadImageTask((ImageView) findViewById(R.id.homeLogoImageView))
                .execute(homeURL);
        new DownloadImageTask((ImageView) findViewById(R.id.awayLogoImageView))
                .execute(awayURL);


    }
    public class getTeamData extends AsyncTask<String, String, List<advancedScoresModel>> {
        @Override
        protected List<advancedScoresModel> doInBackground(String... params) {
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
                String gameID = null;
                int globalAwayID = 0;
                int globalHomeID=0;
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                     globalAwayID = extras.getInt("GlobalAwayTeamID");
                     globalHomeID = extras.getInt("GlobalHomeTeamID");

                }

                String finalJSON = buffer.toString();
                List<advancedScoresModel> advancedScoresModelList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(finalJSON);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject finalJSONObject = jsonArray.getJSONObject(i);
                    advancedScoresModel advancedScoresModelObject = new advancedScoresModel();

                    advancedScoresModelObject.setTeamID(finalJSONObject.getInt("TeamID"));
                    advancedScoresModelObject.setCity(finalJSONObject.getString("City"));
                    advancedScoresModelObject.setName(finalJSONObject.getString("Name"));
                   // advancedScoresModelObject.setWikipediaLogoUrl(finalJSONObject.getString("WikipediaLogoUrl"));
                    // using imgur link below to test if it can be read
                    advancedScoresModelObject.setWikipediaLogoUrl("http://i.imgur.com/Oyv9uDi.png");
                    advancedScoresModelObject.setGlobalID(finalJSONObject.getInt("GlobalTeamID"));
                    if (advancedScoresModelObject.getGlobalID() == globalAwayID)
                    {
                        advancedScoresModelObject.setAwayTeam(true);
                        bitmapAway = getBitmapFromURL(advancedScoresModelObject.getWikipediaLogoUrl());

                        // assign the correct logo
                    }
                    if (advancedScoresModelObject.getGlobalID() == globalHomeID)
                    {
                        advancedScoresModelObject.setHomeTeam(true);

                        bitmapHome = getBitmapFromURL(advancedScoresModelObject.getWikipediaLogoUrl());

                        // assign the correct logo
                    }

                    advancedScoresModelList.add(advancedScoresModelObject);

                }
                return advancedScoresModelList;
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
        protected void onPostExecute(List<advancedScoresModel> result) {
            super.onPostExecute(result);
            if (result != null){
                for(int i = 0; i < result.size(); i++)
                {
                    if (result.get(i).isHomeTeam())
                    {
                        homeTeamName.setText(result.get(i).getName());

                    }
                    else if (result.get(i).isAwayTeam())
                    {
                        awayTeamName.setText(result.get(i).getName());
                    }
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Not able to fetch data.", Toast.LENGTH_LONG).show();
            }


        }
    }
    public Bitmap getBitmapFromURL(String source)
    {
        try{
            URL url = new URL(source);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public class inningScores extends AsyncTask<String,String,List<inningModel>>{
        protected List<inningModel> doInBackground(String... params) {
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
                JSONObject parentObject = new JSONObject(finalJSON);

                JSONArray boxScoreArray = parentObject.getJSONArray("Innings");
                List<inningModel> inningModelList = new ArrayList<>();

                for (int i = 0; i < boxScoreArray.length(); i++)
                {
                    JSONObject inningObject = boxScoreArray.getJSONObject(i);
                    inningModel inningModelObject = new inningModel();
                    inningModelObject.setInningID(inningObject.getInt("InningID"));
                    inningModelObject.setGameID(inningObject.getInt("GameID"));
                    inningModelObject.setInningNumber(inningObject.getInt("InningNumber"));
                    inningModelObject.setAwayTeamRunsThisInning(inningObject.getInt("AwayTeamRuns"));
                    inningModelObject.setHomeTeamRunsThisInning(inningObject.getInt("HomeTeamRuns"));
                    inningModelList.add(inningModelObject);


                }


                return inningModelList;


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
        protected void onPostExecute(List<inningModel> result) {
            super.onPostExecute(result);
            if (result != null){ // currently hardcoding the small inning by inning scores until I can think of a better alternative
                homeInning1 = (TextView)findViewById(R.id.first);
                homeInning1.setText(result.get(0).getHomeTeamRunsThisInning()+"");
                homeInning2 = (TextView)findViewById(R.id.second);
                homeInning2.setText(result.get(1).getHomeTeamRunsThisInning()+"");
                homeInning3 = (TextView)findViewById(R.id.third);
                homeInning3.setText(result.get(2).getHomeTeamRunsThisInning()+"");
                homeInning4 = (TextView)findViewById(R.id.fourth);
                homeInning4.setText(result.get(3).getHomeTeamRunsThisInning()+"");
                homeInning5 = (TextView)findViewById(R.id.fifth);
                homeInning5.setText(result.get(4).getHomeTeamRunsThisInning()+"");
                homeInning6 = (TextView)findViewById(R.id.sixth);
                homeInning6.setText(result.get(5).getHomeTeamRunsThisInning()+"");
                homeInning7 = (TextView)findViewById(R.id.seventh);
                homeInning7.setText(result.get(6).getHomeTeamRunsThisInning()+"");
                homeInning8 = (TextView)findViewById(R.id.eighth);
                homeInning8.setText(result.get(7).getHomeTeamRunsThisInning()+"");
                homeInning9 = (TextView)findViewById(R.id.ninth);
                homeInning9.setText(result.get(8).getHomeTeamRunsThisInning()+"");

                awayInning1 = (TextView)findViewById(R.id.awayFirst);
                awayInning1.setText(result.get(0).getAwayTeamRunsThisInning()+"");
                awayInning2 = (TextView)findViewById(R.id.awaySecond);
                awayInning2.setText(result.get(1).getAwayTeamRunsThisInning()+"");
                awayInning3 = (TextView)findViewById(R.id.awayThird);
                awayInning3.setText(result.get(2).getAwayTeamRunsThisInning()+"");
                awayInning4 = (TextView)findViewById(R.id.awayFourth);
                awayInning4.setText(result.get(3).getAwayTeamRunsThisInning()+"");
                awayInning5 = (TextView)findViewById(R.id.awayFifth);
                awayInning5.setText(result.get(4).getAwayTeamRunsThisInning()+"");
                awayInning6 = (TextView)findViewById(R.id.awaySixth);
                awayInning6.setText(result.get(5).getAwayTeamRunsThisInning()+"");
                awayInning7 = (TextView)findViewById(R.id.awaySeventh);
                awayInning7.setText(result.get(6).getAwayTeamRunsThisInning()+"");
                awayInning8 = (TextView)findViewById(R.id.awayEighth);
                awayInning8.setText(result.get(7).getAwayTeamRunsThisInning()+"");
                awayInning9 = (TextView)findViewById(R.id.awayNinth);
                awayInning9.setText(result.get(8).getAwayTeamRunsThisInning()+"");
            }
            else{
                Toast.makeText(getApplicationContext(),"Not able to fetch data1.", Toast.LENGTH_LONG).show();
            }
        }

    }
    public class Matchup extends AsyncTask<String, String, boxScoreModel> {
        private int awayID;
        private int homeID;


        public int getAwayID() {
            return awayID;
        }

        public void setAwayID(int awayID) {
            this.awayID = awayID;
        }

        public int getHomeID() {
            return homeID;
        }

        public void setHomeID(int homeID) {
            this.homeID = homeID;
        }

        @Override
        protected boxScoreModel doInBackground(String... params) {
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
                JSONObject parentObject = new JSONObject(finalJSON);
                JSONObject finalObject = parentObject.getJSONObject("Game");
                //JSONObject inningArrayObject = parentObject.getJSONObject("Innings");
                int awayTeamID = finalObject.getInt("AwayTeamID");
                int homeTeamID = finalObject.getInt("HomeTeamID");
                setAwayID(awayTeamID);
                setHomeID(homeTeamID);
                List<boxScoreModel> boxScoreModelList = new ArrayList<>();

                boxScoreModel boxScoreModelObject = new boxScoreModel();
                boxScoreModelObject.setAwayTeamID(awayTeamID);
                boxScoreModelObject.setHomeTeamID(homeTeamID);
                boxScoreModelObject.setAwayScore(finalObject.getInt("AwayTeamRuns"));
                boxScoreModelObject.setHomeScore(finalObject.getInt("HomeTeamRuns"));
                boxScoreModelList.add(boxScoreModelObject);



               /* JSONArray boxScoreArray = parentObject.getJSONArray("Innings");
                List<inningModel> inningModelList = new ArrayList<>();

                for (int i = 0; i < boxScoreArray.length(); i++)
                {
                    JSONObject inningObject = boxScoreArray.getJSONObject(i);
                    inningModel inningModelObject = new inningModel();
                    inningModelObject.setInningID(inningObject.getInt("InningID"));
                    inningModelObject.setGameID(inningObject.getInt("GameID"));
                    inningModelObject.setInningNumber(inningObject.getInt("InningNumber"));
                    inningModelObject.setAwayTeamRunsThisInning(inningObject.getInt("AwayTeamRuns"));
                    inningModelObject.setHomeTeamRunsThisInning(inningObject.getInt("HomeTeamRuns"));
                    inningModelList.add(inningModelObject);


                }
                Toast.makeText(getApplicationContext(),"data fetch complete", Toast.LENGTH_LONG).show();
*/
                return boxScoreModelObject;


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
        protected void onPostExecute(boxScoreModel result) {
            super.onPostExecute(result);
            if (result != null){

                homeScore.setText(result.getHomeScore()+"");
                awayScore.setText(result.getAwayScore()+"");

            }
            else{
                Toast.makeText(getApplicationContext(),"Not able to fetch data1.", Toast.LENGTH_LONG).show();
            }
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }



}