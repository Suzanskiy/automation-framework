package com.racetrac.mobile.popUpVIP;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import com.racetrac.mobile.multisite.racetrac.util.BrowserHandler;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class PopUpVipTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    BrowserHandler browserHandler;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PopupCloserFlow popupCloserFlow;
    CustomerDto customerDto;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
        browserHandler.prepareBrowser();
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
        popupCloserFlow.closePopups();

    }

    @TmsLink("6409")
    @Description("User is redirected to RaceTrac site on RaceTrac Rewards VIP tab after click Learn More")
    @Test
    public void redirectionAfterLearnMoreBtn() throws InterruptedException {
        becomeFuelVipFlow.clickLearnMoreBtn();
        final String openedUrl = browserHandler.getUrl();
        browserHandler.returnBackToApp();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(openedUrl.contains(browserHandler.getRaceTracDomain()));
        assertTrue(openedUrl.contains(browserHandler.getBecomeAVipUrlEndpoint()));
        assertTrue(openedUrl.contains(browserHandler.getBecomeAVipUrlParameters()));
    }

    @TmsLink("6413")
    @Description("User is redirected to RaceTrac site on Confirm/Edit Account page after click Get Started page")
    @Test
    public void redirectionAfterGetStartBtn() throws InterruptedException {
        becomeFuelVipFlow.clickGetStartedBtn();
        final String openedUrl = browserHandler.getUrl();
        browserHandler.returnBackToApp();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(openedUrl.contains(browserHandler.getRaceTracDomain()));
        assertTrue(openedUrl.contains(browserHandler.getBecomeAVipUrlEndpoint()));
        assertTrue(openedUrl.contains(browserHandler.getBecomeAVipUrlParameters()));
    }

    @TmsLink("6414")
    @Description("User is redirected to Home Page after click Not Right Now")
    @Test
    public void tapNotRightNowTest() {
        becomeFuelVipFlow.clickNotRightNowBtn();
        promotionalOffersFlow.skipIOSPromotions();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpened());
    }

}
