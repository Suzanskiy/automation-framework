package com.racetrac.mobile.giftCard.display;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DisplayGiftCardTest extends BaseTest {
  @Autowired WelcomeFlow welcomeFlow;
  @Autowired SignInFlow signInFlow;
  @Autowired NavigationFlow navigationFlow;
  @Autowired GiftcardFlow giftcardFlow;
  CustomerDto customerDto;

  @TmsLink("8672")
  @Description("Gift cards screen for non-logged user")
  @Test
  public void giftCardsScreenForNonLoggedUserTest() {
    assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    navigationFlow.navigateToCards();
    assertTrue(giftcardFlow.isCardPageDisplayed(), "Gift card page is not displayed");
  }

  @TmsLink("8673")
  @Description("Gift cards screen for logged user if no gift cards")
  @Test
  public void giftCardsScreenForLoggedUserIfNoGiftCardsTest() {
    customerDto = testData.registerNewCustomer();
    assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    signInFlow.openLoginInPage();
    assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
    signInFlow.authorize(customerDto);
    assertTrue(
        welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    navigationFlow.navigateToCards();
    assertTrue(giftcardFlow.isGiftCardPageDisplayed(), "Gift card page is not displayed");
  }
}
