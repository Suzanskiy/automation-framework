package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosBecomeFuelVipFlowImpl extends BaseFlow implements BecomeFuelVipFlow {
    @Step
    @Override
    public void clickNotRightNow() {
        getBecomeFuelVipPage().waitUntilIsOpened();
        getBecomeFuelVipPage().getNotRightNowBtn().click();
    }

    @Override
    public void clickLearnMoreBtn() {
        getBecomeFuelVipPage().getLearnMoreBtn().click();
    }

    @Override
    public void clickGetStartedBtn() {
        getBecomeFuelVipPage().getGetStartedBtn().click();
    }

    @Override
    public void clickNotRightNowBtn() {
        getBecomeFuelVipPage().getNotRightNowBtn().click();
    }

    @Override
    public boolean checkAllElementsIsLoaded() {
        return getBecomeFuelVipPage().waitUntilIsOpened();
    }
}
