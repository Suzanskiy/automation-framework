package com.racetrac.mobile.accountSettings.email;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.util.CommonUtils;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.TestDataImpl.EMAIL_DOMAIN;
import static org.testng.Assert.assertTrue;

public class AccountSettingsChangeEmailTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    ProfileFlow profileFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
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
        notificationRequestFlow.iosClickNotNow();
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();

        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
    }


    @TmsLink("5585")
    @Description("Log in after email change")
    @Test
    public void loginAfterEmailChangeTest() {
        final String newEmail = CommonUtils.generateEmail(EMAIL_DOMAIN);

        accountSettingsFlow.navigateToProfile();
        profileFlow.waitUntilProfilePageOpened();
        profileFlow.navigateToEmailChange();
        assertTrue(profileFlow.isEmailChangeScreenOpened(), "Email Change screen is not opened");

        this.customerDto = editEmailFlow.editEmail(customerDto, newEmail);
        assertTrue(accountSettingsFlow.isProfileScreenOpened(), "Profile screen is not opened");

        profileFlow.navigateBack();
        accountSettingsFlow.navigateBack();

        pointsAndLevelsFlow.clickGotItBtn();
        signOutFlow.doSignOut();
        locationRequestFlow.clickContinue();
        welcomeFlow.isHomePageOpenedAfterSignIn();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        notificationRequestFlow.iosClickNotNow();
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    }

    @TmsLink("5875")
    @Description("User cannot change email to an existing one")
    @Test
    public void userCannotChangeEmailToAnExistingOneTest() { // not working on IOS passwordBtn emailBtn no selectors
        final String usedEmail = "admin@epam.com";

        accountSettingsFlow.navigateToProfile();
        profileFlow.waitUntilProfilePageOpened();
        profileFlow.navigateToEmailChange();
        assertTrue(profileFlow.isEmailChangeScreenOpened(), "Email Change screen is not opened");

        this.customerDto = editEmailFlow.editEmail(customerDto, usedEmail);
        assertTrue(signUpFlow.isErrorMessageShown(), "Error message not shown");
        signUpFlow.closeErrorMessage();
// FIXME: 29.06.2021 add error message validation when error massage will be changed
        editEmailFlow.navigateBack();
        profileFlow.navigateBack();
        accountSettingsFlow.navigateBack();
        accountSettingsFlow.navigateBack();
        pointsAndLevelsFlow.clickGotItBtn();
    }

}