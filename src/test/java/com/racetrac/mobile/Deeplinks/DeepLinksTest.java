package com.racetrac.mobile.Deeplinks;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.DeepLinks;
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

public class DeepLinksTest extends BaseTest {
    private static final int COUPONS_AMOUNT = 2;
    CustomerDto customerDto;
    @Autowired
    SignInFlow signInFlow;
    @Autowired
    LocationRequestFlow locationRequestFlow;
    @Autowired
    NavigationFlow navigationFlow;
    @Autowired
    PriceDisclaimerFlow priceDisclaimerFlow;
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
    GiftcardFlow giftcardFlow;
    @Autowired
    RewardsCheckoutBarcodeFlow rewardsCheckoutBarcodeFlow;
    @Autowired
    UnclaimedRewardsCheckoutFlow unclaimedRewardsCheckoutFlow;
    @Autowired
    InboxFlow inboxFlow;
    @Autowired
    RewardCardFlow rewardCardFlow;
    @Autowired
    EditEmailFlow editEmailFlow;
    @Autowired
    FuelVipFlow fuelVipFlow;
    @Autowired
    DeppLinksProvider deppLinksProvider;


    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
        getDriver().closeApp();
    }

    @Test
    public void storeFinderTest() {
        deppLinksProvider.openDeepLink(DeepLinks.STORE_FINDER);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(priceDisclaimerFlow.isPriceDisclaimerOpened(), "Price disclaimer page is not opened");
        priceDisclaimerFlow.clickOkBtn();
        assertTrue(navigationFlow.isStoresTabOpened());
    }

    @Test  // need to fix the link
    public void nearestStoreTest() {
        deppLinksProvider.openDeepLink(DeepLinks.NEAREST_STORE);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickOnlyThisTime();
        assertTrue(navigationFlow.isNearestStorePageOpened(), "NearestStorePage is not opened");
    }

    @Test
    public void ageRestrictedOffersTest() {
        deppLinksProvider.openDeepLink(DeepLinks.AGE_RESTRICTED_OFFERS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotional screen is not opened");
    }

    @Test
    public void rewardsCatalogTest() {
        deppLinksProvider.openDeepLink(DeepLinks.REWARDS_CATALOG);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardsPopupFlow.isRewardPopupPageOpened(), "Reward popup catalog page is not opened");
        rewardsPopupFlow.clickGotItBtn();
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Reward catalog is not opened");
    }

    @Test
    public void editProfileTest() {
        deppLinksProvider.openDeepLink(DeepLinks.EDIT_PROFILE);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(profileFlow.isProfilePageOpened(), "Profile page is not opened");
    }

    @Test
    public void couponsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, COUPONS_AMOUNT);
        deppLinksProvider.openDeepLink(DeepLinks.COUPONS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(couponsPopUpFlow.isCouponsPopUpDisplayed(), "Coupons popUp is not displayed");
        couponsPopUpFlow.clickOnCouponsPopUpGotItBtn();
        assertTrue(androidCouponsAuthorizedUserFlowImp.isCouponsPageAuthorizedUserOpen(), "Coupons is not opened");
    }

    @Test
    public void giftCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.GIFT_CARD);
        ;
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(giftcardFlow.isGiftCardPageDisplayed(), "GiftCardPage is not displayed");
    }

    @Test
    public void checkoutTest() {
        deppLinksProvider.openDeepLink(DeepLinks.CHECKOUT);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardsCheckoutBarcodeFlow.isRewardsCheckoutBarcodePageOpen(), "RewardsCheckoutBarcodeFlow is not displayed");
    }

    @Test
    public void unclaimedRewardsTest() {
        deppLinksProvider.openDeepLink(DeepLinks.UNCLAIMED_REWARDS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(unclaimedRewardsCheckoutFlow.isUnclaimedRewardsCheckoutPageOpen(), "UnclaimedCheckoutPage is not displayed");
    }

    @Test
    public void inboxTest() {
        deppLinksProvider.openDeepLink(DeepLinks.INBOX);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(inboxFlow.isAuthorisedUserInboxPageDisplayed(), "InboxPage is not displayed");
    }

    @Test
    public void fuelVipTabTest() {
        deppLinksProvider.openDeepLink(DeepLinks.FUEL_VIP_TAB);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(fuelVipFlow.isFuelVipPageDisplayed(), "Fuel VIP page is not displayed");
    }

    @Test
    public void emailUpdatedTest() {
        deppLinksProvider.openDeepLink(DeepLinks.EMAIL_UPDATED);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(editEmailFlow.IsUpdatedEmailPageDisplayed(), "UpdateEmailPage is not displayed");
    }

    @Test
    public void rewardsDebitCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.REWARDS_DEBIT_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardCardFlow.isRewardsDebitCardPageDisplayed(), "Reward + Debit card page is not displayed");
    }

    @Test
    public void upgradeRewardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.UPGRADE_REWARDS_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardCardFlow.isUpgradeRewardCardPageDisplayed(), "UpgradeRewardCardPage is not displayed");
    }

    @Test
    public void orderRewardCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.ORDER_REWARD_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        locationRequestFlow.clickContinue();
        assertTrue(rewardCardFlow.isOrderRewardCardPageDisplayed(), "OrderRewardCardPage is not displayed");
    }
}
