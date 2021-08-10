package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    public static final Logger LOG = LoggerFactory.getLogger(AndroidWelcomeFlowImpl.class);

    @Override
    @Step
    public boolean isHomePageOpened() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getNotNowBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Cannot find Location page");
        }
        return getHomePage().waitUntilIsOpened();
    }

    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        return getHomePage().waitUntilIsOpened();
    }
}
