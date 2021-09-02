package com.racetrac.mobile.rewards.redeemPoints;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.AccountProviderImpl;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.NO_POINTS_TO_EXCHANGE_TEXT;
import static org.testng.Assert.*;

public class ReedemPoints extends BaseTest {

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
    CustomerDto customerDto;
    @Autowired
    AccountProviderImpl accountProviderImpl;
    @Autowired
    RewardsCatalogFlow rewardsCatalogFlow;
    @Autowired
    NoPointsNoticeFlow noPointsNoticeFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void userWithoutAnyPointsTest() {
        customerDto = testData.registerNewCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertFalse(welcomeFlow.isRedeemPointsIsDisplayed(), " Redeem points is displayed");
    }

    @Test
    public void redeemPointsWithUserHas50pointsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, 50);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickRedeemPointsBtn();
        rewardsPopupFlow.clickGotItBtn();
        rewardsCatalogFlow.clickRedeemBtn();
        assertEquals(noPointsNoticeFlow.getNotificationMessages(), NO_POINTS_TO_EXCHANGE_TEXT);
        noPointsNoticeFlow.clickOK();
        rewardsCatalogFlow.navigateBack();
    }

    @Test
    public void redeemPointsWithUserHas130pointsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, 350);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward Popup is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isNumberOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemPopupBtn();
//        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(),"Rewards Catalog page is not opened");
        assertTrue(rewardsCatalogFlow.isUnclaimedRewardsIsDisplayed(), " Unclaimed Rewards is not displayed");
        assertTrue(rewardsCatalogFlow.isNumberOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemPopupBtn();
        assertFalse(rewardsCatalogFlow.isNumberOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        assertEquals(noPointsNoticeFlow.getNotificationMessages(), NO_POINTS_TO_EXCHANGE_TEXT);
        noPointsNoticeFlow.clickOK();
        rewardsCatalogFlow.navigateBack();
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
