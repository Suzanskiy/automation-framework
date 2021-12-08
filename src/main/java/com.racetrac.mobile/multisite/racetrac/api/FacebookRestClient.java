package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.data.TestData;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.fb.FBAccessTokenResponseDto;
import com.racetrac.mobile.multisite.racetrac.dto.fb.FBDeleteUserRequestBodyDto;
import com.racetrac.mobile.multisite.racetrac.dto.fb.FBGenerateAccountBodyDto;
import com.racetrac.mobile.multisite.racetrac.dto.fb.FBGenerateUserResponseDto;
import io.qameta.allure.Step;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookRestClient extends HttpClient {

    private static final String FacebookAppId = "480587989138172";
    private static final String FacebookClientSecret = "0dfdfa9e61d3ef5c2fb8aa46dc233cc3";
    @Autowired
    TestData testData;

    @Step
    public CustomerDto generateCustomer() {

        final String token = requestAccessToken();

        final FBGenerateAccountBodyDto body = FBGenerateAccountBodyDto.builder().name("mobile automation").access_token(token).build();

        Request userRequest = new Request.Builder()
                .url("https://graph.facebook.com/v10.0/" + FacebookAppId + "/accounts/test-users")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(createRequestBody(getGson().toJson(body)))
                .build();
        final Response response = checkSuccessResponse(userRequest);
        final FBGenerateUserResponseDto fbUserDto = getFBUserDto(response);

        final CustomerDto customerDto = testData.generateDefaultCustomer();
        customerDto.getPersonalInfo().setEmail(fbUserDto.getEmail());
        customerDto.getEmailAuth().setPassword(fbUserDto.getPassword());
        customerDto.setFb_user_id(fbUserDto.getId());

        return customerDto;
    }

    private FBGenerateUserResponseDto getFBUserDto(final Response response) {
        return getGson().fromJson(convertResponseToString(response), FBGenerateUserResponseDto.class);
    }

    @Step
    public String requestAccessToken() {
        Request tokenRequest = new Request.Builder()
                .url("https://graph.facebook.com/v10.0/oauth/access_token?client_id=" + FacebookAppId + "&client_secret=" + FacebookClientSecret + "&grant_type=client_credentials")
                .get()
                .build();
        final Response response = checkSuccessResponse(tokenRequest);
        return extractAccessToken(response);
    }

    private String extractAccessToken(final Response response) {
        final FBAccessTokenResponseDto responseDto =
                getGson().fromJson(convertResponseToString(response), FBAccessTokenResponseDto.class);
        return responseDto.getAccess_token();
    }

    @Step
    public void deleteUser(final CustomerDto customerDto) {
        final FBDeleteUserRequestBodyDto body = FBDeleteUserRequestBodyDto.builder().access_token(requestAccessToken()).build();

        Request tokenRequest = new Request.Builder()
                .url("https://graph.facebook.com/v10.0/" + customerDto.getFb_user_id())
                .delete(createRequestBody(getGson().toJson(body)))
                .build();
        checkSuccessResponse(tokenRequest);
    }
}
