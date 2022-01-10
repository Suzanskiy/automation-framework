package com.racetrac.mobile.accountSettings.birhday;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.*;

import java.time.temporal.ChronoUnit;

import static com.racetrac.mobile.framework.enums.CustomerAge.NOT_SPECIFIED_BIRTHDATE;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PromotionalSettingsBirthdayFieldValidationTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    CustomerDto customerDto;

    @DataProvider()
    public Object[] invalidBirthdayDataProvider() {
        return new String[]{
                testData.generateDateBirthPlus(1, ChronoUnit.DAYS),
                testData.generateDateBirthPlus(1, ChronoUnit.MONTHS),
                testData.generateDateBirthPlus(1, ChronoUnit.YEARS),
                "00/11/1993",
                "15/00/1998",
                "09/01/00000",
                "13/11/2001",
                "07/32/2002",
                "077/13/2002",
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        customerDto = testData.registerNewCustomer(NOT_SPECIFIED_BIRTHDATE);
    }

    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.waitUntilAccountSettingsAuthorizedOpen();
        accountSettingsFlow.navigateToPromotionalSettings();
    }
    @TmsLink("6247")
    @Description("Validation of \"Birthday\" field in promotional settings section with invalid data")
    @Test(dataProvider = "invalidBirthdayDataProvider")
    public void birthdayFieldInPromotionalInvalidDataTest(String customerBirth) {
        assertFalse(promotionalOffersFlow.isOkPopUpBtnEditable(), "Ok field is editable");
        assertTrue(promotionalOffersFlow.isPopUpDescriptionDisplayed(),"Pop-Up description is not displayed");
        promotionalOffersFlow.enterBirthDate(customerBirth);
        assertFalse(promotionalOffersFlow.isOkPopUpBtnEditable(), "Ok field is editable");
        assertTrue(promotionalOffersFlow.isPopUpDescriptionDisplayed(),"Pop-Up description is not displayed");
    }

}
