package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

import java.time.temporal.ChronoUnit;

public interface TestData {
    CustomerDto generateDefaultCustomer();
    CustomerDto generateCustomer(int age);
    CustomerDto generateCustomerWithoutBirthdate();
    CustomerDto registerNewCustomer();
    CustomerDto registerNewCustomer(CustomerAge age);
    String generateDateBirth();
    String generateDateBirthPlus(int amount, ChronoUnit unitType);
}