package com.racetrac.mobile.accountSettings.screen;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.framework.enums.CustomerAge.ADULT;
import static com.racetrac.mobile.framework.enums.CustomerAge.UNDER_21;
import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.NOT_ADULT_USER_TEXT;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;
import static org.testng.Assert.*;

public class AccountSettingsAuthorisedUserTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    CustomerDto customerDto;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    NotAdultNoticeFlow notAdultNoticeFlow;
    @Autowired
    ProfileFlow profileFlow;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }


    @TmsLink("5469")
    @Description("Account Settings screen for registered user")
    @Test
    public void accountSettingsScreenForLoggedInUserTest() {
        customerDto = testData.registerNewCustomer();

        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.closeAccountSettingsScreen();
        pointsAndLevelsFlow.clickGotItBtn();
    }

    @TmsLink("")
    @Description("")
    @Test
    public void promotionsForAdultCustomerTest() {
        customerDto = testData.registerNewCustomer(ADULT);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        promotionalOffersFlow.navigateBack();
        accountSettingsFlow.navigateBack();
        pointsAndLevelsFlow.clickGotItBtn();
    }

    @TmsLink("")
    @Description("")
    @Test
    public void promotionsForUserUnder21Test() {
        customerDto = testData.registerNewCustomer(UNDER_21);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();

        assertTrue(notAdultNoticeFlow.isNotAdultNoticeDisplayed(), "Not adult notice not displayed");

        assertEquals(notAdultNoticeFlow.getNotAdultNoticeMessage(), NOT_ADULT_USER_TEXT);
        notAdultNoticeFlow.clickOK();

        accountSettingsFlow.navigateBack();
    }

    @TmsLink("")
    @Description("")
    @Test
    public void promotionsSettingsAndBirthdayChangesAreDisabledForUserUnder21Test() {
        customerDto = testData.registerNewCustomer(UNDER_21);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();

        assertTrue(notAdultNoticeFlow.isNotAdultNoticeDisplayed(), "Not adult notice not displayed");
        assertEquals(notAdultNoticeFlow.getNotAdultNoticeMessage(), NOT_ADULT_USER_TEXT);
        notAdultNoticeFlow.clickCheckBirthdayBtn();

        assertTrue(profileFlow.isProfilePageOpened());
        assertEquals(profileFlow.isBirthdayFieldEditable(), "false");

        accountSettingsFlow.navigateBack();
    }

    /* Impossible to check the "Yes" button after saving promotions settings
    due to the absence of the corresponding attribute */
    @TmsLink("")
    @Description("Promotional Settings\" can be changed by User older than 21")
    @Test
    public void promotionsSettingsTapedYesBtnSavedAfterClick() {
        customerDto = testData.registerNewCustomer(ADULT);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        promotionalOffersFlow.acceptPromotions();

        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened());
        accountSettingsFlow.navigateToPromotionalSettings();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        promotionalOffersFlow.navigateBack();

        accountSettingsFlow.navigateBack();
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
    }
}