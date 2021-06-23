package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface TestData {
    CustomerDto generateDefaultCustomer();
    CustomerDto generateCustomer(int age);
    CustomerDto registerNewCustomer();
    CustomerDto registerNewCustomer(int age);
}