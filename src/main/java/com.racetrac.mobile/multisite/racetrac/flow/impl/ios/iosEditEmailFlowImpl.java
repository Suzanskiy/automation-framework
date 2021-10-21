package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosEditEmailFlowImpl extends BaseFlow implements EditEmailFlow {

    @Override
    public CustomerDto editEmail(final CustomerDto customerDto, final String email) {
        getEditEmailPage().getNewEmailField().sendKeys(email);
        getEditEmailPage().getChangeEmailBtn().click();
        customerDto.getPersonalInfo().setEmail(email);
        return customerDto;
    }

    @Override
    public boolean IsUpdatedEmailPageDisplayed() {
        return false;
    }

    @Override
    public void navigateBack() {
        try {
            getEditEmailPage().getBackBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Can't navigate back");
        }
    }
}
