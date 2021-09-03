package com.racetrac.mobile.rewardsCatalog;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.SubscriptionRequestClient;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RewardsCatalogTest extends BaseTest {
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
    FuelVipFlow fuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    SubscriptionRequestClient subscriptionRequestClient;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    NavigationFlow navigationFlow;

    @BeforeMethod
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

    }

    @TmsLink("7298")
    @Description("\"Rewards Catalog\" is hidden from side menu for non-logged User")
    @Test
    public void hiddenRewardsCatalogTest(){
    navigationFlow.drawerClick();
    assertFalse(navigationFlow.isRewardCatalogDisplayed());
    };

    @TmsLink("7302")
    @Description("Open ""\"Rewards Catalog\"  from side menu for non-logged User")
    @Test
    public void hiddenRewardsgTest(){
    navigationFlow.drawerClick();
    assertFalse(navigationFlow.isRewardCatalogDisplayed());
    };




}
