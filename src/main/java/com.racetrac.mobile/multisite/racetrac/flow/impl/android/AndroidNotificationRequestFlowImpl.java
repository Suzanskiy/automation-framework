package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidNotificationRequestFlowImpl extends BaseFlow implements NotificationRequestFlow {


    @Step
    @Override
    public void clickNotNow() {
        try {
            getTurnOnNotificationPage().waitUntilIsOpened();
            getTurnOnNotificationPage().getNotNowBtn().click();

        } catch (StaleElementReferenceException e) {
            LOG.warn("Page was recreated");
            getTurnOnNotificationPage().refresh();
            clickNotNow();
        } catch (NoSuchElementException | TimeoutException  e) {
            LOG.warn("Nu such element location with Notification request page");
        }
    }

    @Step
    @Override
    public void clickTurnOn() {
        getTurnOnNotificationPage().getTurnOnBtn().click();
    }

    @Override
    public boolean isNotificationRequestOpened() {
        return getTurnOnNotificationPage().waitUntilIsOpened();
    }

}
