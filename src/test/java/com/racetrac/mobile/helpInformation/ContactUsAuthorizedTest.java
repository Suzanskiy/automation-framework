package com.racetrac.mobile.helpInformation;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.util.constants.TestData;
import com.racetrac.mobile.util.device.ConnectionUtils;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.util.device.ConnectionUtils.*;
import static org.testng.Assert.assertTrue;

public class ContactUsAuthorizedTest extends BaseTest {

    private static final String TEST_MESSAGE = "This is test message from QA team";

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    HelpInformationFlow helpInformationFlow;
    @Autowired
    ContactUsFlow contactUsFlow;
    @Autowired
    SuccessfulSentContactUsMessageFlow successfulSentContactUsMessageFlow;
    @Autowired
    NoInternetConnectionFlow noInternetConnectionFlow;

    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);
        notificationRequestFlow.iosClickNotNow();
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        accountSettingsFlow.navigateToAccountSettings();
        accountSettingsFlow.waitUntilAccountSettingsAuthorizedOpen();
        assertTrue(accountSettingsFlow.isAccountSettingsAuthorisedUserScreenOpened(), "Account screen for Logged in User is not opened");
        accountSettingsFlow.navigateToHelpSection();
        assertTrue(helpInformationFlow.isHelpInformationPageOpened(), "Help information page is not opened");
        helpInformationFlow.navigateToContactUs();
    }

    @TmsLink("8826")
    @Description("\"Contact Us\" functions are available for logged user ")
    @Test
    public void contactUsAuthorizedUserTest() {
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        assertTrue(contactUsFlow.isTollFreeCallAvailable(), "Free toll call is not clickable");
        contactUsFlow.sendMessageToGeneralSubject(TEST_MESSAGE);
        assertTrue(successfulSentContactUsMessageFlow.isSuccessfulSentContactUsMessageOpened(), "The page after the sent message is not opened");
        successfulSentContactUsMessageFlow.closeSuccessfulSentContactUsMessagePage();
        assertTrue(helpInformationFlow.isHelpInformationPageOpened(), "Help information page is not opened");
    }

    @TmsLink("8826")
    @Description("Information about a successfully sent message in \"Contact Us\" is displayed when the Internet is disconnected")
    @Test
    public void contactUsAuthorizedUserWithoutInternetTest() {
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        assertTrue(contactUsFlow.isTollFreeCallAvailable(), "Free toll call is not clickable");
        disableConnection();
        assertTrue(noInternetConnectionFlow.isNoInternetConnectionPageOpened(),"No Internet connection page is not opened");
        noInternetConnectionFlow.tapOkBtn();
        contactUsFlow.sendMessageToGeneralSubject(TEST_MESSAGE);
        assertTrue(successfulSentContactUsMessageFlow.isSuccessfulSentContactUsMessageOpened(), "The page after the sent message is not opened");
    }

    @TmsLink("8826")
    @Description("")
    @Test
    public void sentMessageWithMoreCharactersThanAllowedTest() {
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        assertTrue(contactUsFlow.isTollFreeCallAvailable(), "Free toll call is not clickable");
        contactUsFlow.sendMessageToGeneralSubject(TestData.readFromFile("testData/text5000symbols.txt"));
        assertTrue(successfulSentContactUsMessageFlow.isSuccessfulSentContactUsMessageOpened(), "The page after the sent message is not opened");
        successfulSentContactUsMessageFlow.closeSuccessfulSentContactUsMessagePage();
        assertTrue(helpInformationFlow.isHelpInformationPageOpened(), "Help information page is not opened");
    }

    @AfterMethod(alwaysRun = true)
    public void reconnection() {
        ConnectionUtils.reconnection();
    }
}
