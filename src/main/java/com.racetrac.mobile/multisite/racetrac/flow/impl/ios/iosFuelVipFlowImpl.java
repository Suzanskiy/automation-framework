package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelVipFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosFuelVipFlowImpl extends BaseFlow implements FuelVipFlow {

    @Step
    @Override
    public void navigateToFuelVipSection() {
        getHomePage().getVipSection().click();
        getFuelVipPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickLearnMoreNoSubscription() {
        getFuelVipPage().getNotMemberLearMoreBtn().click();
    }

    @Step
    @Override
    public void clickVipProgramDetails() {
        getFuelVipPage().getFuelVIPProgramDetailsSection().click();
    }

    @Override
    public boolean isFuelVipPageDisplayed() {
        return getFuelVipPage().waitUntilIsOpened();
    }
}
