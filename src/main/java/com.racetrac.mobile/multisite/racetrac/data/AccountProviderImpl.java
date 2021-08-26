package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountProviderImpl implements AccountProvider {
    @Autowired
    TestData testData;

    public static final String FIFTY_REDEEM_POINTS_ACCOUNT = "user50points@epam.com";

    @Override
    public CustomerDto getCustomerWith50Points() {
        CustomerDto customerDto = testData.generateDefaultCustomer();
        customerDto.getPersonalInfo().setEmail(FIFTY_REDEEM_POINTS_ACCOUNT);
        return customerDto;
    }
}
