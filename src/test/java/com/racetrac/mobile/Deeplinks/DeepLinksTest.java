package com.racetrac.mobile.Deeplinks;

import com.racetrac.mobile.BaseTest;
import com.racetrac.mobile.multisite.racetrac.api.PunchhPointsClient;
import com.racetrac.mobile.multisite.racetrac.data.DeepLinks;
import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.CouponsAuthorizedUserFlow;
import com.racetrac.mobile.multisite.racetrac.flow.CouponsPopUpFlow;
import com.racetrac.mobile.multisite.racetrac.flow.DeppLinksProvider;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelVipFlow;
import com.racetrac.mobile.multisite.racetrac.flow.GiftcardFlow;
import com.racetrac.mobile.multisite.racetrac.flow.InboxFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NotificationRequestFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PriceDisclaimerFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardCardFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCheckoutBarcodeFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.UnclaimedRewardsCheckoutFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    CouponsAuthorizedUserFlow couponsAuthorizedUserFlow;
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
    @Autowired
    NotificationRequestFlow notificationRequestFlow;
    @Autowired
    PointsAndLevelsFlow pointsAndLevelsFlow;


    @BeforeMethod
    public void setUp() {
        customerDto = testData.registerNewCustomer();
    }

    @Test
    public void storeFinderTest() {
        deppLinksProvider.openDeepLink(DeepLinks.STORE_FINDER);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(priceDisclaimerFlow.isPriceDisclaimerOpened(), "Price disclaimer page is not opened");
        priceDisclaimerFlow.clickOkBtn();
        assertTrue(navigationFlow.isStoresTabOpened());
    }

    @Test
    public void nearestStoreTest() {
        deppLinksProvider.openDeepLink(DeepLinks.NEAREST_STORE);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(navigationFlow.isNearestStorePageOpened(), "NearestStorePage is not opened");
    }

    @Test
    public void ageRestrictedOffersTest() {
        deppLinksProvider.openDeepLink(DeepLinks.AGE_RESTRICTED_OFFERS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(promotionalOffersFlow.isPromotionalOffersScreenOpened(), "Promotional screen is not opened");
    }


    @Test
    public void rewardsCatalogTest() {
        deppLinksProvider.openDeepLink(DeepLinks.REWARDS_CATALOG);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(rewardsCatalogFlow.isRewardsCatalogPageOpened(), "Reward catalog is not opened");
    }

    @Test
    public void editProfileTest() {
        deppLinksProvider.openDeepLink(DeepLinks.EDIT_PROFILE);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(profileFlow.isProfilePageOpened(), "Profile page is not opened");
    }

    @Test
    public void couponsTest() {
        customerDto = testData.registerNewCustomer();
        punchhPointsClient.generateCouponsAmount(customerDto, COUPONS_AMOUNT);
        deppLinksProvider.openDeepLink(DeepLinks.COUPONS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened"); // ON IOS NO NEED TO OPEN LOGIN PAGE
        signInFlow.authorize(customerDto);
        assertTrue(couponsAuthorizedUserFlow.isCouponsPageAuthorizedUserOpen(), "Coupons is not opened");
    }

    @Test
    public void giftCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.GIFT_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");// ON IOS NO NEED TO OPEN LOGIN PAGE
        signInFlow.authorize(customerDto);
        assertTrue(giftcardFlow.isGiftCardPageDisplayed(), "GiftCardPage is not displayed");
    }

    @Test
    public void checkoutTest() {
        deppLinksProvider.openDeepLink(DeepLinks.CHECKOUT);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(rewardsCheckoutBarcodeFlow.isRewardsCheckoutBarcodePageOpen(), "RewardsCheckoutBarcodeFlow is not displayed");
    }

    @Test
    public void unclaimedRewardsTest() {
        deppLinksProvider.openDeepLink(DeepLinks.UNCLAIMED_REWARDS);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(unclaimedRewardsCheckoutFlow.isUnclaimedRewardsCheckoutPageOpen(), "UnclaimedCheckoutPage is not displayed");
    }

    @Test
    public void inboxTest() {
        deppLinksProvider.openDeepLink(DeepLinks.INBOX);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(inboxFlow.isAuthorisedUserInboxPageDisplayed(), "InboxPage is not displayed");
    }

    @Test
    public void fuelVipTabTest() {
        deppLinksProvider.openDeepLink(DeepLinks.FUEL_VIP_TAB);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened"); // ON IOS NO NEED TO OPEN LOGIN PAGE
        signInFlow.authorize(customerDto);
        assertTrue(fuelVipFlow.isFuelVipPageDisplayed(), "Fuel VIP page is not displayed");
    }

    @Test
    public void emailUpdatedTest() {
        deppLinksProvider.openDeepLink(DeepLinks.EMAIL_UPDATED);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(editEmailFlow.IsUpdatedEmailPageDisplayed(), "UpdateEmailPage is not displayed");
    }

    @Test
    public void rewardsDebitCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.REWARDS_DEBIT_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(rewardCardFlow.isRewardsDebitCardPageDisplayed(), "Reward + Debit card page is not displayed");
    }

    @Test
    public void upgradeRewardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.UPGRADE_REWARDS_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(rewardCardFlow.isUpgradeRewardCardPageDisplayed(), "UpgradeRewardCardPage is not displayed");
    }

    @Test
    public void orderRewardCardTest() {
        deppLinksProvider.openDeepLink(DeepLinks.ORDER_REWARD_CARD);
        assertTrue(signInFlow.isLoginPageOpened(), "Login page is not opened");
        signInFlow.authorize(customerDto);
        assertTrue(rewardCardFlow.isOrderRewardCardPageDisplayed(), "OrderRewardCardPage is not displayed");
    }
}
