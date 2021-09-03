package com.racetrac.mobile.rewards.pointsAndTiers;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.AccountProvider;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PointsAndTiersTestAuthorisedUser extends BaseTest {
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
    AccountProvider accountProvider;
    @Autowired
    PunchhPointsClient punchhPointsClient;

    CustomerDto customerDto;

    @Test
    public void checkAllScreensOnPointsAndLevelsWithUserHas500pointsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, 500);
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        pointsAndLevelsFlow.clickOnHeroLevelHelpBtn();
        assertTrue(pointsAndLevelsFlow.isPointsAndLevelsPageOpened(), "Points & Levels page is not opened");
        assertTrue(pointsAndLevelsFlow.isPointsAndTiersSectionIsOpened(), "POINTS & TIERS section is not opened");
        pointsAndLevelsFlow.clickOnDetailsBtn();
        assertTrue(pointsAndLevelsFlow.isTierExpirationDetailsDisplayed(), "Tier expiration details not showed");
        pointsAndLevelsFlow.clickOnCloseDetailsBtn();
        pointsAndLevelsFlow.clickOnHowItWorksSectionBtn();
        //removed assert on How it works page due to unable check on Ios
    }

    @AfterMethod
    public void logOut() {
        pointsAndLevelsFlow.clickOnCloseActivityBtn();
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
