package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.api.RegisterCustomerClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.dto.EmailAuthDto;
import com.racetrac.mobile.multisite.racetrac.dto.PersonalInfoDto;
import com.racetrac.mobile.multisite.racetrac.util.CommonUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Component
public class TestDataImpl implements TestData {
    private static final Logger LOG = LoggerFactory.getLogger(TestData.class);

    @Autowired
    RegisterCustomerClient registerCustomerClient;

    public static final String CUSTOMER_DEFAULT_NAME = "Automation";
    public static final String CUSTOMER_DEFAULT_LASTNAME = "Engineer";
    public static final String EMAIL_DOMAIN = "qateam.com";
    public static final String DEFAULT_PASSWORD = "password123!";
    public static final String DEFAULT_PHONE_NUMBER_PREFIX = "1";
    public static final int CUSTOMER_ADULT_AGE = 25;
    public static final int CUSTOMER_CHILD_AGE = 16;
    public static final int DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER = 10;
    public static final String API_BIRTHDATE_PATTERN = "yyyy-MM-dd";
    public static final String UI_BIRTHDATE_PATTERN = "MM/dd/yyyy";
    private static final String PATH = "testData/text5000symbols.txt";

    private String computeBirthDateByAge(final int age) {
        return LocalDate.now().minusYears(age).format(DateTimeFormatter.ofPattern(API_BIRTHDATE_PATTERN));
    }

    @Override
    public CustomerDto generateDefaultCustomer() {
        return CustomerDto.builder().personalInfo(
                PersonalInfoDto.builder()
                        .birthday(computeBirthDateByAge(CUSTOMER_ADULT_AGE))
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
        CustomerDto customerDto = generateDefaultCustomer();
        customerDto.getPersonalInfo().setBirthday(computeBirthDateByAge(age));
        return customerDto;
    }

    @Override
    public CustomerDto generateCustomerWithoutBirthdate() {
        CustomerDto customerDto = generateDefaultCustomer();
        customerDto.getPersonalInfo().setBirthday("");
        return customerDto;
    }

    @Override
    public CustomerDto registerNewCustomer() {
        return registerCustomerClient.registerAccount(generateDefaultCustomer());
    }

    @Override
    public CustomerDto registerNewCustomer(final CustomerAge age) {
        CustomerDto customerDto;
        switch (age) {
            case ADULT:
                customerDto = generateCustomer(CUSTOMER_ADULT_AGE);
                break;
            case UNDER_21:
                customerDto = generateCustomer(CUSTOMER_CHILD_AGE);
                break;
            case NOT_SPECIFIED_BIRTHDATE:
                customerDto = generateDefaultCustomer();
                customerDto.getPersonalInfo().setBirthday("");
                break;
            default:
                customerDto = generateDefaultCustomer();

        }
        return registerCustomerClient.registerAccount(customerDto);
    }

    @Override
    public CustomerDto getFacebookCustomer() {
        final CustomerDto.CustomerDtoBuilder builder = CustomerDto.builder();
        builder.personalInfo(PersonalInfoDto.builder()
                .email("bscwiljppq_1633526535@tfbnw.net")
                .birthday(computeBirthDateByAge(CUSTOMER_ADULT_AGE))
                .phone(CommonUtils.generatePhoneNumber(DEFAULT_PHONE_NUMBER_PREFIX,
                DEFAULT_NUMBER_OF_DIGITS_IN_MOBILE_NUMBER)).build())
                .emailAuth(EmailAuthDto.builder().password("Landmark159!").build());
        return builder.build();
    }

    @Override
    public String generateDateBirth() {
        return LocalDate.now().minusYears(CUSTOMER_ADULT_AGE).format(DateTimeFormatter.ofPattern(UI_BIRTHDATE_PATTERN));
    }

    @Override
    public String generateDateBirthPlus(int amount, ChronoUnit unitType) {
        LocalDate date = LocalDate.now();
        switch (unitType) {
            case DAYS:
                date = date.plusDays(amount);
                break;
            case MONTHS:
                date = date.plusMonths(amount);
                break;
            case YEARS:
                date = date.plusYears(amount);
        }
        return date.format(DateTimeFormatter.ofPattern(UI_BIRTHDATE_PATTERN));
    }

    @Override
    public String get4750Symbols() {
        String fileContent = "";

        ClassPathResource resource = new ClassPathResource(PATH);

        try (InputStream inputStream = resource.getInputStream()) {
            fileContent = IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return fileContent;
    }
}