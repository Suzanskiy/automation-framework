package com.racetrac.mobile.accountSettings.screen;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotAdultNoticeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.framework.enums.CustomerAge.ADULT;
import static com.racetrac.mobile.framework.enums.CustomerAge.NOT_SPECIFIED_BIRTHDATE;
import static com.racetrac.mobile.framework.enums.CustomerAge.UNDER_21;
import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.NOT_ADULT_USER_TEXT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("5469")
    @Description("Account Settings screen for registered user")
    @Test
    public void accountSettingsScreenForLoggedInUserTest() {
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
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
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer(ADULT);
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
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
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer(UNDER_21);
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
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
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer(UNDER_21);
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();

        assertTrue(notAdultNoticeFlow.isNotAdultNoticeDisplayed(), "Not adult notice not displayed");
        assertEquals(notAdultNoticeFlow.getNotAdultNoticeMessage(), NOT_ADULT_USER_TEXT);
        notAdultNoticeFlow.clickCheckBirthdayBtn();

        assertTrue(profileFlow.isProfilePageOpened(), "Profile page is not opened");
        assertFalse(profileFlow.isBirthdayFieldEditable(), "Birthday Field is editable");

        accountSettingsFlow.navigateBack();
    }

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
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        promotionalOffersFlow.acceptPromotions();

        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), "Account settings screen not opened");
        accountSettingsFlow.navigateToPromotionalSettings();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        assertTrue(promotionalOffersFlow.isAcceptedPromotionsSaved(), "Promotions \"Yes\" position is not saved");
        promotionalOffersFlow.navigateBack();
        accountSettingsFlow.navigateBack();
    }

    @TmsLink("6245")
    @Description(" User enters age 21 or more after tap \"Promotional Settings\" if birthday field was empty")
    @Test
    public void acceptanceToChangePromotionalSettingsAfterFillTheBirthdayFieldTest() {

        customerDto = testData.registerNewCustomer(NOT_SPECIFIED_BIRTHDATE);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();


        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();
        assertFalse(promotionalOffersFlow.isOkFieldEditable(), "Ok field is editable");
        assertTrue(promotionalOffersFlow.isPopUpDescriptionDisplayed(), "Pop up description is not displayed");

        String customerBirth = testData.generateDateBirth();
        promotionalOffersFlow.enterBirthDate(customerBirth);
        promotionalOffersFlow.clickCancelBtnOnTheBirthdayPopUpField();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), "Account settings screen is not opened");

        accountSettingsFlow.navigateToPromotionalSettings();
        assertFalse(promotionalOffersFlow.isOkFieldEditable(), "Ok field is editable");
        assertTrue(promotionalOffersFlow.isPopUpDescriptionDisplayed(), "Pop up description is not shown");

        promotionalOffersFlow.enterBirthDate(customerBirth);
        promotionalOffersFlow.clickOkBtnOnTheEnterBirthdayPopUp();

        promotionalOffersFlow.waitUntilOkBtnAvailable();
        promotionalOffersFlow.clickCancelBtnOnTheBirthdayPopUpField();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened());
        signOutFlow.clickOnSignOutBtn();
        locationRequestFlow.clickNotNow();

        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToPromotionalSettings();

        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotions Page is not opened");
        promotionalOffersFlow.acceptPromotions();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");

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