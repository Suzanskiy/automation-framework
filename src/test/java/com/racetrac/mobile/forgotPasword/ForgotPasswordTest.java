package com.racetrac.mobile.forgotPasword;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.ForgotPassFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.racetrac.mobile.multisite.racetrac.data.ComparableStrings.FORGOT_PASS_COMPLETE_TEXT;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTest extends BaseTest {

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    ForgotPassFlow forgotPassFlow;
    CustomerDto customerDto;

    @DataProvider()
    public Object[] wrongEmailProvider() {
        return new String[]{
                "aaa",
                "aaa.aaa.aaa",
                "aaa@aaa",
                "aaa@aaa.@",
                "https://my@mail.com",
                "http://my@mail.com",
                "http://your@mail.com",
                "https://new-mail@mail.com",
                "https://old-mail@htttps.com",

        };
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        customerDto = testData.generateDefaultCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        forgotPassFlow.clickForgotPassBtn();
        assertTrue(forgotPassFlow.isForgotPassPageOpened(), "ForgotPassword page is not opened");
    }


    @TmsLink("3152")
    @Description("Reset password for Guest account")
    @Test
    public void resetPasswordForGuestTest() {
        forgotPassFlow.enterEmail(customerDto.getPersonalInfo().getEmail());
        forgotPassFlow.clickResetPassBtn();
        // TODO: 14.05.2021 Here should be an error, saying that user is not registered. Must be fixed soon
    }

    @TmsLink("3154")
    @Description("\"Email\" field validation")
    @Test(dataProvider = "wrongEmailProvider")
    public void forgotPasswordEmailValidationTest(String email) {
        assertTrue(forgotPassFlow.isResetPasswordBtnDisabled(), "Reset pass button is not disabled");
        forgotPassFlow.enterEmail(email);
        assertTrue(forgotPassFlow.isResetPasswordBtnDisabled(), "Reset pass button is not disabled");
    }

    @TmsLink("3248")
    @Description("Is user able to request forgotten password email")
    @Test
    public void isUserAbleToRequestForgottenPasswordToEmailTest() {
        forgotPassFlow.enterEmail(customerDto.getPersonalInfo().getEmail());
        forgotPassFlow.clickResetPassBtn();
        assertTrue(forgotPassFlow.isCompleteMessageShown(), "Complete message is not shown");
        assertEquals(forgotPassFlow.getForgotPasswordCompleteTxt(), FORGOT_PASS_COMPLETE_TEXT);
        forgotPassFlow.clickDoneBtn();
    }
}
