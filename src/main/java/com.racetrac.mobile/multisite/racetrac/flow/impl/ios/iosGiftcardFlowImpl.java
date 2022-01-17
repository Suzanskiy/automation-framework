package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.data.BillingData;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;

@Profile(IOS)
@Component
public class iosGiftcardFlowImpl extends BaseFlow implements GiftcardFlow {

  @Step
  @Override
  public boolean isGiftCardPageDisplayed() {
    return getGiftcardPage().waitUntilIsOpened();
  }

  @Override
  public void clickBuyNewGiftCard() {
    getGiftcardPage().waitUntilIsOpened();
    getGiftcardPage().getBuyNewBtn().click();
  }

  @Override
  public boolean isBuyNewCardPageOpened() {
    return getBuyNewCardPage().waitUntilIsOpened();
  }

  @Override
  public void enterPaymentInfo() {
    getBuyNewCardPage().getFirstNameOnCard().sendKeys(BillingData.FIRST_NAME);
    getBuyNewCardPage().getLastNameOnCard().sendKeys(BillingData.LAST_NAME);
    getBuyNewCardPage().getCardNumber().sendKeys(BillingData.CARD_NUMBER);
    getBuyNewCardPage().getMonthYear().sendKeys(BillingData.MM_YY);
    getBuyNewCardPage().getSecurityCode().sendKeys(BillingData.SECURITY_CODE);
  }

  @Override
  public void enterBillingInfo() {
    swipeUP();
    getBuyNewCardPage().getAdress().sendKeys(BillingData.ADDRESS);
    getBuyNewCardPage().getCity().sendKeys(BillingData.CITY);
    getBuyNewCardPage().getState().sendKeys(BillingData.STATE);
    getBuyNewCardPage().getZipCode().sendKeys(BillingData.ZIP_CODE);
    clickDoneBtn();
  }

  @Override
  public boolean isSuccessPaymentProcessedViewOpened() {
    return getSuccessPaymentProcessedView().waitUntilIsOpened();
  }

  @Override
  public void clickOkOnSuccessPaymentView() {
    getSuccessPaymentProcessedView().getOkBtn().click();
  }

  private void clickDoneBtn() {
    getBuyNewCardPage().getDoneBtn().click();
  }
}
