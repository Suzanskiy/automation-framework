package com.racetrac.mobile.signOut;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignOutTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    SignOutFlow signOutFlow;
    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(signInFlow.isCouponsViewOpened(), "Coupons view is not opened after signUp");
        signInFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
    }

    @TmsLink("1")
    @Description("Is user able to successfully sign out")
    @Test
    public void isUserAbleToSignOutTest() {
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
    }
}
