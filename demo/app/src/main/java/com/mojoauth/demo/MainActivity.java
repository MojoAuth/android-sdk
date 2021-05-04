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
        initialize.setApiKey("0acf3b89-102d-486a-84ab-1bf5cee42d1b");
        doLogin("addm");

    }

    Gson gson =new Gson();
    public void doLogin(String access_token) {
        MojoAuthApi api = new MojoAuthApi();
        api.verifyAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZGVudGlmaWVyIjoiYXNoaXNoLnNoYXJtYUBsb2dpbnJhZGl1cy5jb20iLCJhdXRoX3R5cGUiOiJtYWdpY2xpbmsiLCJhdWQiOiIwYWNmM2I4OS0xMDJkLTQ4NmEtODRhYi0xYmY1Y2VlNDJkMWIiLCJleHAiOjE2MjM2MjY2MTcsImp0aSI6ImQwNmVlZTkzLWZmMTQtNDM4NC1iOTUwLWVmNWM3YjRkMGJmYSIsImlhdCI6MTYxOTY4NjQxNywiaXNzIjoiaHR0cHM6Ly93d3cubW9qb2F1dGguY29tIiwibmJmIjoxNjE5Njg2NDE3LCJzdWIiOiIyN2ZjNzU5Mi1hNzUwLTQyZTAtYjIzMy1iMjI3NTNiYjQ0ZWQifQ.D44SkCVdwHurybDBDS7buo6Pti_J9XhaiPL_iLeAFkk", new AsyncHandler<VerifyTokenResponse>() {
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
