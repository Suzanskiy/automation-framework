package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.InboxFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidInboxFlowImpl extends BaseFlow implements InboxFlow {
    @Override
    public boolean isAuthorisedUserInboxPageDisplayed() {
        return getAuthorisedUserInboxPage().waitUntilIsOpened();
    }
}
