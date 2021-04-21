package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.util.CommonUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class TestDataImpl implements TestData {
    public static final String EMAIL_DOMAIN = "qateam.com";
    public static final String DEFAULT_PASSWORD = "password123!";
    public static final String DEFAULT_PHONE_NUMBER_PREFIX = "1";
    public static final int CUSTOMER_AGE = 25;
    public static final int DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER = 10;

    @Override
    public CustomerDto generateNewCustomer() {
        return CustomerDto.builder()
                .email(CommonUtils.generateEmail(EMAIL_DOMAIN))
                .password(DEFAULT_PASSWORD)
                .phoneNumber(CommonUtils.generatePhoneNumber(DEFAULT_PHONE_NUMBER_PREFIX,
                        DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER))
                .birthDate(LocalDate.now().minusYears(CUSTOMER_AGE))
                .receivingEmails(new Random().nextBoolean())
                .build();
    }
}