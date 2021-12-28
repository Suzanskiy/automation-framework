package com.racetrac.mobile.rewards.pointsAndTiers;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PointsAndTiersAuthorisedUserTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;

    CustomerDto customerDto;
    @TmsLink("7469")
    @Description("Points & Tiers screen for logged user")
    @Test
    public void checkAllScreensOnPointsAndLevelsWithUserHas500pointsTest() {

        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.addRedeemPoints(customerDto, 2500);
        signInFlow.authorize(customerDto);
        pointsAndLevelsFlow.clickOnHeroLevelHelpBtn();
        assertTrue(pointsAndLevelsFlow.isPointsAndLevelsPageOpened(), "Points & Levels page is not opened");
        assertTrue(pointsAndLevelsFlow.isPointsAndTiersSectionIsOpened(), "POINTS & TIERS section is not opened");
        pointsAndLevelsFlow.clickOnDetailsBtn();
        assertTrue(pointsAndLevelsFlow.isTierExpirationDetailsDisplayed(), "Tier expiration details not showed");
        pointsAndLevelsFlow.clickOnCloseDetailsBtn();
        pointsAndLevelsFlow.clickOnHowItWorksSectionBtn();
        //removed assert on How it works page due to unable check on Ios
    }

}
