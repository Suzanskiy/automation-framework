package com.racetrac.mobile.pointAndSaving;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PointSaveTest extends BaseTest {

    private static final int AVAILABLE_POINT = 1;
    private static final int AVAILABLE_POINT_FIVE_HUNDRED = 499;
    private static final int AVAILABLE_POINTS_BILLION = 99999499;

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    CustomerDto customerDto;
    @Autowired
    PopupCloserFlow popupCloserFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        popupCloserFlow.closePopups();
    }

    @TmsLink("7147")
    @Description("Point and savings displaying in account settings screen")
    @Test
    public void isAvailablePointsShowsAppropriateValueTest() {
        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.waitUntilAccountSettingsAuthorizedOpen();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        assertEquals(accountSettingsFlow.getLifeTimePointsAmount(), "0");
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINT);
        accountSettingsFlow.closeAccountSettingsScreen();
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        assertEquals(accountSettingsFlow.getLifeTimePointsAmount(), "1");
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINT_FIVE_HUNDRED);
        accountSettingsFlow.closeAccountSettingsScreen();
        accountSettingsFlow.navigateToAccountSettings();
        assertEquals(accountSettingsFlow.getLifeTimePointsAmount(), "500");
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS_BILLION);
        accountSettingsFlow.closeAccountSettingsScreen();
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
        assertEquals(accountSettingsFlow.getLifeTimePointsAmount(), "99999999");
    }
}
