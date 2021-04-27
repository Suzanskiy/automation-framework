package com.racetrac.mobile.multisite.racetrac.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public abstract class HttpClient {

    protected final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    protected final MediaType TEXT_RAW = MediaType.parse("text/plain");
    protected Logger LOGGER;
    private Gson gson;
    public static final String authorization = "Authorization";
    public static final String bearer = "Bearer ";
    public static final String accept = "Accept";

    private static OkHttpClient okHttpClient;

    public HttpClient() {
        this.LOGGER = Logger.getLogger("API_client");
        gson = new GsonBuilder().create();
    }

    public Gson getGson() {
        return gson;
    }

    protected OkHttpClient getHttpClient() {
        if (okHttpClient == null)
            okHttpClient = new OkHttpClient();
        return okHttpClient;
    }

    protected RequestBody createRequestBody(String json) {
        return RequestBody.create(JSON, json);
    }

    public String convertResponseToString(Response response) {
        String responseString = null;
        try {
            responseString = Objects.requireNonNull(response.body()).string();
        } catch (IOException exception) {
            LOGGER.info("Could not convert response body to String");
        }
        return responseString;
    }

    public Response checkSuccessResponse(Request request) {
        Response response = null;
        try {
            response = getHttpClient().newCall(request).execute();
        } catch (IOException exception) {
            LOGGER.info("Failure request execution");
        }
        assertEquals("Request was not executed", HTTP_OK, Objects.requireNonNull(response).code());
        return response;
    }

    public Response checkCreatedResponse(Request request) {
        Response response = null;
        try {
            response = getHttpClient().newCall(request).execute();
        } catch (IOException exception) {
            LOGGER.info("Failure request execution");
        }
        assertEquals("Entity is not created.", HTTP_CREATED, Objects.requireNonNull(response).code());
        return response;
    }

    public Response checkNoContentResponse(Request request) {
        Response response = null;
        try {
            response = getHttpClient().newCall(request).execute();
        } catch (IOException exception) {
            LOGGER.info("Failure request execution");
        }
        assertEquals("Status code is not 204.", HTTP_NO_CONTENT, Objects.requireNonNull(response).code());
        return response;
    }
}