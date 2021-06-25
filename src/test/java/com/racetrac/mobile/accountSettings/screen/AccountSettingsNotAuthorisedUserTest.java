package com.racetrac.mobile.accountSettings.screen;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountSettingsNotAuthorisedUserTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;

    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

    }

    @TmsLink("5468")
    @Description("Account Settings screen for Guest User")
    @Test
    public void accountSettingsScreenForGuestUserTest() {
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsScreenOpened(), " Account screen is not opened");
    }

    @TmsLink("")
    @Description("")
    @Test
    public void accountSettingsScreenForUserUnder21Test() {
        customerDto = testData.registerNewCustomer(20);

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
        accountSettingsFlow.closeAccountSettingsScreen();
    }

    @TmsLink("")
    @Description("")
    @Test
    public void accountSettingsScreenForAdultUser() {
    }
}