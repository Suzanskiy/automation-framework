package com.racetrac.mobile.accountSettings.birhday;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;
import static org.testng.Assert.assertTrue;

public class AccountSettingsChangeBirthDayTest extends BaseTest {
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
    @Autowired
    ProfileFlow profileFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;

    CustomerDto customerDto;


    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
    }


    @TmsLink("6096")
    @Description("\"Birthday\" field is not editable for Users who set birthday")
    @Test
    public void BirthDateNotEditableTest() { // FIXME: 04.08.2021 rewards + coupons view

        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();

        // TODO: 10.08.2021 Check code above on Android, because on ios those line not needed
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToProfile();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");
        profileFlow.clickOnBirthDayField();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");

    }

    @TmsLink("6097")
    @Description("\"Birthday\" field can be set only once")
    @Test
    public void BirthDayFieldCanBeSetOnceTest() {
        customerDto = testData.registerNewCustomer(CustomerAge.NOT_SPECIFIED_BIRTHDATE);

        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        // TODO: 10.08.2021 same
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToProfile();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");
        String customerBirth = testData.generateDateBirth();
        profileFlow.clickOnBirthDayField();
        profileFlow.enterBirthDate(customerBirth);
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToProfile();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");

        profileFlow.clickOnBirthDayField();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");

    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        profileFlow.navigateBack();
        accountSettingsFlow.navigateBack();
        pointsAndLevelsFlow.clickGotItBtn();
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}