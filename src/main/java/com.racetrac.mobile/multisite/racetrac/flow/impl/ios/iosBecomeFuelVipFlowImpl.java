package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosBecomeFuelVipFlowImpl extends BaseFlow implements BecomeFuelVipFlow {
    @Step
    @Override
    public void clickNotRightNowBtn() {
        try {
            getBecomeFuelVipPage().waitUntilIsOpened();
            clickNotRightNowBtn();
        } catch (NoSuchElementException | TimeoutException e) {

        }
    }

    @Step
    @Override
    public void clickLearnMoreBtn() {
        getBecomeFuelVipPage().getLearnMoreBtn().click();
    }

    @Step
    @Override
    public void clickGetStartedBtn() {
        getBecomeFuelVipPage().getGetStartedBtn().click();
    }

    @Step
    @Override
    public boolean checkAllElementsIsLoaded() {
        return getBecomeFuelVipPage().waitUntilIsOpened();
    }

    @Override
    public void waitUntilBecomeFuelVipLoaded() {

    }
}
