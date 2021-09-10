package com.racetrac.mobile.rewardsCatalog;

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

import static org.testng.Assert.*;

public class RewardsCatalogTest extends BaseTest {
    private static final int AVAILABLE_POINTS = 600;
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    RewardsCatalogFlow rewardsCatalogFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

    }

    @TmsLink("7298")
    @Description("\"Rewards Catalog\" is hidden from side menu for non-logged User")
    @Test
    public void hiddenRewardsCatalogTest() {
        navigationFlow.drawerClick();
        assertFalse(navigationFlow.isRewardCatalogDisplayed(), "Rewards catalog is diplayed");
    }

    @TmsLink("7302")
    @Description("Open \"Rewards catalog\" from side menu")
    @Test
    public void openRewardsCatalogFromSideMenuTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        navigationFlow.drawerClick();
        assertTrue(navigationFlow.isRewardCatalogDisplayed(), "Rewards catalog is not displayed");
        navigationFlow.rewardCatalogClick();
        assertTrue(rewardsPopupFlow.isRedeemPopUpHintDisplayed(), "Redeem Popup Hint is not displayed");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Rewards catalog is not opened");
        assertEquals(rewardsCatalogFlow.availablePoints(), AVAILABLE_POINTS, "Invalid points are displayed");
        assertTrue(rewardsCatalogFlow.isElementsOfRewardsCatalogDisplayed(), "Elements of rewards catalog are not displayd");
    }


    @TmsLink("7301")
    @Description("Open \"Rewards catalog\" from \"Rewards tab\" on the \"Home\" screen")
    @Test
    public void openRewardsCatalogFromHomeScreenTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRedeemPopUpHintDisplayed(), "Redeem Popup Hint is not displayed");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Rewards catalog is not opened");
        assertEquals(rewardsCatalogFlow.availablePoints(), AVAILABLE_POINTS, "Invalid points are displayed");
        assertTrue(rewardsCatalogFlow.isElementsOfRewardsCatalogDisplayed(), "Elements of rewards catalog are not displayd");
        rewardsCatalogFlow.closeRewardsCatalog();
    }

    @TmsLink("7303")
    @Description("\"Available points\" shows appropriate value")
    @Test
    public void isAvailablePointsShowsAppropriateValueTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRedeemPopUpHintDisplayed(), "Redeem Popup Hint is not displayed");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Rewards catalog is not opened");
        assertEquals(rewardsCatalogFlow.availablePoints(), AVAILABLE_POINTS, "Invalid points are displayed");
        assertTrue(rewardsCatalogFlow.isElementsOfRewardsCatalogDisplayed(), "Elements of rewards catalog are not displayd");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        assertEquals(rewardsCatalogFlow.availablePoints(), AVAILABLE_POINTS - rewardsCatalogFlow.rewardPrice(), "Invalid AVAILABLE_POINTS displayed");

    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
    }


}
