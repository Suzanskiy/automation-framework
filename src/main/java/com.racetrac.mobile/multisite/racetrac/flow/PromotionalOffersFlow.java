package com.racetrac.mobile.multisite.racetrac.flow;

public interface PromotionalOffersFlow {
    void chooseNoAlcohol();

    void chooseNoTobacco();

    void chooseNoLottery();

    void chooseYesAlcohol();

    void chooseYesTobacco();

    void chooseYesLottery();

    void acceptPromotions();

    void clickSaveBtn();

    void clickNextBtn();

    void skipPromotions();

    boolean isPromotionalOffersScreenOpened();

    void skipIOSPromotions();

    void navigateBack();
}