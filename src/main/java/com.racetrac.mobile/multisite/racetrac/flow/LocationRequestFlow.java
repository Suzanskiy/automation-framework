package com.racetrac.mobile.multisite.racetrac.flow;

public interface LocationRequestFlow {
    void clickContinue();

    void clickOnlyThisTime();

    boolean isLocationRequestOpened();

    void clickAllowButton();
}