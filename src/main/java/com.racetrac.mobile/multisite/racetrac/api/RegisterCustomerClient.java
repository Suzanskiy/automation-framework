package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import okhttp3.Request;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_URL;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_USERS_ENDPOINT;

@Component
public class RegisterCustomerClient extends HttpClient {

    public CustomerDto registerAccount(CustomerDto customerDto) {
        Request registerRequest = new Request.Builder()
                .url(API_URL + API_USERS_ENDPOINT)
                .headers(getRequiredHttpHeaders())
                .post(createRequestBody(getGson().toJson(customerDto)))
                .build();
        checkSuccessResponse(registerRequest);

        return customerDto;
    }


}
