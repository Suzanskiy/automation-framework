package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(ANDROID)
@Component
public class AndroidPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {
    @Step
    @Override
    public void waitUntilOkBtnAvailable() {
        AppiumWaitingUtils.waitUntilIsTrue(() -> !isOkPopUpBtnEditable());
    }

    @Step
    @Override
    public void chooseNoAlcohol() {
        getPromotionalOffersPage().getNoAlcohol().click();
    }

    @Step
    @Override
    public void chooseNoTobacco() {
        getPromotionalOffersPage().getNoTobacco().click();
    }

    @Step
    @Override
    public void chooseNoLottery() {
        getPromotionalOffersPage().getNoLottery().click();
    }

    @Step
    @Override
    public void chooseYesAlcohol() {
        getPromotionalOffersPage().getYesAlcohol().click();
    }

    @Step
    @Override
    public void chooseYesTobacco() {
        getPromotionalOffersPage().getYesTobacco().click();
    }

    @Step
    @Override
    public void chooseYesLottery() {
        getPromotionalOffersPage().getYesLottery().click();
    }

    @Step
    @Override
    public void acceptPromotions() {
        chooseYesAlcohol();
        chooseYesTobacco();
        chooseYesLottery();
        clickSaveBtn();
    }

    @Step
    @Override
    public boolean isAcceptedPromotionsSaved() {
        return isYesAlcoholSaved() && isYesLotterySaved() && isYesTobaccoSaved();
    }

    @Step
    @Override
    public boolean isYesAlcoholSaved() {
        return getPromotionalOffersPage().getYesAlcohol().isDisplayed();
    }

    @Step
    @Override
    public boolean isYesLotterySaved() {
        return getPromotionalOffersPage().getYesLottery().isDisplayed();
    }

    @Step
    @Override
    public boolean isYesTobaccoSaved() {
        return getPromotionalOffersPage().getYesTobacco().isDisplayed();
    }

    @Step
    @Override
    public void clickSaveBtn() {
        getPromotionalOffersPage().getSaveBtn().click();
    }

    @Step
    @Override
    public void clickNextBtn() {
        getPromotionalOffersPage().getNextBtn().click();
    }

    @Step
    @Override
    public void skipPromotions() {
        chooseNoAlcohol();
        chooseNoTobacco();
        chooseNoLottery();
        clickNextBtn();
    }

    @Step
    @Override
    public boolean isPromotionalOffersScreenOpened() {
        return getPromotionalOffersPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void skipIOSPromotions() {
        LOG.debug("Promotions not showing on Android");
    }

    @Step
    @Override
    public void navigateBack() {
        pressBackBtn();
    }

    @Step
    @Override
    public void clickOkBtnOnTheEnterBirthdayPopUp() {
        getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().click();
    }

    @Step
    @Override
    public void clickCancelBtnOnTheBirthdayPopUpField() {
        getPromotionalOffersPage().getCancelBirthdayPopUpFieldBtn().click();
    }

    @Step
    @Override
    public boolean isPopUpDescriptionDisplayed() {
        return getPromotionalOffersPage().getDescriptionText().isDisplayed();
    }

    @Step
    @Override
    public boolean isOkPopUpBtnEditable() {
        AppiumWaitingUtils.waitUntilElementClickable(getPromotionalOffersPage().getCancelBirthdayPopUpFieldBtn());
        final String attribute = getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().getAttribute("enabled");
        if (attribute.equals("false")) {
            return false;
        }
        return true;
    }

    @Step
    @Override
    public void enterBirthDate(final String customerBirth) {
        getPromotionalOffersPage().getEnterBirthdayPopUpField().clear();
        getPromotionalOffersPage().getEnterBirthdayPopUpField().setValue(customerBirth);
    }

}