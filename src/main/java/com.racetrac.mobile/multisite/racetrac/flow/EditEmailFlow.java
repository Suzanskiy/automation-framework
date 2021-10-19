package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface EditEmailFlow extends NavigateFlow {

    CustomerDto editEmail(CustomerDto customerDto, final String email);

    boolean IsUpdatedEmailPageDisplayed();
}
