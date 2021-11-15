package com.racetrac.mobile.coupons;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CouponsScreenMainPageTest extends BaseTest {

    private static final int COUPONS_AMOUNT = 10;
    private static final int COUPONS_AMOUNT_AFTER_SENT = 9; //The number of coupons should be one less
    // from the starting one if only one coupon was sent

    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    InputEmailForGiftCouponFlow inputEmailForGiftCouponFlow;
    @Autowired
    CouponsPopUpFlow couponsPopUpFlow;
    @Autowired
    CouponsAuthorizedUserFlow couponsAuthorizedUserFlow;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    @Autowired
    SuccessfulSentGiftPopUpFlow successfulSentGiftPopUpFlow;

    CustomerDto customerDto;
    CustomerDto secondCustomerDto;

    @DataProvider()
    public Object[] CouponsLessThanTenDataProvider() {
        return new Integer[]{
                1,
                9
        };
    }
    @DataProvider()
    public Object[] CouponsMoreThanTenDataProvider() {
        return new Integer[]{
                10,
                11
        };
    }

    @TmsLink("9496")
    @Description("Coupons menu is Available for non-logged user")
    @Test
    public void CouponsMenuAvailableForNotAuthorizedUserTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        navigationFlow.navigateToCoupons();
        assertTrue(navigationFlow.isCouponsTabOpened(), "Coupons tab is not opened");
    }

    @TmsLink("9500 & 9502")
    @Description("\"Sorry!\" message is displayed and \"GIFT TO A FRIEND\" button is not clickable" +
            " in \"Coupons\" section on \"Home\" screen if no coupons for logged user")
    @Test
    public void noCouponsDisplayTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.swipeToCouponsSection();
        assertTrue(welcomeFlow.isNoCouponsSectionDisplayed(), "No coupons section is not displayed");
        assertFalse(welcomeFlow.isGiftToAFriendBtnClickable(), "\"Gift to a friend button\" is clickable");
        assertFalse(welcomeFlow.isViewAllCouponsBtnDisplayed(), "View all is displayed");
    }

    @TmsLink("9503")
    @Description("The \"View all\" button is not displayed if there are less than ten coupons")
    @Test(dataProvider = "CouponsLessThanTenDataProvider")
    public void viewAllCouponsIsNotDisplayedTest(Integer couponsAmount) {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, couponsAmount);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.swipeToCouponsSection();

        assertFalse(welcomeFlow.isViewAllCouponsBtnDisplayed(), "View all is displayed");
    }
    @TmsLink("9503")
    @Description("\"View all\" button is displayed if there are at least ten coupons")
    @Test(dataProvider = "CouponsMoreThanTenDataProvider")
    public void viewAllCouponsIsDisplayedTest(Integer couponsAmount) {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, couponsAmount);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.swipeToCouponsSection();

        assertTrue(welcomeFlow.isViewAllCouponsBtnDisplayed(), "View all is not displayed");
    }

    @TmsLink("9504")
    @Description("The carousel has maximum ten dots and \"View all\" button is displayed if there are at least ten coupons")
    @Test
    public void viewAllCouponsBtnAndCarouselTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, COUPONS_AMOUNT);
        signInFlow.openLoginInPage();
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);

        welcomeFlow.swipeToCouponsSection();
        assertTrue(welcomeFlow.isGiftToAFriendBtnClickable(), "\"Gift to a friend button\" is not clickable");
        assertTrue(welcomeFlow.isViewAllCouponsBtnDisplayed(), "\"View\" all is  not displayed");
        assertEquals(welcomeFlow.couponsCarouselQuantity(), COUPONS_AMOUNT, "The number of available coupons and coupons in the carousel is not equal");
        navigationFlow.navigateToCoupons();

        assertTrue(couponsPopUpFlow.isCouponsPopUpDisplayed(), "Coupons pop-up is not displayed");
        couponsPopUpFlow.clickOnCouponsPopUpGotItBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
        couponsAuthorizedUserFlow.clickOnGiftItBtn();
        couponsAuthorizedUserFlow.selectAvailableCoupon();
        assertTrue(inputEmailForGiftCouponFlow.isInputEmailPopUpOpened(), "Input email pop-up is not opened");

        secondCustomerDto = testData.registerNewCustomer();
        inputEmailForGiftCouponFlow.enterEmail(secondCustomerDto);
        assertTrue(successfulSentGiftPopUpFlow.isSuccessfulSentGiftPopUpOpened(), "\"Gift has been sent\" pop-up is not opened");
        successfulSentGiftPopUpFlow.clickOnSuccessfulSentGiftPopUpOkBtn();
        couponsAuthorizedUserFlow.pressBackBtn();
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons page is not opened");
        navigationFlow.navigateToHomeFromCouponsPage();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");

        assertFalse(welcomeFlow.isViewAllCouponsBtnDisplayed(), "View all is displayed");
        assertEquals(welcomeFlow.couponsCarouselQuantity(), COUPONS_AMOUNT_AFTER_SENT, "The number of available coupons and coupons in the carousel is not equal");

        signOutFlow.doSignOut();
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        signInFlow.openLoginInPage();
        punchhPointsClient.generateCouponsAmount(customerDto, 2);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        welcomeFlow.swipeToCouponsSection();

        assertEquals(welcomeFlow.couponsCarouselQuantity(), COUPONS_AMOUNT, "The number of available coupons and coupons in the carousel is not equal");
        assertTrue(welcomeFlow.isViewAllCouponsBtnDisplayed(), "\"View\" all is  not displayed");
    }
}

