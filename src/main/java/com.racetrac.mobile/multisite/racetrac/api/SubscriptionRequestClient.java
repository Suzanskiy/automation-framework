package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.subscription.CardDto;
import com.racetrac.mobile.multisite.racetrac.dto.subscription.ExpDto;
import com.racetrac.mobile.multisite.racetrac.dto.subscription.PaymentMethodDto;
import com.racetrac.mobile.multisite.racetrac.dto.subscription.SubscriptionDto;
import okhttp3.Request;
import org.apache.http.HttpHeaders;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_LOYALTY_SUBSCRIPTION_ENDPOINT;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.API_URL;

@Component
public class SubscriptionRequestClient extends HttpClient {
    public void requestDefaultSubscriptionPlan(CustomerDto customerDto) {
        Request registerRequest = new Request.Builder()
                .url(API_URL + API_LOYALTY_SUBSCRIPTION_ENDPOINT)
                .headers(getRequiredHttpHeaders())
                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer "+customerDto.getAccessToken())
                .post(createRequestBody(getGson().toJson(getDefaultSubscriptionBody())))
                .build();
        checkSuccessResponse(registerRequest);
    }

    private SubscriptionDto getDefaultSubscriptionBody() {

        return SubscriptionDto.builder()
                .programId("10")
                .essentialWorker(false)
                .paymentMethod(getDefaultPaymentMethod()).build();
    }

    private PaymentMethodDto getDefaultPaymentMethod() {
        return PaymentMethodDto.builder()
                .card(new CardDto("444444", "visa", new ExpDto("01", "23"),
                        "4449", "XXXXXXXXXXXX4444", "AP TEST 2", "2537446225198293")
                ).build();
    }
}
