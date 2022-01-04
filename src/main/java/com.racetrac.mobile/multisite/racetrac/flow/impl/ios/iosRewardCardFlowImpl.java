package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardCardFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosRewardCardFlowImpl extends BaseFlow implements RewardCardFlow {

    @Override
    public boolean isRewardsDebitCardPageDisplayed() {
       return getRewardsDebitCardPage().waitUntilIsOpened();
    }

    @Override
    public boolean isOrderRewardCardPageDisplayed() {
        return getOrderRewardCardPage().waitUntilIsOpened();
    }

    @Override
    public boolean isUpgradeRewardCardPageDisplayed() {
        return getUpgradeRewardCardPage().waitUntilIsOpened();
    }
}
