package com.racetrac.mobile.multisite.racetrac.flow;

public interface PromotionalOffersFlow {
    void waitUntilOkBtnAvailable();

    void chooseNoAlcohol();

    void chooseNoTobacco();

    void chooseNoLottery();

    void chooseYesAlcohol();

    void chooseYesTobacco();

    void chooseYesLottery();

    void acceptPromotions();

    boolean isAcceptedPromotionsSaved();

    boolean isYesAlcoholSaved();

    boolean isYesLotterySaved();

    boolean isYesTobaccoSaved();

    void clickSaveBtn();

    void clickNextBtn();

    void skipPromotions();

    boolean isPromotionalOffersPageOpened();

    void skipIOSPromotions();

    void navigateBack();

    void clickOkBtnOnTheEnterBirthdayPopUp();

    void clickCancelBtnOnTheBirthdayPopUpField();

    boolean isPopUpDescriptionDisplayed();

    boolean isOkPopUpBtnEditable();

    void enterBirthDate(String customerBirth);
}