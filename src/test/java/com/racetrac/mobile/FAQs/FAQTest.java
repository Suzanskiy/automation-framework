package com.racetrac.mobile.FAQs;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FAQTest extends BaseTest {

    CustomerDto customerDto;
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    FAQFlow faqFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;

    @TmsLink("10163")
    @Description("FAQs for unauthorised users")
    @Test
    public void unauthorisedFAQTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Home page is not opened");
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsScreenOpened(), "Account setting are not opened");
        accountSettingsFlow.navigateToHelpSection();
        assertTrue(faqFlow.isFAQpageDisplayed(), "FAQ page is not opened");
        faqFlow.expandLinks();
        assertTrue(faqFlow.checkAllItems(), "Items are invalid");

    }

    @TmsLink("10163")
    @Description("FAQs for authorised users")
    @Test
    public void authorisedFAQTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);
        notificationRequestFlow.iosClickNotNow();
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.waitUntilAccountSettingsAuthorizedOpen();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), "Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToHelpSection();
        assertTrue(faqFlow.isFAQpageDisplayed(), "FAQ page is not opened");
        faqFlow.expandLinks();
        assertTrue(faqFlow.checkAllItems(), "Items are invalid");
        assertTrue(faqFlow.isContactUsLinkDisplayed(), "Contact us link is nit dispayed");

    }

}
