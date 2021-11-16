package com.racetrac.mobile.signUp;

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
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {
    public static final String EMAIL_LINKED_MESSAGE = "This email is already linked to an existing account! Try signing in or sign up using another email address.";
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    BecomeFuelVipFlow becomeFuelVipFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    CustomerDto customerDto;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    PopupCloserFlow popupCloserFlow;


    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        customerDto = testData.generateDefaultCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
    }

    @TmsLink("2714")
    @Description("Is user able to proceed signUp procedure")
    @Test
    public void signUpTest() {
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
        signOutFlow.doSignOut();
        popupCloserFlow.closePopups();
    }

    @TmsLink("2715")
    @Description("Is error message appear when email is used by UI")
    @Test
    public void isErrorMessageAppearWhenEmailIsUsedTest() {
        signUpFlow.enterCredentials(customerDto);
        assertTrue(signUpFlow.isFistBumpPageOpened(), "Fist Bump screen is not opened");
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
        signUpFlow.enterCredentials(customerDto);
        assertTrue(signUpFlow.isErrorMessageShown(), "Error message not shown");
        assertEquals(signUpFlow.getErrorMessageText(),
                EMAIL_LINKED_MESSAGE);
        signUpFlow.closeErrorMessage();
    }

    @TmsLink("2716")
    @Description("Is error message appear when email is used by API")
    @Test
    public void isErrorMessageAppearWhenEmailRegisteredByApiTest() {
        signUpFlow.enterCredentials(testData.registerNewCustomer());
        signUpFlow.waitUntilErrorMessageShown();
        assertTrue(signUpFlow.isErrorMessageShown(), "Error message not shown");
        assertEquals(signUpFlow.getErrorMessageText(),
                EMAIL_LINKED_MESSAGE);
        signUpFlow.closeErrorMessage();
    }
}
