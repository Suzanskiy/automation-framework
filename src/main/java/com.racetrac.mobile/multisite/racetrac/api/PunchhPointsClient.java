package com.racetrac.mobile.multisite.racetrac.api;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request.PucnhhUserRequestDto;
import com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request.PunchUserDTO;
import com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.request.PunchhRedeemPointsDto;
import com.racetrac.mobile.multisite.racetrac.dto.responses.punchh.response.CustomerLoginResponseDto;
import lombok.SneakyThrows;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;

import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.ADMIN_SECRET;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.LOGIN_ENDPOINT;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.PUNCHH_URL;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.PUNCH_CLIENT_ID;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.SECRET;
import static com.racetrac.mobile.multisite.racetrac.api.UrlUtils.SUPPORT_ENDPOINT;

@Component
public class PunchhPointsClient extends HttpClient {
    private static final Logger LOG = LoggerFactory.getLogger(PunchhPointsClient.class);

    public void addRedeemPoints(CustomerDto customerDto, int amountOfPoints) {
        Integer punchCustomerID = requestCustomerId(customerDto); // the hardest part, require generating sign header. Returns user id
        String bodyString = generateSupportRequestBody(punchCustomerID, amountOfPoints); // request body to punchh with points amount

        Request idRequest = new Request.Builder()
                .url(PUNCHH_URL + SUPPORT_ENDPOINT)
                .addHeader("Authorization", "Bearer " + ADMIN_SECRET)
                .post(createRequestBody(bodyString))
                .build();
        final Response response = checkCreatedResponse(idRequest);
    }

    private String generateSupportRequestBody(final Integer punchhCustomerId, final int amountOfPoints) {
        final PunchhRedeemPointsDto redeemPointsDto = PunchhRedeemPointsDto.builder()
                .user_id(punchhCustomerId)
                .subject("Automation tests")
                .message("Take points in amount " + amountOfPoints)
                .gift_reason("Do we need any reason for this good boy?")
                .gift_count(amountOfPoints).build();
        return getGson().toJson(redeemPointsDto);
    }


    private Integer requestCustomerId(CustomerDto customerDto) {

        final String json = getJson(customerDto);
        final RequestBody requestBody = createRequestBody(json);
        final String URI = PUNCHH_URL + LOGIN_ENDPOINT + "?client=" + PUNCH_CLIENT_ID;

        final String signatureHeader = calculateSignature(json, LOGIN_ENDPOINT + "?client=" + PUNCH_CLIENT_ID);

        Request idRequest = new Request.Builder()
                .url(URI)
                .addHeader("x-pch-digest", signatureHeader)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Timezone", "Etc/UTC")
                .addHeader("Accept-Language", "en")
                .post(requestBody)
                .build();
        final Response response = checkSuccessResponse(idRequest);
        return extractId(response);
    }

    private String getJson(final CustomerDto customerDto) {
        return getCredentials(customerDto);
    }

    @SneakyThrows
    private String calculateSignature(final String requestBody, final String uri) {
        String data = uri + requestBody;
        return encodeHmacSha256(data);
    }

    private Integer extractId(final Response response) {
        final CustomerLoginResponseDto responseDto = getGson().fromJson(convertResponseToString(response), CustomerLoginResponseDto.class);
        return responseDto.getUser().getUser_id();
    }

    private String getCredentials(final CustomerDto customerDto) {
        PucnhhUserRequestDto userCredentials = new PucnhhUserRequestDto(
                new PunchUserDTO(
                        customerDto.getPersonalInfo().getEmail(),
                        customerDto.getEmailAuth().getPassword())

        );
        return getGson().toJson(userCredentials);
    }

    private String encodeHmacSha256(String data) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");

        // get an hmac_sha1 Mac instance and initialize with the signing key
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        // compute the hmac on input data bytes
        byte[] rawHmac = mac.doFinal(data.getBytes());
        return toHexString(rawHmac);
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }
}
