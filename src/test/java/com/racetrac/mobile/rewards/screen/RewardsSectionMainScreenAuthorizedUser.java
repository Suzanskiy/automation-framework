package com.racetrac.mobile.rewards.screen;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.AccountProvider;
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

public class RewardsSectionMainScreenAuthorizedUser extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignOutFlow signOutFlow;
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
    CustomerDto customerDto;

    private static final int AVAILABLE_POINTS = 100;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }

    @TmsLink("7295")
    @Description("Authorized user without points can go to and see \"Points & Levels\" screen")
    @Test
    public void rewardsScreenForUserWithoutPointsTest() {
        customerDto = testData.registerNewCustomer();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        assertTrue(welcomeFlow.isZeroPointsDescriptionDisplayed());
        pointsAndLevelsFlow.clickOnHeroLevelHelpBtn();
        assertTrue(pointsAndLevelsFlow.isPointsAndLevelsPageOpened(), "Points & Levels page is not opened");
        pointsAndLevelsFlow.clickOnCloseActivityBtn();
    }

    @TmsLink("7296")
    @Description("Authorized user with points can go to and see \"Rewards Catalog\" screen")
    @Test
    public void rewardsScreenForUserWithPointsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        assertTrue(welcomeFlow.isRewardsSectionForUserWithPointsDisplayed(), "Rewards section is not displayed");
        assertEquals(welcomeFlow.availablePoints(),AVAILABLE_POINTS);

        pointsAndLevelsFlow.clickOnHeroLevelHelpBtn();
        assertTrue(pointsAndLevelsFlow.isPointsAndLevelsPageOpened(), "Points & Levels page is not opened");
        pointsAndLevelsFlow.clickOnCloseActivityBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn());
        welcomeFlow.clickOnRedeemPointsBtn();

        rewardsPopupFlow.waitUntilMessageAvailable();
        assertTrue(rewardsPopupFlow.isRedeemPopUpHintDisplayed(), "redeem Pop-Up hint is not displayed");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened());
        assertEquals(rewardsCatalogFlow.availablePoints(), AVAILABLE_POINTS);
        rewardsCatalogFlow.closeRewardsCatalog();
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
    }
}
