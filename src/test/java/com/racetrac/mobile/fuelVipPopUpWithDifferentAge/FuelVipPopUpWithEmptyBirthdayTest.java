package com.racetrac.mobile.fuelVipPopUpWithDifferentAge;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FuelVipPopUpWithEmptyBirthdayTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    PopupCloserFlow popupCloserFlow;
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
    @Description("Become a Rewards VIP pop-up is displayed after first Sign In as User with empty birthday")
    @Test
    public void becomeVipPopUpWhenUserRegisterWithoutBirthday() {
        customerDto = testData.generateCustomerWithoutBirthdate();
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.isFistBumpPageOpened();
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
    }

}
