package com.racetrac.mobile.multisite.racetrac.flow;

public interface PromotionalOffersFlow {
    void chooseNoAlcohol();

    void chooseNoTobacco();

    void chooseNoLottery();

    void clickNextBtn();

    void skipPromotions();

    boolean isPromotionalOffersScreenOpened();

    void skipIOSPromotions();
}