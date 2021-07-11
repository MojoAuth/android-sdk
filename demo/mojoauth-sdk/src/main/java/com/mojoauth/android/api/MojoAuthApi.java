package com.mojoauth.android.api;
/*
 *
 * Created by MojoAuth Development Team
   Copyright 2021 MojoAuth Inc. All rights reserved.

 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mojoauth.android.handler.AsyncHandler;
import com.mojoauth.android.handler.JsonDeserializer;
import com.mojoauth.android.handler.MojoAuthRequest;
import com.mojoauth.android.helper.ErrorResponse;
import com.mojoauth.android.helper.MojoAuthSDK;
import com.mojoauth.android.helper.MojoAuthValidator;
import com.mojoauth.android.models.responsemodels.JwksResponse;
import com.mojoauth.android.models.responsemodels.LoginResponse;
import com.mojoauth.android.models.responsemodels.UserResponse;
import com.mojoauth.android.models.responsemodels.VerifyTokenResponse;

import java.util.HashMap;
import java.util.Map;


public class MojoAuthApi {

    Gson gson =new Gson();

    public MojoAuthApi(){
        if(!MojoAuthSDK.validate()){
            throw new MojoAuthSDK.InitializeException();
        }
    }

    /**
     *
     * @param email The email
     * @param handler The handler
     */
    public void loginByMagicLink(String email, final AsyncHandler<LoginResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        JsonObject bodyParameters = new JsonObject(); //Required
        String resourcePath = "users/magiclink";

        if (!MojoAuthValidator.isNullOrWhiteSpace(email)) {

            bodyParameters.addProperty("email", email);
        }

        MojoAuthRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<LoginResponse> typeToken = new TypeToken<LoginResponse>() {
                };
                LoginResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }
    /**
     *
     * @param email The email
     * @param handler The handler
     */
    public void loginByEmailOTP(String email, final AsyncHandler<LoginResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        JsonObject bodyParameters = new JsonObject(); //Required
        String resourcePath = "users/emailotp";

        if (!MojoAuthValidator.isNullOrWhiteSpace(email)) {

            bodyParameters.addProperty("email", email);
        }

        MojoAuthRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<LoginResponse> typeToken = new TypeToken<LoginResponse>() {
                };
                LoginResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }

    /**
     *
     * @param otp The otp
     * @param stateId The id
     * @param handler the handler
     */
    public void verifyEmailOTP(String otp,String stateId,final AsyncHandler<UserResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        JsonObject bodyParameters = new JsonObject(); //Required
        String resourcePath = "users/emailotp/verify";

        if (!MojoAuthValidator.isNullOrWhiteSpace(otp)) {

            bodyParameters.addProperty("otp", otp);
        }

        if (!MojoAuthValidator.isNullOrWhiteSpace(stateId)) {

            bodyParameters.addProperty("state_id", stateId);
        }

        MojoAuthRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<UserResponse> typeToken = new TypeToken<UserResponse>() {
                };
                UserResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }

    /**
     *
     * @param stateId The id
     * @param handler The handler
     */
    public void pingStatus(String stateId, final AsyncHandler<UserResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        String resourcePath = "users/status";

        if (!MojoAuthValidator.isNullOrWhiteSpace(stateId)) {

            queryParameters.put("state_id", stateId);
        }

        MojoAuthRequest.execute("GET", resourcePath, queryParameters,null, new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<UserResponse> typeToken = new TypeToken<UserResponse>() {
                };
                UserResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }


    /**
     *
     * @param handler The handler
     */
    public void getJWKS(final AsyncHandler<JwksResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        String resourcePath = "token/jwks";


        MojoAuthRequest.execute("GET", resourcePath, queryParameters,null, new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<JwksResponse> typeToken = new TypeToken<JwksResponse>() {
                };
                JwksResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }






}
