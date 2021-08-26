package com.racetrac.mobile.popUpVIP;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopUpVipTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    ChromeBrowserHandler chromeBrowserHandler;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
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
    public void preconditions() {
        customerDto = testData.generateDefaultCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.clickGetStartedBtn();
        promotionalOffersFlow.skipPromotions();
        locationRequestFlow.clickNotNow();
        assertTrue(becomeFuelVipFlow.checkAllElementsIsLoaded(), "Elements are not loaded");

    }

    @TmsLink("6409")
    @Description("User is redirected to RaceTrac site on RaceTrac Rewards VIP tab after click Learn More")
    @Test
    public void redirectionAfterLearnMoreBtn() throws InterruptedException {
        becomeFuelVipFlow.clickLearnMoreBtn();
        final String openedUrl = chromeBrowserHandler.getUrl();
        chromeBrowserHandler.returnBackToApp();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

        assertEquals(openedUrl, chromeBrowserHandler.getLearnMoreRedirectUrl());

    }

    @TmsLink("6413")
    @Description("User is redirected to RaceTrac site on Confirm/Edit Account page after click Get Started page")
    @Test
    public void redirectionAfterGetStartBtn() throws InterruptedException {
        becomeFuelVipFlow.clickGetStartedBtn();
        final String openedUrl = chromeBrowserHandler.getUrl();
        chromeBrowserHandler.returnBackToApp();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

        assertEquals(openedUrl, chromeBrowserHandler.getGetStartedRedirectUrl());// FIXME: 10.08.2021 change url to actual
    }

    @TmsLink("6414")
    @Description("User is redirected to Home Page after click Not Right Now")
    @Test
    public void tapNotRightNowTest() {
        becomeFuelVipFlow.clickNotRightNowBtn();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpened());
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
    }

}
