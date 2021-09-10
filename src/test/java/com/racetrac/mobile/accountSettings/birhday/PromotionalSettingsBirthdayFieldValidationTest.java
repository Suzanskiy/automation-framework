package com.racetrac.mobile.accountSettings.birhday;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
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
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    CustomerDto customerDto;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    NotAdultNoticeFlow notAdultNoticeFlow;
    @Autowired
    ProfileFlow profileFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;

    @DataProvider()
    public Object[] invalidBirthdayDataProvider() {
        return new String[]{
                testData.generateDateBirthPlus(0, ChronoUnit.DAYS),
                testData.generateDateBirthPlus(1, ChronoUnit.DAYS),
                testData.generateDateBirthPlus(1, ChronoUnit.MONTHS),
                testData.generateDateBirthPlus(1, ChronoUnit.YEARS),
                "00/11/1993",
                "15/00/1998",
                "09/01/00000",
                "13/11/2001",
                "07/32/2002",
        };
    }

    @BeforeClass
    public void beforeClass() {
        customerDto = testData.registerNewCustomer(NOT_SPECIFIED_BIRTHDATE);
    }

    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickNotNow();
        notificationRequestFlow.clickNotNow();
        pointsAndLevelsFlow.clickGotItBtn();
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), " Account screen for Logged in User is not opened");
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
