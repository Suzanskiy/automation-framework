package com.racetrac.mobile.multisite.racetrac.data;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface AccountProvider {
    CustomerDto getCustomerWith50Points();

    CustomerDto getCustomerWith500Points();
}
