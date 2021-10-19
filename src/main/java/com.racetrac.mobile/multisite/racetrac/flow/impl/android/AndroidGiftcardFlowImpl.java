package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.MobilePage;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidGiftcardFlowImpl extends BaseFlow implements GiftcardFlow {

    @Step
    @Override
    public boolean isGiftCardPageDisplayed() {
        return getGiftcardPage().waitUntilIsOpened();
    }


}
