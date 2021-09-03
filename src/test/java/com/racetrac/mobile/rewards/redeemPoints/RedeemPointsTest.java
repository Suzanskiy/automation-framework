package com.racetrac.mobile.rewards.redeemPoints;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.AccountProviderImpl;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NoPointsNoticeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.NO_POINTS_TO_EXCHANGE_TEXT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RedeemPointsTest extends BaseTest {

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
        assertFalse(welcomeFlow.isRedeemPointsBtnDisplayed(), " Redeem points is displayed");
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
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickOnRedeemPointsBtn();
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
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward Popup is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        assertTrue(rewardsCatalogFlow.isUnclaimedRewardsIsDisplayed(), " Unclaimed Rewards is not displayed");
        assertTrue(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        //Getting sad smile until Bottle of water will not returned //// FIXME: 03.09.2021
        assertFalse(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
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
