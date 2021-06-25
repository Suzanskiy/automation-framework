package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosBecomeFuelVipFlowImpl extends BaseFlow implements BecomeFuelVipFlow {
    @Override
    public void clickNotRightNow() {
        LOG.warn("Not implemented here");
    }
}