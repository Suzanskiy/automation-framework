package com.racetrac.mobile.accountSettings.password;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditPasswordFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.util.CommonUtils;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.TestDataImpl.EMAIL_DOMAIN;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;
import static org.testng.Assert.assertTrue;

public class AccountSettingsChangePasswordTest extends BaseTest {
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
    EditPasswordFlow editPasswordFlow;
    @Autowired
    EditEmailFlow editEmailFlow;

    CustomerDto customerDto;


    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

        customerDto = testData.registerNewCustomer();

        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();

        assertTrue(signInFlow.isCouponsViewOpened(), "Coupons view is not opened after signUp");
        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
    }

    @TmsLink("5485")
    @Description("Log in after password change")
    @Test
    public void loginAfterPasswordChangeTest() {
        final String password = "NewPassword123!";

        accountSettingsFlow.navigateToProfile();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");
        profileFlow.navigateToPasswordChange();
        assertTrue(profileFlow.isPasswordChangeScreenOpened(), "Password Change screen is not opened");

        this.customerDto = editPasswordFlow.editPassword(customerDto, password);
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");

        pressBackBtn();
        pressBackBtn();

        //   pressBackBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        signOutFlow.doSignOut();
        locationRequestFlow.clickNotNow();
        welcomeFlow.isHomePageOpenedAfterSignIn();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        assertTrue(signInFlow.isCouponsViewOpened(), "Coupons view is not opened after signUp");
        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    }

    @TmsLink("5585")
    @Description("Log in after email change")
    @Test
    public void loginAfterEmailChangeTest() {
        final String newEmail = CommonUtils.generateEmail(EMAIL_DOMAIN);

        accountSettingsFlow.navigateToProfile();
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");
        profileFlow.navigateToEmailChange();
        assertTrue(profileFlow.isEmailChangeScreenOpened(), "Email Change screen is not opened");

        this.customerDto = editEmailFlow.editEmail(customerDto, newEmail);
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");
        pressBackBtn();
        pressBackBtn();

        pointsAndLevelsFlow.clickGotItBtn();

        signOutFlow.doSignOut();
        locationRequestFlow.clickNotNow();
        welcomeFlow.isHomePageOpenedAfterSignIn();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        assertTrue(signInFlow.isCouponsViewOpened(), "Coupons view is not opened after signUp");
        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    }


    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}