package com.racetrac.mobile.helpInformation;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ContactUsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.HelpInformationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NoInternetConnectionFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SuccessfulSentContactUsMessageFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.util.constants.TestData;
import com.racetrac.mobile.util.device.ConnectionUtils;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.util.device.ConnectionUtils.disableConnection;
import static com.racetrac.mobile.util.device.ConnectionUtils.enableConnection;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ContactUsAuthorizedTest extends BaseTest {

    private static final String TEST_MESSAGE = "This is test message from QA team";
    private static final String PATH = "testData/text5000symbols.txt";
    public static final String FAILED_SUBMISSION_MESSAGE = "Your submission was not successful. Please try again.";

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    HelpInformationFlow helpInformationFlow;
    @Autowired
    ContactUsFlow contactUsFlow;
    @Autowired
    SuccessfulSentContactUsMessageFlow successfulSentContactUsMessageFlow;
    @Autowired
    NoInternetConnectionFlow noInternetConnectionFlow;
    @Autowired
    SignUpFlow signUpFlow;

    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.authorize(customerDto);

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
    @Description("Message in \"Contact Us\" can't be sent when the Internet is disconnected")
    @Test
    public void contactUsAuthorizedUserWithoutInternetTest() {
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        disableConnection();
        assertTrue(noInternetConnectionFlow.isNoInternetConnectionPageOpened(), "No Internet connection page is not opened");
        noInternetConnectionFlow.tapOkBtn();
        contactUsFlow.sendMessageToGeneralSubject(TEST_MESSAGE);
        assertTrue(signUpFlow.isErrorMessageShown());
        assertEquals(signUpFlow.getErrorMessageText(), FAILED_SUBMISSION_MESSAGE);
        enableConnection();
    }

    @TmsLink("8826")
    @Description("Information about a successfully sent message in \"Contact Us\" is displayed when the message has 5000 symbols and more")
    @Test
    public void sentMessageWithMoreCharactersThanAllowedTest() {
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        contactUsFlow.sendMessageToGeneralSubject(TestData.readFromFile(PATH));
        assertTrue(successfulSentContactUsMessageFlow.isSuccessfulSentContactUsMessageOpened(), "The page after the sent message is not opened");
        successfulSentContactUsMessageFlow.closeSuccessfulSentContactUsMessagePage();
        assertTrue(helpInformationFlow.isHelpInformationPageOpened(), "Help information page is not opened");
        helpInformationFlow.navigateToContactUs();
        assertTrue(contactUsFlow.isContactUsPageOpened(), "Contact us Page is not opened");
        contactUsFlow.sendMessageToGeneralSubject(TestData.readFromFile(PATH) + "A");
        assertTrue(successfulSentContactUsMessageFlow.isSuccessfulSentContactUsMessageOpened(), "The page after the sent message is not opened");
    }

    @AfterMethod(alwaysRun = true)
    public void reconnection() {
        ConnectionUtils.reconnection();
    }
}
