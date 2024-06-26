package com.racetrac.mobile.accountSettings.email;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
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
    SignUpFlow signUpFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PopupCloserFlow popupCloserFlow;
    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("6504")
    @Description("Settings - \"Receive Emails?\" option is hidden for Guest users")
    @Test
    public void accountSettingsScreenForGuestUserTest() {
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsScreenOpened(), " Account screen is not opened");
        assertFalse(accountSettingsFlow.isReceiveEmailsDisplayed(), " Receive emails is displayed");
    }

    @TmsLink("6505")
    @Description("Settings - \"Receive Emails?\" switch is turned on if User checked \"Yes...\"checkbox during registration")
    @Test
    public void receiveEmailSwitchedOnTest() {
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");

        customerDto = testData.generateCustomerWithoutBirthdate();
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.isFistBumpPageOpened();
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened();
        assertTrue(accountSettingsFlow.receiveEmailsSwitcherPosition(), "Receive Email switcher position is off");
    }

    @TmsLink("6506")
    @Description("Settings - \"Receive Emails?\" switch is turned off if User unchecked \"Yes...\"checkbox during registration")
    @Test
    public void receiveEmailSwitchedOffTest() {
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");

        customerDto = testData.generateCustomerWithoutBirthdate();
        signUpFlow.enterCredentialsWithoutEmailReceive(customerDto);
        signUpFlow.isFistBumpPageOpened();
        signUpFlow.clickGetStartedBtn();
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        becomeFuelVipFlow.waitUntilBecomeFuelVipLoaded();
        assertTrue(becomeFuelVipFlow.isBecomeFuelVipPageOpened(), "Elements are not loaded");

        becomeFuelVipFlow.clickNotRightNow();
        signInFlow.clickGotItBtn();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened();
        assertFalse(accountSettingsFlow.receiveEmailsSwitcherPosition(), "Receive Email switcher position is on");
    }

}
