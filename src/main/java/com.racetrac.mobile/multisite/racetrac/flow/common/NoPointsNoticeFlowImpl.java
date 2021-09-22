package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NoPointsNoticeFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Component
public class NoPointsNoticeFlowImpl extends BaseFlow implements NoPointsNoticeFlow {
    @Override
    public String getNotificationMessages() {
        return getNoPointsNotice().getSubtitleRewardsCatalog().getText();
    }

    @Override
    public void clickOK() {
        getNoPointsNotice().getOkButtonRewardCatalog().click();
    }

    @Override
    public void waitUntilNoPointsNoticeShown() {
        AppiumWaitingUtils.waitUntilIsTrue(()-> getNoPointsNotice().waitUntilIsOpened());
    }
}
