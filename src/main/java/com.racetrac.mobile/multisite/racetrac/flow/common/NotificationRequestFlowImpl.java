package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.stereotype.Component;

@Component
public class NotificationRequestFlowImpl extends BaseFlow implements NotificationRequestFlow {
    @Step
    @Override
    public void clickNotNow() {
        try {
            getTurnOnNotificationPage().waitUntilIsOpened();
            getTurnOnNotificationPage().getNotNowBtn().click();
        } catch (
                NoSuchElementException e) {
            LOG.warn("Notification page is not opened here, It might create a problem soon");
        }catch (StaleElementReferenceException e)
        {
            LOG.warn("Page was recreated");
            clickNotNow();
        }
    }

    @Step
    @Override
    public void clickTurnOn() {
        getTurnOnNotificationPage().getTurnOnBtn().click();
    }
}
