package com.racetrac.mobile.multisite.racetrac.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.racetrac.mobile.framework.Configuration;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_SUBSCRIPTION_KEY;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public abstract class HttpClient {

  private static final String token =
      "3:Fz88arXPu1w4mtDMTRW/gg==:D++TkjVoUtnoNBYtFoCO5UahR2VYLtIjXGV2E7gC8UpVXCBw9j7t2MdM9MykXJb/rRdzjQoKhG3p1RwYiF7pkWjtm2U8bHrnM4q05/m6cxze22sc1LXglhIVhuDKwqunSeV7bf5jPHXOxdku++g/SNgFy5nXHnl+djY1ST9mumZ4ygS/w08aabEu0jfqz1sbFCuVdhp+ihLpVU88jK9sTnPN1U6TreYWJCrwe/fqbJwmQgkjuK0BwPcN0EpcqHA9z0o3wlNj4HX73e/lh8r/dDZyvo4/wCQ4m5zdEdCaSjDuXHj8GmH4m6j6kyHz/JV2QAo3juj2WEXq2577g0KFVNfO4hDS/2RGbgx8lALaEWDCFghe2Z3oequ9gYSYS0LM:K4GEsQXJmnBVHGNTDCG5pdj/Ya4XdnWU9KXg/OBujts=";
  protected final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  protected final MediaType TEXT_RAW = MediaType.parse("text/plain");
  protected Logger LOGGER;
  private Gson gson;

  public Headers getRequiredHttpHeaders() {
    return new Headers.Builder()
        .add("Ocp-Apim-Subscription-Key", API_SUBSCRIPTION_KEY)
        .add("X-Platform", Configuration.getProfile())
        .add("x-d-token", token)
        .build();
  }

  private static OkHttpClient okHttpClient;

  public HttpClient() {
    this.LOGGER = Logger.getLogger("API_client");
    gson = new GsonBuilder().create();
  }

  public Gson getGson() {
    return gson;
  }

  protected OkHttpClient getHttpClient() {
    try {
      // Create a trust manager that does not validate certificate chains
      final TrustManager[] trustAllCerts =
          new TrustManager[] {
            new X509TrustManager() {
              @Override
              public void checkClientTrusted(
                  java.security.cert.X509Certificate[] chain, String authType)
                  throws CertificateException {}

              @Override
              public void checkServerTrusted(
                  java.security.cert.X509Certificate[] chain, String authType)
                  throws CertificateException {}

              @Override
              public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
              }
            }
          };

      // Install the all-trusting trust manager
      final SSLContext sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
      // Create an ssl socket factory with our all-trusting manager
      final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
      builder.hostnameVerifier(
          new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
              return true;
            }
          });

      OkHttpClient okHttpClient =
          builder
              .connectTimeout(10, TimeUnit.SECONDS)
              .writeTimeout(10, TimeUnit.SECONDS)
              .readTimeout(30, TimeUnit.SECONDS)
              .build();
      return okHttpClient;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
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
      LOGGER.info("Failure request execution: " + exception.getLocalizedMessage());
    }
    System.out.println(response);
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
    assertEquals(
        "Status code is not 204.", HTTP_NO_CONTENT, Objects.requireNonNull(response).code());
    return response;
  }
}
