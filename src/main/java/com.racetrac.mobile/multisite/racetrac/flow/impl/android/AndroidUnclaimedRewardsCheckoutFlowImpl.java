package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.UnclaimedRewardsCheckoutFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidUnclaimedRewardsCheckoutFlowImpl extends BaseFlow implements UnclaimedRewardsCheckoutFlow {
    @Override
    public boolean isUnclaimedRewardsCheckoutPageOpen() {
        return getUnclaimedRewardsCheckoutPage().waitUntilIsOpened();
    }

    @Override
    public void closeRewardsCheckoutPage() {
        getUnclaimedRewardsCheckoutPage().getCloseCheckoutPageBtn().click();
    }
}
