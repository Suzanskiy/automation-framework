package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.impl.InboxFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosInboxFlowImpl extends BaseFlow implements InboxFlow {
    @Override
    public boolean isAuthorisedUserInboxPageDisplayed() {
        return getAuthorisedUserInboxPage().waitUntilIsOpened();
    }
}
