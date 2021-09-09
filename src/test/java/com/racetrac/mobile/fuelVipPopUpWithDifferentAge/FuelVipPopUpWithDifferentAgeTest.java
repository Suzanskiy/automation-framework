package com.racetrac.mobile.fuelVipPopUpWithDifferentAge;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FuelVipPopUpWithDifferentAgeTest extends BaseTest {
    private static final int ageUnder21 = 19;
    private static final int ageOver21 = 22;

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
    }

    @TmsLink("6413")
    @Description("Become a Rewards VIP pop-up is displayed only after first Sign In as User with age < 21")
    @Test
    public void becomeVipPopUpWhenUserUnder21AgeTest() {
        customerDto = testData.generateCustomer(ageUnder21);
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.isFistBumpPageOpened();
        signUpFlow.clickGetStartedBtn();
        locationRequestFlow.clickNotNow();
        assertTrue(becomeFuelVipFlow.checkAllElementsIsLoaded(), "Elements are not loaded");
        becomeFuelVipFlow.clickNotRightNow();
        locationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();

    }

    @TmsLink("6414")
    @Description("Become a Rewards VIP pop-up is displayed only after first Sign In as User with age > 21")
    @Test
    public void becomeVipPopUpWhenUserOver21AgeTest() {
        customerDto = testData.generateCustomer(ageOver21);
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.isFistBumpPageOpened();
        signUpFlow.clickGetStartedBtn();

        notificationRequestFlow.clickNotNow();

      //  promotionalOffersFlow.skipPromotions();
      //  locationRequestFlow.clickNotNow();
        assertTrue(becomeFuelVipFlow.checkAllElementsIsLoaded(), "Elements are not loaded");
        becomeFuelVipFlow.clickNotRightNow();
        promotionalOffersFlow.skipIOSPromotions();

        locationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        signOutFlow.doSignOut();
    }

}

