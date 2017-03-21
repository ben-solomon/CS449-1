package com.example.cooper.baseballbuddy.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Cooper1 on 3/9/2017.
 */

public class connection {
    BufferedReader reader = null;
    HttpURLConnection connect = null;
    HttpURLConnection huc = null;

    public String getJSONCallAsString(String givenURL) throws IOException {
        //Trying to create a function to connect and return my API calls for me, not sure if possible
        URL url = new URL(givenURL);
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
        return finalJson;
    }
}
