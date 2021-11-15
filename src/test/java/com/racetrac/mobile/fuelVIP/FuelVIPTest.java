package com.racetrac.mobile.fuelVIP;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.SubscriptionRequestClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeDown;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FuelVIPTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    ChromeBrowserHandler chromeBrowserHandler;
    @Autowired
    FuelVipFlow fuelVipFlow;
    @Autowired
    SubscriptionRequestClient subscriptionRequestClient;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    CustomerDto customerDto;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
        chromeBrowserHandler.prepareBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
    }

    @TmsLink("6157")
    @Description("Authorized User with no subscription")
    @Test
    public void redirectForAuthorisedUserWithoutSubscriptionTest() throws InterruptedException {
        // TODO: 06.07.2021 Change desiredRedirect url to racetrac.com when migrate
        fuelVipFlow.navigateToFuelVipSection();
        fuelVipFlow.clickLearnMoreNoSubscription();
        final String openedUrl = chromeBrowserHandler.getUrl();
        chromeBrowserHandler.returnBackToApp();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertEquals(openedUrl, chromeBrowserHandler.getDesiredRedirectUrlNoSubscription());
    }

    @TmsLink("6200")
    @Description("Authorized User with purchased active subscription")
    @Test
    public void redirectForUnauthorisedUserWithActiveSubscriptionTest() throws InterruptedException {

        subscriptionRequestClient.requestDefaultSubscriptionPlan(customerDto);
        fuelVipFlow.navigateToFuelVipSection();
        swipeDown();//update page
        fuelVipFlow.clickVipProgramDetails();
        final String openedUrl = chromeBrowserHandler.getUrl();
        chromeBrowserHandler.returnBackToApp();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertEquals(openedUrl, chromeBrowserHandler.getDesiredRedirectUrlActiveSubscription());
    }

}