package com.example.cooper.baseballbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cooper.baseballbuddy.models.NewsModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Async;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class newsActivity extends AppCompatActivity {
    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //textView = (TextView)findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.lvNews);
     //   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       //     @Override
         //   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse());
           //     startActivity(intent);
           // }
        //});
        //new JSONTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
        // new JSONTask().execute("https://api.fantasydata.net/mlb/v2/{format}/News");
        //new JSONTask().execute("http://api.sportradar.us/nfl-ot1/seasontd/2016/standings.json?api_key=wq5x2k2pjfrhatkkb3hhftfe");
        new JSONTask2().execute("https://api.fantasydata.net/mlb/v2/JSON/News");

    }

    public class JSONTask2 extends AsyncTask<String, String, List<NewsModel>> {
        @Override
        protected List<NewsModel> doInBackground(String... params) {
            BufferedReader reader = null;
            HttpURLConnection connect = null;
            HttpURLConnection huc = null;
            String result = "";
            try {
                URL url = new URL(params[0]);
                huc = (HttpURLConnection) url.openConnection();
                huc.setRequestProperty("Ocp-Apim-Subscription-Key", "01fb8861e5e8434891609c4f6277a72b");
                huc.connect();
                InputStream stream1 = huc.getInputStream();


                reader = new BufferedReader(new InputStreamReader(stream1));


                reader = new BufferedReader(new InputStreamReader(stream1));
                StringBuffer buffer1 = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer1.append(line);
                }

                String finalJson = buffer1.toString();
                StringBuffer finalBuffer = new StringBuffer();
                List<NewsModel> newsModelList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(finalJson);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject finalObject = jsonArray.getJSONObject(i);
                    NewsModel newsModel = new NewsModel();

                    newsModel.setNewsID(finalObject.getInt("NewsID"));
                    newsModel.setTitle(finalObject.getString("Title"));
                    newsModel.setUpdated(finalObject.getString("Updated"));
                    newsModel.setUrl(finalObject.getString("Url"));
                    newsModel.setContent(finalObject.getString("Content"));
                    newsModel.setSource(finalObject.getString("Source"));
                    newsModel.setTermsOfUse(finalObject.getString("TermsOfUse"));
                    newsModel.setPlayerID(finalObject.getInt("PlayerID"));
                    newsModel.setTeamID(finalObject.getInt("TeamID"));
                    newsModel.setTeam(finalObject.getString("Team"));

                    newsModelList.add(newsModel);

                }

                return newsModelList;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (huc != null) {
                    huc.disconnect();
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
        protected void onPostExecute(List<NewsModel> result) {
            super.onPostExecute(result);
            NewsAdapter adapter = new NewsAdapter(getApplicationContext(), R.layout.row, result);
            listView.setAdapter(adapter);
            // textView.setText(result);
        }
    }
        public class NewsAdapter extends ArrayAdapter{
            private List<NewsModel> newsModelList;
            private int resource;
            private LayoutInflater inflater;
            public NewsAdapter(Context context, int resource, List<NewsModel> objects) {
                super(context, resource, objects);
                newsModelList = objects;
                this.resource = resource;
                inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null){
                    convertView = inflater.inflate(resource,null);
                }
                TextView Headline;
                TextView Content;

                Content = (TextView)convertView.findViewById(R.id.tvContent);
                Headline = (TextView)convertView.findViewById(R.id.tvHeadline);


                Headline.setText(newsModelList.get(position).getTitle());
                Content.setText(newsModelList.get(position).getContent());
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsModelList.get(position).getUrl()));
                        startActivity(intent);
                    }
                });
                return convertView;
            }
        }
    }//


