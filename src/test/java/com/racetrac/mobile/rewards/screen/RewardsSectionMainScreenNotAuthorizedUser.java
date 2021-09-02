package com.racetrac.mobile.rewards.screen;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RewardsSectionMainScreenNotAuthorizedUser extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;

    @TmsLink("7294")
    @Description(" Not authorized user can see \"Rewards\" section on the main screen")
    @Test
    public void RewardsSectionMainScreenNotAuthorizedUserTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        assertTrue(welcomeFlow.isRewardsScreenFOrUserWithoutPointsDisplayed(),"Rewards screen is not displayed");
    }

}
