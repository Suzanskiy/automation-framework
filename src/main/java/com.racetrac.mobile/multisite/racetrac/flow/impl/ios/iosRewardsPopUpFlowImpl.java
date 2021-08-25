package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosRewardsPopUpFlowImpl extends BaseFlow implements RewardsPopupFlow {
    @Step
    @Override
    public void clickGotItBtn() {
        try {
            getRewardsPopupPage().waitUntilIsOpened();
            getRewardsPopupPage().getGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Unable to click got it btn on Rewards pop up");
        }
    }
}
