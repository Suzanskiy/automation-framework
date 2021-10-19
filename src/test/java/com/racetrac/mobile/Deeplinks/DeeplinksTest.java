package com.racetrac.mobile.Deeplinks;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.*;
import com.racetrac.mobile.multisite.racetrac.flow.impl.InboxFlow;
import com.racetrac.mobile.multisite.racetrac.flow.impl.android.AndroidCouponsAuthorizedUserFlowImp;
import com.racetrac.mobile.multisite.racetrac.page.NearestStorePage;
import com.racetrac.mobile.multisite.racetrac.page.OrderRewardCardPage;
import com.racetrac.mobile.multisite.racetrac.page.PriceDisclaimerPage;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static org.testng.Assert.assertTrue;

public class DeeplinksTest extends BaseTest {
    private static final int COUPONS_AMOUNT = 2;
    CustomerDto customerDto;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    PriceDisclaimerPage priceDisclaimerPage;
    @Autowired
    PromotionalOffersFlow promotionalOffersFlow;
    @Autowired
    RewardsCatalogFlow rewardsCatalogFlow;
    @Autowired
    RewardsPopupFlow rewardsPopupFlow;
    @Autowired
    ProfileFlow profileFlow;
    @Autowired
    CouponsPopUpFlow couponsPopUpFlow;
    @Autowired
    AndroidCouponsAuthorizedUserFlowImp androidCouponsAuthorizedUserFlowImp;
    @Autowired
    PunchhPointsClient punchhPointsClient;
    @Autowired
    WelcomeFlow welcomeFlow;
    @Autowired
    GiftcardFlow giftcardFlow;
    @Autowired
    RewardsCheckoutBarcodeFlow rewardsCheckoutBarcodeFlow;
    @Autowired
    UnclaimedRewardsCheckoutFlow unclaimedRewardsCheckoutFlow;
    @Autowired
    InboxFlow inboxFlow;
    @Autowired
    OrderRewardCardPage orderRewardCardPage;
    @Autowired
    NearestStorePage nearestStorePage;
    @Autowired
    RewardCardFlow rewardCardFlow;
    @Autowired
    EditEmailFlow editEmailFlow;
    @Autowired
    FuelVipFlow fuelVipFlow;


    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
    }

    @Test
    public void storeFinderTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=storefinder");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(priceDisclaimerPage.waitUntilIsOpened(), "Price disclaimer page is not opened");
        priceDisclaimerPage.getOkButton().click();
        assertTrue(navigationFlow.isStoresTabOpened());
    }

    @Test
    public void nearestStoreTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=neareststore");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickOnlyThisTime();
        AppiumWaitingUtils.waitUntilElementClickable(nearestStorePage.getStoreName());
        assertTrue(navigationFlow.isNearestStorePageOpened(), "NearestStorePage  is not opened");

    }

    @Test
    public void ageRestrictedOffersTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=agerestrictedoffers");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotional screen is not opened");
    }

    @Test
    public void rewardsCatalogTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=rewardscatalog");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward popup catalog page is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Reward catalog is not opened");
    }

    @Test
    public void editProfileTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=editprofile");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(profileFlow.isProfilePageOpened(), "Profilepage is not opened");

    }

    @Test
    public void couponsTest() {
        assertTrue(welcomeFlow.isHomePageOpened(), "Welcome page is not opened");
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, COUPONS_AMOUNT);
        getDriver().get("racetrac://open?featuretype=coupons");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(couponsPopUpFlow.isCouponsPopUpDisplayed(), "Coupons popUp is not displayed");
        couponsPopUpFlow.clickOnCouponsPopUpGotItBtn();
        assertTrue(androidCouponsAuthorizedUserFlowImp.isCouponsPageAuthorizedUserOpen(), "Coupons is not opened");

    }

    @Test
    public void giftcardTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=giftcard");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(giftcardFlow.isGiftCardPageDisplayed(), "GiftcardPage   is not displayed");

    }

    @Test
    public void checkoutTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=checkout");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardsCheckoutBarcodeFlow.isRewardsCheckoutBarcodePageOpen(), "RewardsCheckoutBarcodeFlow   is not displayed");

    }

    @Test
    public void unclaimedRewardsTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=unclaimedrewards");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(unclaimedRewardsCheckoutFlow.isUnclaimedRewardsCheckoutPageOpen(), "UnclaimedchekoutPage   is not displayed");

    }

    @Test
    public void inboxTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=inbox");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(inboxFlow.isAuthorisedUserInboxPageDisplayed(), "InboxPage is not displayed");

    }

    @Test
    public void fuelVipTabTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=fuelviptab");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(fuelVipFlow.isFuelVipPageDisplayed(), "Fuel VIPpage  is not displayed");

    }

    @Test
    public void emailUpdatedTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=emailupdated");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(editEmailFlow.IsUpdatedEmailPageDisplayed(), "UpdateEmailPage  is not displayed");

    }

    @Test
    public void rewardsDebitCardTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=rewardsdebitcard");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardCardFlow.isRewardsDebitCardPageDisplayed(), "Reward + Debit card page is not displayed");

    }

    @Test
    public void upgradeRewardTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=upgraderewardcard");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardCardFlow.isUpgradeRewardCardPageDisplayed(), "UpgradeRewardCardPage is not displayed");

    }

    @Test
    public void orderrewardcardTest() {
        getDriver().closeApp();
        getDriver().get("racetrac://open?featuretype=orderrewardcard");
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        AppiumWaitingUtils.waitUntilElementClickable(orderRewardCardPage.getContinueButton());
        assertTrue(rewardCardFlow.isOrderRewardCardPageDisplayed(), "OrderrewardCardPage is not displayed");

    }
}
