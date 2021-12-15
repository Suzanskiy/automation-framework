package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.responses.RegisterCustomerWithEmailResponseDto;
import io.qameta.allure.Step;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_URL;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_USERS_ENDPOINT;

@Component
public class RegisterCustomerClient extends HttpClient {
    
    @Step
    public CustomerDto registerAccount(CustomerDto customerDto) {
        Request registerRequest = new Request.Builder()
                .url(API_URL + API_USERS_ENDPOINT)
                .headers(getRequiredHttpHeaders())
                .post(createRequestBody(getGson().toJson(customerDto)))
                .build();
        final Response response = checkSuccessResponse(registerRequest);
        customerDto.setAccessToken(extractAccessToken(response));
        return customerDto;
    }

    @Step
    private String extractAccessToken(final Response response) {
        final RegisterCustomerWithEmailResponseDto responseDto =
                getGson().fromJson(convertResponseToString(response), RegisterCustomerWithEmailResponseDto.class);
        return responseDto.getToken().getAccessToken();
    }


}
