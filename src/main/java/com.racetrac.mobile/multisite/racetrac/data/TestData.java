package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface TestData {
    CustomerDto generateDefaultCustomer();
    CustomerDto generateCustomer(int age);
    CustomerDto generateCustomerWithoutBirthdate();
    CustomerDto registerNewCustomer();
    CustomerDto registerNewCustomer(CustomerAge age);
    String generateDateBirth();
}