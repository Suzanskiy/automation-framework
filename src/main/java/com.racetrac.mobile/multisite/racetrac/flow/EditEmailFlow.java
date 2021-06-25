package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface EditEmailFlow {

    CustomerDto editEmail(CustomerDto customerDto, final String email);
}
