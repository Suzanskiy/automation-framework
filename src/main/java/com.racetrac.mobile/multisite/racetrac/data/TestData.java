package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

import java.time.temporal.ChronoUnit;

public interface TestData {
    CustomerDto generateDefaultCustomer();

    CustomerDto generateCustomer(int var1);

    CustomerDto generateCustomerWithoutBirthdate();

    CustomerDto registerNewCustomer();

    CustomerDto registerNewCustomer(CustomerAge var1);

    CustomerDto getFacebookCustomer();

    String generateDateBirth();

    String generateDateBirthPlus(int var1, ChronoUnit var2);

    String get4750Symbols();
}