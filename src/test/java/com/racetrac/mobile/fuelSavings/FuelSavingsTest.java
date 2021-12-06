package com.racetrac.mobile.fuelSavings;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.multisite.racetrac.flow.impl.FuelSavingsFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FuelSavingsTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    FuelSavingsFlow fuelSavingsFlow;
    @Autowired
    ChromeBrowserHandler chromeBrowserHandler;
    CustomerDto customerDto;

    @TmsLink("9208")
    @Description("Fuel Savings is displayed for authorized user")
    @Test
    public void checkFuelSavingsAuthorizedUserTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);
        assertTrue(welcomeFlow.isFuelSavingsBtnDisplayed());
        welcomeFlow.clickFuelSavingsBtn();
        assertTrue(fuelSavingsFlow.isFuelSavingsPageOpened(), "Fuel Savings page is not opened");
        assertTrue(fuelSavingsFlow.checkAllFuelSavingsElementsAreLoaded(), "Fuel Savings elements are not loaded");
        fuelSavingsFlow.navigateToFuelSavingsDebitCard();
        assertTrue(fuelSavingsFlow.checkAllDebitCardElementsAreLoaded(), "Fuel Debit card elements are not loaded");
        fuelSavingsFlow.navigateBackFromDebitCard();
        fuelSavingsFlow.navigateToFuelSavingsVip();
        assertTrue(fuelSavingsFlow.checkAllVipElementsAreLoaded(), "Fuel VIP elements are not loaded");
        fuelSavingsFlow.navigateBackFromVip();
        fuelSavingsFlow.navigateToFuelSavingsRewards();
        assertTrue(fuelSavingsFlow.checkAllRewardsElementsAreLoaded(), "Fuel Rewards Elements are not loaded");
        fuelSavingsFlow.navigateBackFromRewards();
        fuelSavingsFlow.navigateBackToWelcomePage();
        welcomeFlow.openVipSection();
        welcomeFlow.clickFuelSavingsBtn();
    }

    @TmsLink("9207")
    @Description("Fuel Savings is not displayed for unauthorized user")
    @Test
    public void checkFuelSavingsUnauthorizedUserTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Home page is not opened");
        assertFalse(welcomeFlow.isFuelSavingsBtnDisplayed(), "Fuel Savings banner is displayed");
        welcomeFlow.openVipSection();
        assertFalse(welcomeFlow.isFuelSavingsBtnDisplayed(), "Fuel Savings banner is displayed");
    }
}
