package com.racetrac.mobile.rewards.pointsAndTiers;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PointsAndTiersTestNotAuthorisedUser extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @TmsLink("7468")
    @Description("No ? link to Points & Tiers screen for non-logged user")
    @Test
    public void checkThereIsNoHeroLevelHelpBtn() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        assertFalse(welcomeFlow.isHeroLevelHelpBtnDisplayed(), "Hero level help btn is displayed");
    }
}
