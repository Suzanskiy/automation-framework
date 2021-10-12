package com.racetrac.mobile.coupons;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CouponsGiftTest extends BaseTest {

    private static final int COUPONS_AMOUNT = 2; //Important to made more than one coupons to prevent falling
    // @PageLoading in isCouponsPageAuthorizedUserOpen()
    // when user can make a gift and we back to CouponsPageAuthorizedUserPage

    private static final String TEST_EMAIL = "nonmember@test.com";

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignOutFlow signOutFlow;
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
    NavigationFlow navigationFlow;
    @Autowired
    CouponsPopUpFlow couponsPopUpFlow;
    @Autowired
    CouponsAuthorizedUserFlow couponsAuthorizedUserFlow;
    @Autowired
    InputEmailForGiftCouponFlow inputEmailForGiftCouponFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    @Autowired
    SuccessfulSentGiftPopUpFlow successfulSentGiftPopUpFlow;
    @Autowired
    UserNotFoundForGiftPopUpFlow userNotFoundForGiftPopUpFlow;
    CustomerDto customerDto;
    CustomerDto secondCustomerDto;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, COUPONS_AMOUNT);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        locationRequestFlow.clickContinue();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");
        navigationFlow.navigateToCoupons();

        assertTrue(couponsPopUpFlow.isCouponsPopUpDisplayed(), "Coupons pop-up is not displayed");
        couponsPopUpFlow.clickOnCouponsPopUpGotItBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
        couponsAuthorizedUserFlow.clickOnGiftItBtn();
        couponsAuthorizedUserFlow.selectAvailableCoupon();
        assertTrue(inputEmailForGiftCouponFlow.isInputEmailPopUpOpened(), "Input email pop-up is not opened");
    }

    @TmsLink("9501")
    @Description("The user cannot make a gift to himself")
    @Test
    public void couponsGiftToYourselfTest() {
        inputEmailForGiftCouponFlow.enterEmail(customerDto);
        assertTrue(userNotFoundForGiftPopUpFlow.isUserNotFoundForGiftPopUpPageOpened(), "\"User not found\" pop-up is not opened");
        userNotFoundForGiftPopUpFlow.clickOnUserNotFoundPopUpOkBtn();
        couponsAuthorizedUserFlow.pressBackBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
    }

    @TmsLink("9498")
    @Description("The user cannot make a gift to Non-member")
    @Test
    public void couponsGiftToNonMemberUserTest() {
        inputEmailForGiftCouponFlow.enterAnotherEmail(TEST_EMAIL);
        assertTrue(userNotFoundForGiftPopUpFlow.isUserNotFoundForGiftPopUpPageOpened(), "\"User not found\" pop-up is not opened");
        userNotFoundForGiftPopUpFlow.clickOnUserNotFoundPopUpOkBtn();
        couponsAuthorizedUserFlow.pressBackBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
    }

    @TmsLink("9498")
    @Description("The user can make a gift to another RT Reward member")
    @Test
    public void couponsGiftToAnotherMemberTest() {
        secondCustomerDto = testData.registerNewCustomer();
        inputEmailForGiftCouponFlow.enterEmail(secondCustomerDto);
        assertTrue(successfulSentGiftPopUpFlow.isSuccessfulSentGiftPopUpOpened(), "\"Gift has been sent\" pop-up is not opened");
        successfulSentGiftPopUpFlow.clickOnSuccessfulSentGiftPopUpOkBtn();
        couponsAuthorizedUserFlow.pressBackBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
        navigationFlow.navigateToHomeFromCouponsPage();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(secondCustomerDto);
        locationRequestFlow.clickContinue();
        notificationRequestFlow.clickNotNow();
        rewardsPopupFlow.clickGotItBtn();
        pointsAndLevelsFlow.clickGotItBtn();
        assertTrue(welcomeFlow.isHomePageOpenedAfterSignIn(), "Welcome page is not opened after sign in");

        navigationFlow.navigateToCoupons();
        assertTrue(couponsPopUpFlow.isCouponsPopUpDisplayed(), "Coupons pop-up is not displayed");
        couponsPopUpFlow.clickOnCouponsPopUpGotItBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
    }

}
