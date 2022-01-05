package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SuccessfulSentContactUsMessageFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosSuccessfulSentContactUsMessageFlowImpl extends BaseFlow implements SuccessfulSentContactUsMessageFlow {
    @Step
    @Override
    public boolean isSuccessfulSentContactUsMessageOpened() {
        return getSuccessfulSentContactUsMessagePage().waitUntilIsOpened();
    }
    @Step
    @Override
    public void closeSuccessfulSentContactUsMessagePage() {
        getSuccessfulSentContactUsMessagePage().getCloseSuccessfulContactMessagePageBtn().click();
    }
}
