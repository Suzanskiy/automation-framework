package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.data.BillingData;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;

@Profile(IOS)
@Component
public class iosGiftcardFlowImpl extends BaseFlow implements GiftcardFlow {

  @Step
  @Override
  public boolean isGiftCardPageDisplayed() {
    return getGiftcardPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void clickBuyNewGiftCard() {
    getGiftcardPage().waitUntilIsOpened();
    getGiftcardPage().getBuyNewBtn().click();
  }

  @Step
  @Override
  public boolean isBuyNewCardPageOpened() {
    return getBuyNewCardPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void enterPaymentInfo() {
    getBuyNewCardPage().getFirstNameOnCard().sendKeys(BillingData.FIRST_NAME);
    getBuyNewCardPage().getLastNameOnCard().sendKeys(BillingData.LAST_NAME);
    getBuyNewCardPage().getCardNumber().sendKeys(BillingData.CARD_NUMBER);
    getBuyNewCardPage().getMonthYear().sendKeys(BillingData.MM_YY);
    getBuyNewCardPage().getSecurityCode().sendKeys(BillingData.SECURITY_CODE);
  }

  @Step
  @Override
  public void enterBillingInfo() {
    swipeUP();
    getBuyNewCardPage().getAdress().sendKeys(BillingData.ADDRESS);
    getBuyNewCardPage().getCity().sendKeys(BillingData.CITY);
    getBuyNewCardPage().getState().sendKeys(BillingData.STATE);
    getBuyNewCardPage().getZipCode().sendKeys(BillingData.ZIP_CODE);
    clickDoneBtn();
  }

  @Step
  @Override
  public boolean isSuccessPaymentProcessedViewOpened() {
    return getSuccessPaymentProcessedView().waitUntilIsOpened();
  }

  @Step
  @Override
  public void clickOkOnSuccessPaymentView() {
    final WebElement okBtn = getSuccessPaymentProcessedView().getOkBtn();
    waitUntilElementClickable(okBtn);
    okBtn.click();
  }

  @Step
  @Override
  public boolean isPayWithGiftCardPageOpened() {
    return getPayWithAddedGiftCardPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void requestNewGiftCard() {
    getPayWithAddedGiftCardPage().getBuyNew().click();
    getBuyNewCardPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public int getGiftCardCount() {
    return Integer.parseInt(
        getPayWithAddedGiftCardPage()
            .getPageIndicator()
            .getAttribute("value")
            .replace("page 1 of ", ""));
  }

  @Step
  @Override
  public void reloadGiftCard() {
    getPayWithAddedGiftCardPage().getReloadCard().click();
  }

    @Override
    public String getGiftCardMoneyAmount() {
       return getPayWithAddedGiftCardPage().getMoneyAmount().getAttribute("value");
    }

  @Override
  public boolean isCardPageDisplayed() {
    return getCardsPage().waitUntilIsOpened();
  }

  @Step
  private void clickDoneBtn() {
    getBuyNewCardPage().getDoneBtn().click();
  }
}
