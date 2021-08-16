package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(ANDROID)
@Component
public class AndroidPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {

    @Override
    public void chooseNoAlcohol() {
        getPromotionalOffersPage().getNoAlcohol().click();
    }

    @Override
    public void chooseNoTobacco() {
        getPromotionalOffersPage().getNoTobacco().click();
    }

    @Override
    public void chooseNoLottery() {
        getPromotionalOffersPage().getNoLottery().click();
    }

    @Override
    public void chooseYesAlcohol() {
        getPromotionalOffersPage().getYesAlcohol().click();
    }

    @Override
    public void chooseYesTobacco() {
        getPromotionalOffersPage().getYesTobacco().click();
    }

    @Override
    public void chooseYesLottery() {
        getPromotionalOffersPage().getYesLottery().click();
    }

    @Override
    public void acceptPromotions() {
        chooseYesAlcohol();
        chooseYesTobacco();
        chooseYesLottery();
        clickSaveBtn();
    }

    @Override
    public void clickSaveBtn() {
        getPromotionalOffersPage().getSaveBtn().click();
    }

    @Override
    public void clickNextBtn() {
        getPromotionalOffersPage().getNextBtn().click();
    }

    @Override
    public void skipPromotions() {
        chooseNoAlcohol();
        chooseNoTobacco();
        chooseNoLottery();
        clickNextBtn();
    }

    @Override
    public boolean isPromotionalOffersScreenOpened() {
        return getPromotionalOffersPage().waitUntilIsOpened();
    }

    @Override
    public void skipIOSPromotions() {
        LOG.debug("Promotions not showing on Android");
    }

    @Override
    public void navigateBack() {
        pressBackBtn();
    }

    @Override
    public void clickOkBtnInEnterBirthdayPopUp() {
        getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().click();
    }

    @Override
    public void clickCancelBtnOnTheBirthdayPopUpField() {
        getPromotionalOffersPage().getCancelBirthdayPopUpFieldBtn().click();
    }

    @Override
    public boolean isPopUpDescriptionDisplayed() {
        return getPromotionalOffersPage().getDescriptionText().isDisplayed();
    }

    @Override
    public boolean isOkFieldEditable() {
        final String attribute = getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().getAttribute("enabled");
        if (attribute.equals("false")) {
            return false;
        }
        return true;
    }

    @Override
    public void enterBirthDate(final String customerBirth) {
        getPromotionalOffersPage().getEnterBirthdayPopUpField().setValue(customerBirth);
    }

}