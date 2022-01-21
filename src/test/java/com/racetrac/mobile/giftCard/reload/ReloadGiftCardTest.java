package com.racetrac.mobile.giftCard.reload;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReloadGiftCardTest extends BaseTest {
  private static final String RELOADED_CARD_MONEY_AMOUNT = "$10.00";
  private static final String BOUGHT_CARD_MONEY_AMOUNT = "$5.00";
  CustomerDto customerDto;
  @Autowired WelcomeFlow welcomeFlow;
  @Autowired SignInFlow signInFlow;
  @Autowired NavigationFlow navigationFlow;
  @Autowired GiftcardFlow giftcardFlow;

  @BeforeMethod
  public void setUp() {
    customerDto = testData.registerNewCustomer();
    assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    signInFlow.openLoginInPage();
    assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
    signInFlow.authorize(customerDto);
    assertTrue(
        welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
  }

  @Test
  public void reloadGiftCardTest() {
    navigationFlow.navigateToCards();
    assertTrue(giftcardFlow.isGiftCardPageDisplayed(), "Gift card page is not displayed");
    giftcardFlow.clickBuyNewGiftCard();
    assertTrue(giftcardFlow.isBuyNewCardPageOpened(), "Buy new card page is not displayed");
    giftcardFlow.enterPaymentInfo();
    giftcardFlow.enterBillingInfo();
    assertTrue(
        giftcardFlow.isSuccessPaymentProcessedViewOpened(),
        "Success payment view is not displayed");
    giftcardFlow.clickOkOnSuccessPaymentView();
    assertTrue(
        giftcardFlow.isPayWithGiftCardPageOpened(),
        "Pay screen with added Gift Card not displayed");
    assertEquals(giftcardFlow.getGiftCardMoneyAmount(), BOUGHT_CARD_MONEY_AMOUNT);

    giftcardFlow.reloadGiftCard();
    giftcardFlow.enterPaymentInfo();
    giftcardFlow.enterBillingInfo();
    giftcardFlow.clickOkOnSuccessPaymentView();
    assertTrue(
        giftcardFlow.isPayWithGiftCardPageOpened(),
        "Pay screen with added Gift Card not displayed");
    assertEquals(giftcardFlow.getGiftCardMoneyAmount(), RELOADED_CARD_MONEY_AMOUNT);
  }
}
