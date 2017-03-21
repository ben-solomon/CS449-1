package com.example.cooper.baseballbuddy;

/**
 * Created by Cooper1 on 3/17/2017.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://efferent-meat.000webhostapp.com/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String password, String username, String favoriteTeam1ID, String favoriteTeam2ID, String favoriteTeam3ID, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("password", password);
        params.put("username", username);
        params.put("favoriteTeam1ID", favoriteTeam1ID);
        params.put("favoriteTeam2ID", favoriteTeam2ID);
        params.put("favoriteTeam3ID", favoriteTeam3ID);

    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
