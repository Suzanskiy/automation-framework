package com.racetrac.mobile.multisite.racetrac.flow;

public interface NoPointsNoticeFlow {

    String getNotificationMessages();

    void clickOK();

    void waitUntilNoPointsNoticeShown();
}
