package com.racetrac.mobile;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    CustomerDto customerDto;

    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
    }

    @Test
    public void isUserAbleToSignIn() {
        welcomeFlow.isHomePageOpened();
        signInFlow.openLoginInPage();
        signInFlow.isLoginPageOpened();
        signInFlow.authorize(customerDto);
    }
}
