package com.racetrac.mobile.signUp;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.FacebookRestClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.FacebookAuthFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import com.racetrac.mobile.multisite.racetrac.util.BrowserHandler;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class FacebookSignUpTest extends BaseTest {
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignUpFlow signUpFlow;
    @Autowired
    PopupCloserFlow popupCloserFlow;
    @Autowired
    BrowserHandler chromeBrowserHandler;
    @Autowired
    FacebookAuthFlow facebookAuthFlow;
    @Autowired
    FacebookRestClient facebookRestClient;
    CustomerDto customerDto;

    @BeforeMethod(alwaysRun = true)
    public void preconditions() throws IOException {
        chromeBrowserHandler.prepareBrowser();
        customerDto = facebookRestClient.generateCustomer();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signUpFlow.openSignUpSelectorPage();
        assertTrue(signUpFlow.isSignUpSelectorPageOpened(), "SignUpSelector page is not opened");
    }

    @Test
    @TmsLink("2858")
    @Description("Sign Up - Facebook - Using Guest Facebook account and unique phone number ")
    public void isUserAbleToSignUpWithFacebook() {
        signUpFlow.selectSignUpWithFacebook();
        chromeBrowserHandler.handleBrowserOpening();
        chromeBrowserHandler.switchContext();
        facebookAuthFlow.authorise(customerDto);
        chromeBrowserHandler.switchContext();
        assertTrue(signUpFlow.isJoinRacetracRewardScreenOpened(), "JoinRacetracReward screen is not opened");
        signUpFlow.fillJoinRacetracRewardsScreen(customerDto);
        assertTrue(signUpFlow.isFistBumpPageOpened(), "FistBump screen is not opened");
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
        assertTrue(welcomeFlow.isHomePageOpened(), "Home page is not opened");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        facebookRestClient.deleteUser(customerDto);
    }
}