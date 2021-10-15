package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SuccessfulSentContactUsMessageFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidSuccessfulSentContactUsMessageFlowImpl extends BaseFlow implements SuccessfulSentContactUsMessageFlow {
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
