package com.racetrac.mobile.signIn;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.FacebookRestClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import com.racetrac.mobile.multisite.racetrac.util.BrowserHandler;
import com.racetrac.mobile.signUp.FacebookSignUpTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class FacebookSingInWithSingUpTest extends BaseTest {

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
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
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
    @TmsLink("00001")
    @Description("Sign Up - Facebook - Using Guest Facebook account and unique phone number "+'\n'+
    "Sing In - Facebook - Using data from Sing Up")
    public void isUserAbleToFacebookSingUpAndSingIn(){
        signUpFlow.selectSignUpWithFacebook();
        chromeBrowserHandler.handleBrowserOpening();
        facebookAuthFlow.authorise(customerDto);
        assertTrue(signUpFlow.isJoinRacetracRewardScreenOpened(), "JoinRacetracReward screen is not opened");
        signUpFlow.fillJoinRacetracRewardsScreen(customerDto);
        assertTrue(signUpFlow.isFistBumpPageOpened(), "FistBump screen is not opened");
        signUpFlow.clickGetStartedBtn();
        popupCloserFlow.closePopups();
        assertTrue(welcomeFlow.isHomePageOpened(), "Home page is not opened");
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.clickOnFacebookIcon();
        facebookAuthFlow.singInToFacebook();
        popupCloserFlow.closePopups();
        assertTrue(welcomeFlow.isHomePageOpened(), "Home page is not opened");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        facebookRestClient.deleteUser(customerDto);
    }
    }
