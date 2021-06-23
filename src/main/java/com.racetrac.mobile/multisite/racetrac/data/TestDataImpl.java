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

    public static final String CUSTOMER_DEFAULT_NAME = "Automation";
    public static final String CUSTOMER_DEFAULT_LASTNAME = "Engineer";
    @Autowired
    RegisterCustomerClient registerCustomerClient;

    public static final String EMAIL_DOMAIN = "qateam.com";
    public static final String DEFAULT_PASSWORD = "password123!";
    public static final String DEFAULT_PHONE_NUMBER_PREFIX = "1";
    public static final int CUSTOMER_AGE = 25;
    public static final int DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER = 10;

    private String computeBirthDateByAge(final int age) {
        return LocalDate.now().minusYears(age).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    @Override
    public CustomerDto generateDefaultCustomer() {
        return CustomerDto.builder().personalInfo(
                PersonalInfoDto.builder()
                        .birthday(computeBirthDateByAge(CUSTOMER_AGE))
                        .email(CommonUtils.generateEmail(EMAIL_DOMAIN))
                        .firstName(CUSTOMER_DEFAULT_NAME)
                        .lastName(CUSTOMER_DEFAULT_LASTNAME)
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
    public CustomerDto generateCustomer(final int age) {
        return CustomerDto.builder().personalInfo(
                PersonalInfoDto.builder()
                        .birthday(computeBirthDateByAge(age))
                        .email(CommonUtils.generateEmail(EMAIL_DOMAIN))
                        .firstName(CUSTOMER_DEFAULT_NAME)
                        .lastName(CUSTOMER_DEFAULT_LASTNAME)
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
        return registerCustomerClient.registerAccount(generateDefaultCustomer());
    }

    @Override
    public CustomerDto registerNewCustomer(final int age) {

        return registerCustomerClient.registerAccount(generateCustomer(age));
    }
}