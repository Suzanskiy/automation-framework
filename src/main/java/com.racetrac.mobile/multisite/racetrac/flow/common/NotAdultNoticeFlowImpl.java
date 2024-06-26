package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotAdultNoticeFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class NotAdultNoticeFlowImpl extends BaseFlow implements NotAdultNoticeFlow {
    @Override
    public String getNotAdultNoticeMessage() {
        return getNotAdultNotice().getSubtitle().getText();
    }

    @Step
    @Override
    public boolean isNotAdultNoticeDisplayed() {
        AppiumWaitingUtils.waitUntilElementClickable(getNotAdultNotice().getOkButton());
        return getNotAdultNotice().waitUntilIsOpened();
    }

    @Override
    public void clickOK() {
        getNotAdultNotice().getOkButton().click();
    }

    @Override
    public void clickCheckBirthdayBtn() {
        getNotAdultNotice().getCheckBirthdayBtn().click();
    }
}
