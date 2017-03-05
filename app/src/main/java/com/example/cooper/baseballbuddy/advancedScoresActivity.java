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
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cooper on 2/28/2017.
 */

public class advancedScoresActivity extends AppCompatActivity {

    //logoMap test = new logoMap();
   // HashMap<String,String> logos = test.getLogoMap();
    HashMap<Integer,String> logoMap = new HashMap<Integer, String>();



    TextView homeTeamName;
    TextView awayTeamName;
    TextView homeScore;
    TextView awayScore;
    ImageView homeLogo;
    ImageView awayLogo;
    Bitmap bitmapHome;
    Bitmap bitmapAway;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        initializeLogos(logoMap);
        String gameID;
        int globalAwayID=0;
        int globalHomeID=0;
        setContentView(R.layout.activity_advanced_scores);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gameID = extras.getString("GameID");//taking gameID from the previous activity to concatenate with boxScoreURL to fetch fields
            globalAwayID = extras.getInt("GlobalAwayTeamID");
            globalHomeID = extras.getInt("GlobalHomeTeamID");

            //The key argument here must match that used in the other activity
        }
        else
        {
            gameID = null;
            globalAwayID = 0;
            globalHomeID=0;
        }
        String boxScoreURL = "https://api.fantasydata.net/mlb/v2/JSON/BoxScore/"+gameID;
        super.onCreate(savedInstanceState);
        new Matchup().execute(boxScoreURL);
        new getTeamData().execute("https://api.fantasydata.net/mlb/v2/JSON/AllTeams");
        homeTeamName = (TextView)findViewById(R.id.homeTeamName);
        awayTeamName = (TextView)findViewById(R.id.awayTeamName);
         homeScore = (TextView)findViewById(R.id.homeScore);
         awayScore = (TextView)findViewById(R.id.awayScore);
         homeLogo = (ImageView)findViewById(R.id.homeLogoImageView);
         awayLogo = (ImageView)findViewById(R.id.awayLogoImageView);


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
                //ScoresAdapter adapter = new ScoresAdapter(getApplicationContext(), R.layout.score_row, result);
                for(int i = 0; i < result.size(); i++)
                {
                    if (result.get(i).isHomeTeam())
                    {
                        new DownloadImageTask((ImageView) findViewById(R.id.homeLogoImageView))
                             .execute(result.get(i).getWikipediaLogoUrl());
                        homeTeamName.setText(result.get(i).getName());

                       // bitmapHome = getBitmapFromURL(result.get(i).getWikipediaLogoUrl());
                       // homeLogo.setImageBitmap(bitmapHome);
                    }
                    else if (result.get(i).isAwayTeam())
                    {
                        new DownloadImageTask((ImageView) findViewById(R.id.awayLogoImageView))
                                .execute(result.get(i).getWikipediaLogoUrl());
                        awayTeamName.setText(result.get(i).getName());

                    }
                }
               // homeLogo.setImageBitmap(bitmapHome);
               // awayLogo.setImageBitmap(bitmapAway);
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


                int awayTeamID = finalObject.getInt("AwayTeamID");
                int homeTeamID = finalObject.getInt("HomeTeamID");
                setAwayID(awayTeamID);
                setHomeID(homeTeamID);
                List<boxScoreModel> boxScoreModelList = new ArrayList<>();
                //JSONArray jsonArray = new JSONArray(finalJSON);
                //for (int i = 0; i < jsonArray.length(); i++) { I dont think a loop is needed

                    JSONObject finalJSONObject = new JSONObject();
                    boxScoreModel boxScoreModelObject = new boxScoreModel();
                    boxScoreModelObject.setAwayTeamID(awayTeamID);
                    boxScoreModelObject.setHomeTeamID(homeTeamID);
                    boxScoreModelObject.setAwayScore(finalObject.getInt("AwayTeamRuns"));
                    boxScoreModelObject.setHomeScore(finalObject.getInt("HomeTeamRuns"));
                    boxScoreModelList.add(boxScoreModelObject);
                    return boxScoreModelObject;
               // }
               // return boxScoreModelList;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }/* catch (JSONException e) {
                e.printStackTrace();
            }*/ catch (JSONException e) {
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
               // ScoresAdapter adapter = new ScoresAdapter(getApplicationContext(), R.layout.score_row, result);
              //  homeTeamName.setText(result.get(0).getHomeTeamID()+"");
                //awayTeamName.setText(result.get(0).getAwayTeamID()+"");
                //homeTeamName.setText(getHomeID()+"");
               // awayTeamName.setText(getAwayID()+"");
                homeScore.setText(result.getHomeScore()+"");
                awayScore.setText(result.getAwayScore()+"");

              //  homeScore.setText(result.get(0).getHomeScore()+"");
              //  awayScore.setText(result.get(0).getAwayScore()+"");
            }
            else{
                Toast.makeText(getApplicationContext(),"Not able to fetch data.", Toast.LENGTH_LONG).show();
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
    public void initializeLogos(HashMap<Integer,String> given)
    { //Logos have to be in a certain format... ie can't use an SVG.
        // hashmap holds links to all of the team logos, which are then set in ImageViews
        given.put(10000002,"http://i.imgur.com/Oyv9uDi.png");
        given.put(10000003,)
        given.put(10000004,)
        given.put(10000005,)
        given.put(10000006,)
        given.put(10000007,)
        given.put(10000008,)
        given.put(10000009,)
        given.put(10000010,)
        given.put(10000011,)
        given.put(10000012,)
        given.put(10000013,)
        given.put(10000014,)
        given.put(10000015,)
        given.put(10000016,)
        given.put(10000017,)
        given.put(10000018,)
        given.put(10000019,)
        given.put(10000020,)
        given.put(10000021,)
        given.put(10000022,)
        given.put(10000023,)
        given.put(10000024,)
        given.put(10000025,)
        given.put(10000026,)
        given.put(10000027,)
        given.put(10000028,)
        given.put(10000029,)
        given.put(10000030,)
        given.put(10000031,)
        given.put(10000032,)
        given.put(10000033,)
        given.put(10000034,)
        given.put(10000035,)
        given.put(10000036,)


    }
}