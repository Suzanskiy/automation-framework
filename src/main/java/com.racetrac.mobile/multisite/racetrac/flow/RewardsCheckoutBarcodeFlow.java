package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsCheckoutBarcodeFlow {

    boolean isRewardsCheckoutBarcodePageOpened();

    void closeRewardsCheckoutPage();

    int getUnclaimedRewardsCounter();

    void clickOnDoneBtn();

    void goToUnclaimedRewardsPage();

}
