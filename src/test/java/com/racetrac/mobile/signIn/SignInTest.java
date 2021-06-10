package com.racetrac.mobile.signIn;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
    }

    @TmsLink("2718")
    @Description("Is user can proceed Sign up flow")
    @Test
    public void isUserAbleToSignInTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(signInFlow.isCouponsViewOpened(), "Coupons view is not opened after signUp");
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    }

    @AfterMethod
    public void tearDown() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
