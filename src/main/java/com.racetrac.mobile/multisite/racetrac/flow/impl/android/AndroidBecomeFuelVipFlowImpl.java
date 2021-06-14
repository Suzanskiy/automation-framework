package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidBecomeFuelVipFlowImpl extends BaseFlow implements BecomeFuelVipFlow {

    @Override
    public void clickNotRightNow() {
        getBecomeFuelVipPage().waitUntilIsOpened();
        getBecomeFuelVipPage().getNotRightNowBtn().click();
    }
}
