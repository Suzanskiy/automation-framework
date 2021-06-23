package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface EditPasswordFlow {


    CustomerDto editPassword(CustomerDto customerDto, final String password);
}
