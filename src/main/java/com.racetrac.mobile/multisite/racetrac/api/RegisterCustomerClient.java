package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_ENDPOINT;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_SUBSCRIPTION_KEY;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_USERS;

@Component
public class RegisterCustomerClient extends HttpClient {

    public CustomerDto registerAccount(CustomerDto customerDto) {
        Request registerRequest = new Request.Builder()
                .url(API_ENDPOINT+API_USERS)
                .addHeader("Ocp-Apim-Subscription-Key", API_SUBSCRIPTION_KEY)
               // .addHeader("Content-Type", "application/json")
                .post(createRequestBody(getGson().toJson(customerDto)))
                .build();
        checkSuccessResponse(registerRequest);

        return customerDto;
    }


}
