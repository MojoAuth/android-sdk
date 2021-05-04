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
import com.mojoauth.android.models.responsemodels.EmailResponse;
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
    public void loginByMagicLink(String email, final AsyncHandler<EmailResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        JsonObject bodyParameters = new JsonObject(); //Required
        String resourcePath = "users/magiclink";

        if (!MojoAuthValidator.isNullOrWhiteSpace(email)) {

            bodyParameters.addProperty("email", email);
        }

        MojoAuthRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<EmailResponse> typeToken = new TypeToken<EmailResponse>() {
                };
                EmailResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
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
    public void loginByEmailOTP(String email, final AsyncHandler<EmailResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        JsonObject bodyParameters = new JsonObject(); //Required
        String resourcePath = "users/emailotp";

        if (!MojoAuthValidator.isNullOrWhiteSpace(email)) {

            bodyParameters.addProperty("email", email);
        }

        MojoAuthRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<EmailResponse> typeToken = new TypeToken<EmailResponse>() {
                };
                EmailResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
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
     * @param handler the handler
     */
    public void verifyEmailOTP(String otp, final AsyncHandler<UserResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        String resourcePath = "users/emailotp/verify";

        if (!MojoAuthValidator.isNullOrWhiteSpace(otp)) {

            queryParameters.put("otp", otp);
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
     * @param guid The id
     * @param handler The handler
     */
    public void pingStatus(String guid, final AsyncHandler<UserResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        String resourcePath = "users/status";

        if (!MojoAuthValidator.isNullOrWhiteSpace(guid)) {

            queryParameters.put("guid", guid);
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
     * @param accessToken The accessToken
     * @param handler The handler
     */
    public void verifyAccessToken(String accessToken, final AsyncHandler<VerifyTokenResponse> handler) {

        Map<String, String> queryParameters = new HashMap<String, String>();
        String resourcePath = "token/verify";

        if (!MojoAuthValidator.isNullOrWhiteSpace(accessToken)) {

            queryParameters.put("access_token", accessToken);
        }

        MojoAuthRequest.execute("GET", resourcePath, queryParameters,null, new AsyncHandler<String>() {

            @Override
            public void onSuccess(String response) {
                TypeToken<VerifyTokenResponse> typeToken = new TypeToken<VerifyTokenResponse>() {
                };
                VerifyTokenResponse successResponse = JsonDeserializer.deserializeJson(response, typeToken);
                handler.onSuccess(successResponse);
            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                handler.onFailure(errorResponse);
            }
        });
    }






}
