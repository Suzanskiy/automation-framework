package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidRewardPopUpFlowImpl extends BaseFlow implements RewardsPopupFlow {

    @Override
    public boolean isRewardPopupPageOpened() {
        return getRewardsPopupPage().waitUntilIsOpened();
    }

    @Override
    public void clickGotItBtn() {
        try {
            getRewardsPopupPage().getGotItBtn().click();
        } catch (NoSuchElementException e) {
            LOG.warn("Unable to click got it btn on reward pop up");
        }
    }
}