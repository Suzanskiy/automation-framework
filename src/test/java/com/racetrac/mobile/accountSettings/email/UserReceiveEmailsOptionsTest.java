package com.racetrac.mobile.accountSettings.email;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.framework.enums.CustomerAge;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserReceiveEmailsOptionsTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    ProfileFlow profileFlow;

    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("6504")
    @Description("Settings - \"Receive Emails?\" option is hidden for Guest users")
    @Test
    public void accountSettingsScreenForGuestUserTest() {
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsScreenOpened(), " Account screen is not opened");
        assertFalse(accountSettingsFlow.isReceiveEmailsDisplayed()," Receive emails is displayed");
    }
    @TmsLink("6506")
    @Description("Settings - \"Receive Emails?\" option is hidden for Guest users")
    @Test
    public void accountTest() {
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
    }


}
