package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PriceDisclaimerFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPriceDisclaimerFlowImpl extends BaseFlow implements PriceDisclaimerFlow {

    @Step
    @Override
    public boolean isPriceDisclaimerOpened() {
        return getPriceDisclaimerPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOkBtn() {
        getPriceDisclaimerPage().getOkButton().click();
    }
}
