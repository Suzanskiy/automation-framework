package com.racetrac.mobile.emailScore;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EmailScoreTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    CustomerDto customerDto;

    @DataProvider()
    public Object[] emailFraudProvider() {
        return new String[]{
                "fraud@fraud.com",
                "testAutomation@AppMailer.org",
                "testAutomation@BasicMail.host",
                "testAutomation@EasyOnlineMail.net",
                "testAutomation@IncorporatedMail.com",
                "ta@IncorporatedMail.com",
                "admin@IncorporatedMail.com",
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        customerDto = testData.generateDefaultCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
        signUpFlow.selectSignUpWithEmail();
        assertTrue(signUpFlow.isSignUpPageOpened(), "SignUp page is not opened");
    }

    @TmsLink("2943")
    @Description("Check email service by anti-fraud system")
    @Test(dataProvider = "emailFraudProvider")
    public void emailScoringTest(String fraudMail) {
        signUpFlow.enterSpecificCredentials(fraudMail, customerDto);
        signUpFlow.waitUntilFraudErrorMessageShown();
        assertTrue(signUpFlow.isFraudErrorMessageShown());
    }
}
