package com.racetrac.mobile.rewards.rewardsCheckout;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RewardsCheckoutTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    @Autowired
    RewardsCatalogFlow rewardsCatalogFlow;
    @Autowired
    RewardsCheckoutBarcodeFlow rewardsCheckoutFlow;
    @Autowired
    CheckoutBtnFLow checkoutBtnFLow;
    @Autowired
    FuelVipFlow fuelVipFlow;
    @Autowired
    UnclaimedRewardsCheckoutFlow unclaimedRewardsCheckoutFlow;

    CustomerDto customerDto;

    private static final int AVAILABLE_POINTS = 200;
    private static final int UNCLAIMED_REWARDS_COUNTER = 1;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("7634")
    @Description("\"Rewards Cards\" option in the side menu redirects to the \"Checkout\" screen")
    @Test
    public void rewardsSideMenuCheckoutTest() {
        customerDto = testData.registerNewCustomer();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        navigationFlow.navigateToRewardsCards();
        assertTrue(rewardsCheckoutFlow.isRewardsCheckoutBarcodePageOpen(),"Rewards checkout page is not opened");
        rewardsCheckoutFlow.closeRewardsCheckoutPage();
    }
    @TmsLink("7248")
    @Description("\"Rewards Cards\" option in the side menu redirects to the \"Checkout\" screen")
    @Test
    public void unclaimedRewardsCounterTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward Popup is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(),"Rewards catalog page is not opened");
        assertEquals(rewardsCatalogFlow.getUnclaimedRewardsCounter(),UNCLAIMED_REWARDS_COUNTER,"Counters are not equals");
        rewardsCatalogFlow.closeRewardsCatalog();

        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn());
        assertTrue(checkoutBtnFLow.isCheckoutBtnDisplayed(), "Checkout button is not displayed");
        assertEquals(checkoutBtnFLow.getCheckoutBtnCounter(),UNCLAIMED_REWARDS_COUNTER,"Counters are not equals");
        checkoutBtnFLow.clickOnCheckoutBtn();

        assertTrue(rewardsCheckoutFlow.isRewardsCheckoutBarcodePageOpen(),"Rewards checkout page is not opened");
        assertEquals(rewardsCheckoutFlow.getUnclaimedRewardsCounter(),UNCLAIMED_REWARDS_COUNTER,"Counters are not equals");
        rewardsCheckoutFlow.clickOnDoneBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn());

        fuelVipFlow.navigateToFuelVipSection();
        checkoutBtnFLow.clickOnCheckoutBtn();
        assertTrue(rewardsCheckoutFlow.isRewardsCheckoutBarcodePageOpen(),"Rewards checkout page is not opened");
        assertEquals(rewardsCheckoutFlow.getUnclaimedRewardsCounter(),UNCLAIMED_REWARDS_COUNTER,"Counters are not equals");
        rewardsCheckoutFlow.goToUnclaimedRewardsPage();
        assertTrue(unclaimedRewardsCheckoutFlow.isUnclaimedRewardsCheckoutPageOpen(),"Unclaimed rewards page is not opened");
        unclaimedRewardsCheckoutFlow.closeRewardsCheckoutPage();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn());
    }

    @AfterMethod
    public void logOut() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
