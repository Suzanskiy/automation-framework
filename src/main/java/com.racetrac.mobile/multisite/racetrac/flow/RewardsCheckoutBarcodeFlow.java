package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsCheckoutBarcodeFlow {

    boolean isRewardsCheckoutBarcodePageOpen();

    void closeRewardsCheckoutPage();

    int getUnclaimedRewardsCounter();

    void clickOnDoneBtn();

    void goToUnclaimedRewardsPage();

}
