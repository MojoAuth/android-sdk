package com.mojoauth.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mojoauth.android.api.MojoAuthApi;
import com.mojoauth.android.handler.AsyncHandler;
import com.mojoauth.android.helper.ErrorResponse;
import com.mojoauth.android.helper.MojoAuthSDK;
import com.mojoauth.android.models.responsemodels.VerifyTokenResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MojoAuthSDK.Initialize initialize = new MojoAuthSDK.Initialize();
        initialize.setApiKey("<APIKEY>");
        verifyAccessToken("<Access_Token>");

    }

    Gson gson =new Gson();
    public void verifyAccessToken(String access_token) {
        MojoAuthApi api = new MojoAuthApi();
        api.verifyAccessToken(access_token, new AsyncHandler<VerifyTokenResponse>() {
            @Override
            public void onFailure(ErrorResponse error) {
                Log.d("Success",gson.toJson(error));
            }

            @Override
            public void onSuccess(VerifyTokenResponse data) {
                Log.d("Data",gson.toJson(data));
            }
        });
    }
}
