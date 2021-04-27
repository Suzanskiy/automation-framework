package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.api.RegisterCustomerClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.EmailAuthDto;
import com.racetrac.mobile.multisite.racetrac.dto.PersonalInfoDto;
import com.racetrac.mobile.multisite.racetrac.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class TestDataImpl implements TestData {

    @Autowired
    RegisterCustomerClient registerCustomerClient;

    public static final String EMAIL_DOMAIN = "qateam.com";
    public static final String DEFAULT_PASSWORD = "password123!";
    public static final String DEFAULT_PHONE_NUMBER_PREFIX = "1";
    public static final int CUSTOMER_AGE = 25;
    public static final int DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER = 10;

    @Override
    public CustomerDto generateNewCustomer() {
        return CustomerDto.builder().personalInfo(
                PersonalInfoDto.builder()
                        .birthday(LocalDate.now().minusYears(CUSTOMER_AGE).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .email(CommonUtils.generateEmail(EMAIL_DOMAIN))
                        .firstName("Automation")
                        .lastName("Engineer")
                        .phone(CommonUtils.generatePhoneNumber(DEFAULT_PHONE_NUMBER_PREFIX,
                                DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER))
                        .hasEmailSubscription(new Random().nextBoolean())
                        .build()
        )
                .emailAuth(EmailAuthDto.builder()
                        .password(DEFAULT_PASSWORD).build()
                ).build();
    }

    @Override
    public CustomerDto registerNewCustomer() {
        return registerCustomerClient.registerAccount(generateNewCustomer());
    }
}