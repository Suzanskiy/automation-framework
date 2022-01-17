package com.racetrac.mobile.giftCard.buy;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BuyGiftCardTest extends BaseTest {
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

  @TmsLink("8710")
  @Description("Gift Card - Buy - Buy new gift card")
  @Test
  public void buyGiftCardTest() {
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
  }
}
