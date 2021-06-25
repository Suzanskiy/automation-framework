package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import org.springframework.stereotype.Component;

@Component
public class EditEmailFlowImpl extends BaseFlow implements EditEmailFlow {

    @Override
    public CustomerDto editEmail(final CustomerDto customerDto, final String email) {
        getEditEmailPage().getNewEmailField().sendKeys(email);
        getEditEmailPage().getChangeEmailBtn().click();
        customerDto.getPersonalInfo().setEmail(email);
        return customerDto;
    }
}
