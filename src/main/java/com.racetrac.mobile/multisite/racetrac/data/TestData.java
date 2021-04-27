package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface TestData {
    CustomerDto generateNewCustomer();
    CustomerDto registerNewCustomer();
}