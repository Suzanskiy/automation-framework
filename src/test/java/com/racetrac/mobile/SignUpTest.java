package com.racetrac.mobile;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        customerDto = testData.generateNewCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpPage();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
    }

    @TmsLink("")
    @Description("")
    @Test
    public void signUpTest() {
        signUpFlow.enterCredentials(customerDto);
        signUpFlow.isEmailConfirmationPageOpened();
    }

    @TmsLink("")
    @Description("")
    @Test
    public void isErrorMessageAppearWhenEmailIsUsedTest() {
        signUpFlow.enterCredentials(customerDto);
        assertTrue(signUpFlow.isEmailConfirmationPageOpened(), "Email Confirmation screen is not opened");
        signUpFlow.returnBackToSignUp();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
        signUpFlow.clickCreateAccountBtn();
        assertTrue(signUpFlow.isErrorMessageShown(), "Error message not shown");
        assertEquals(signUpFlow.getErrorMessageText(),
                "This email is already linked to an existing account! Try signing in or sign up using another email address.");
        signUpFlow.closeErrorMessage();
    }
}
