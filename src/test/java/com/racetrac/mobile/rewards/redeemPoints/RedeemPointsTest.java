package com.racetrac.mobile.rewards.redeemPoints;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.AccountProviderImpl;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.NO_POINTS_TO_EXCHANGE_TEXT;
import static org.testng.Assert.*;

public class RedeemPointsTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    CustomerDto customerDto;
    @Autowired
    RewardsCatalogFlow rewardsCatalogFlow;
    @Autowired
    NoPointsNoticeFlow noPointsNoticeFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;

    private static final int AVAILABLE_POINTS = 350;
    private static final int NOT_ENOUGH_POINT = 30; // The minimum rewards price start from the 50c

    @TmsLink("7301")
    @Description(" Open \"Rewards Catalog\" from \"Rewards\" tab on the \"Home\" screen")
    @Test
    public void userWithoutAnyPointsTest() {
        customerDto = testData.registerNewCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertFalse(welcomeFlow.isRedeemPointsBtnDisplayedOnMainScreen(), " Redeem points is displayed");
    }

    @TmsLink("7640")
    @Description("Redeem reward if user does not have enough points(30)")
    @Test
    public void redeemPointsWithUserHasNoEnoughPointsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, NOT_ENOUGH_POINT);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward Popup is not opened");
        rewardsPopupFlow.clickGotItBtn();
        rewardsCatalogFlow.clickRedeemBtn();
        noPointsNoticeFlow.waitUntilNoPointsNoticeShown();
        assertEquals(noPointsNoticeFlow.getNotificationMessages(), NO_POINTS_TO_EXCHANGE_TEXT);
        noPointsNoticeFlow.clickOK();
    }

    @TmsLink("7633")
    @Description("User can only redeem one Fuel Reward in his card at a time")
    @Test
    public void impossibleToUseTwiceFuelRewardTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, AVAILABLE_POINTS);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.clickOnRedeemPointsBtn();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward Popup is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        rewardsCatalogFlow.isRewardsCatalogPageOpened();
        assertTrue(rewardsCatalogFlow.isUnclaimedRewardsIsDisplayed(), " Unclaimed Rewards is not displayed");
        assertTrue(rewardsCatalogFlow.isQuantityOfPointsEnough(), "The number of points is not enough to make redeem");
        rewardsCatalogFlow.clickRedeemBtn();
        rewardsCatalogFlow.clickRedeemOnPopupBtn();
        //Getting sad smile until Bottle of water will not returned //// FIXME: 03.09.2021
        rewardsCatalogFlow.waitUntilSadSmilePopUpShown();
        assertTrue(rewardsCatalogFlow.isSadSmilePopUpShown(), "Sad Smile view is not showed");
    }
}
