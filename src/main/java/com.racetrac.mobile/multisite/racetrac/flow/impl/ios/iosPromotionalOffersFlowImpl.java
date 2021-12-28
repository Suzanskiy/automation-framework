package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {

  @Override
  public void waitUntilOkBtnAvailable() {
    AppiumWaitingUtils.waitUntilIsTrue(() -> !isOkPopUpBtnEditable());
  }

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
  public boolean isAcceptedPromotionsSaved() {
    return isYesAlcoholSaved() && isYesLotterySaved() && isYesTobaccoSaved();
  }

  @Override
  public boolean isYesAlcoholSaved() {
    return getPromotionalOffersPage().getYesAlcohol().isDisplayed();
  }

  @Override
  public boolean isYesLotterySaved() {
    return getPromotionalOffersPage().getYesLottery().isDisplayed();
  }

  @Override
  public boolean isYesTobaccoSaved() {
    return getPromotionalOffersPage().getYesTobacco().isDisplayed();
  }

  @Override
  public void clickSaveBtn() {
    getPromotionalOffersPage().getSaveBtn().click();
  }

  @Override
  public void clickNextBtn() {
    getPromotionalOffersPage().getNextBtn().click();
  }

  @Step
  @Override
  public void skipPromotions() {
    try {
      chooseNoAlcohol();
      chooseNoTobacco();
      chooseNoLottery();
      clickNextBtn();
    } catch (TimeoutException e) {
      LOG.warn("Time out exception on skipping promotionsx");
    } catch (NoSuchElementException ex) {
      // ignore
    }
  }

  @Override
  public boolean isPromotionalOffersPageOpened() {
    return getPromotionalOffersPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void skipIOSPromotions() {
    skipPromotions();
  }

  @Override
  public void navigateBack() {
    getPromotionalOffersPage().getNavigateBackBtn().click();
  }

  @Override
  public void clickOkBtnOnTheEnterBirthdayPopUp() {
    getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().click();
  }

  @Override
  public void clickCancelBtnOnTheBirthdayPopUpField() {
    getPromotionalOffersPage().getCancelBirthdayPopUpFieldBtn().click();
  }

  @Override
  public boolean isPopUpDescriptionDisplayed() {
    getPromotionalOffersPage().refresh();
    return getPromotionalOffersPage().getDescriptionText().isDisplayed();
  }

  @Override
  public boolean isOkPopUpBtnEditable() {
    getPromotionalOffersPage().waitUntilIsOpened();
    final String attribute =
        getPromotionalOffersPage().getOkBirthdayPopUpFieldBtn().getAttribute("enabled");
    return !attribute.equals("false");
  }

  @Override
  public void enterBirthDate(final String customerBirth) {
    getPromotionalOffersPage().getEnterBirthdayPopUpField().clear();
    getPromotionalOffersPage().getEnterBirthdayPopUpField().sendKeys(customerBirth);
  }
}
