package com.racetrac.mobile.rewards.pointsAndTiers;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.data.AccountProvider;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
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

    CustomerDto customerDto;
    @Autowired
    AccountProvider accountProvider;

    @Test
    public void checkAllScreensOnPointsAndLevelsWithUserHas500pointsTest() {
        customerDto = accountProvider.getCustomerWith500Points();
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
        pointsAndLevelsFlow.clickOnHeroLevelHelpBtn();
        assertTrue(pointsAndLevelsFlow.isPointsAndLevelsPageOpened(), "Points & Levels page is not opened");
        assertTrue(pointsAndLevelsFlow.isPointsAndTiersSectionIsOpened(), "POINTS & TIERS section is not opened");
        pointsAndLevelsFlow.clickOnDetailsBtn();
        assertTrue(pointsAndLevelsFlow.isTierExpirationDetailsDisplayed(), "Tier expiration details not showed");
        pointsAndLevelsFlow.clickOnCloseDetailsBtn();
        pointsAndLevelsFlow.clickOnHowItWorksSectionBtn();
        assertTrue(pointsAndLevelsFlow.isHowItWorksSectionIsOpened(), "HOW IT WORKS section is not opened");
        pointsAndLevelsFlow.clickOnCloseActivityBtn();
    }

    @AfterMethod
    public void logOut() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
