package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.UnclaimedRewardsCheckoutFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosUnclaimedRewardsCheckoutFlowImpl extends BaseFlow implements UnclaimedRewardsCheckoutFlow {
    @Override
    public boolean isUnclaimedRewardsCheckoutPageOpen() {
        return getUnclaimedRewardsCheckoutPage().waitUntilIsOpened();
    }

    @Override
    public void closeRewardsCheckoutPage() {
        getUnclaimedRewardsCheckoutPage().getCloseCheckoutPageBtn().click();
    }
}
