package com.racetrac.mobile.helpInformation;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ContactUsNotAuthorizedTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    AccountSettingsFlow accountSettingsFlow;
    @Autowired
    HelpInformationFlow helpInformationFlow;

    @TmsLink("8825")
    @Description("\"Contact Us\" link is not available for non-logged user")
    @Test
    public void contactUsLinkNotAuthorizedUserTest() {
        welcomeFlow.isHomePageOpened();
        accountSettingsFlow.navigateToAccountSettings();
        assertTrue(accountSettingsFlow.isAccountSettingsScreenOpened(), " Account screen is not opened");
        accountSettingsFlow.navigateToHelpSection();
        assertTrue(helpInformationFlow.isHelpInformationPageOpened(),"Help information page is not opened");
        assertFalse(helpInformationFlow.isContactUsDisplayed(),"Contact us is displayed");
    }
}
