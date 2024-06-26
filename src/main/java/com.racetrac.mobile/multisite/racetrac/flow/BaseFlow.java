package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.*;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeAcceptTermsPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeMainPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeMainRaceTrackMoreInfoPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.TurnOnSyncNowPage;
import com.racetrac.mobile.multisite.racetrac.page.diff.AccountSettingsPageAuthorised;
import com.racetrac.mobile.multisite.racetrac.page.safari.SafariBrowserPage;
import com.racetrac.mobile.multisite.racetrac.views.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter(onMethod = @__(@Autowired))
public class BaseFlow {
    public static final Logger LOG = LoggerFactory.getLogger(BaseFlow.class);

    //     PAGES
    HomePage homePage;
    TurnOnLocationPage turnOnLocationPage;
    StoresPage storesPage;
    PriceDisclaimerPage priceDisclaimerPage;
    CouponsPage couponsPage;
    CardsPage cardsPage;
    InboxPage inboxPage;
    SignUpPage signUpPage;
    FistBumpPage fistBumpPage;
    LoginPage loginPage;
    AccountSettingsPage accountSettingsPage;
    AccountSettingsPageAuthorised accountSettingsPageAuthorised;
    ForgotPassPage forgotPassPage;
    SignUpSelectorPage signUpSelectorPage;
    TurnOnNotificationPage turnOnNotificationPage;
    PromotionalOffersPage promotionalOffersPage;
    BecomeFuelVipPage becomeFuelVipPage;
    ProfilePage profilePage;
    EditPasswordPage editPasswordPage;
    EditEmailPage editEmailPage;
    FuelVipPage fuelVipPage;
    ChromeAcceptTermsPage chromeAcceptTermsPage;
    TurnOnSyncNowPage turnOnSyncNowPage;
    ChromeMainPage chromeMainPage;
    ChromeMainRaceTrackMoreInfoPage chromeMainRaceTrackMoreInfoPage;
    SafariBrowserPage safariBrowserPage;
    PointsAndLevelsPage pointsAndLevelsPage;
    PointsAndTiersPage pointsAndTiersPage;
    HowItWorksPage howItWorksPage;
    RewardsCheckoutBarcodePage rewardsCheckoutBarcodePage;
    UnclaimedRewardsCheckoutPage unclaimedRewardsCheckoutPage;
    CouponsAuthorizedUserPage couponsAuthorizedUserPage;
    HelpInformationPage helpInformationPage;
    ContactUsPage contactUsPage;
    OrderRewardCardPage orderRewardCardPage;
    GiftcardPage giftcardPage;
    AuthorisedUserInboxPage authorisedUserInboxPage;
    RewardsDebitCardPage rewardsDebitCardPage;
    UpdatedEmailPage updatedEmailPage;
    UpgradeRewardCardPage upgradeRewardCardPage;
    NearestStorePage nearestStorePage;
    FAQPage faqPage;
    FacebookLoginPage facebookLoginPage;
    FacebookLoginStep2Page facebookLoginStep2Page;
    JoinRacetracRewardsScreen joinRacetracRewardsScreen;
    FuelSavingsPage fuelSavingsPage;
    FuelSavingsDebitCardPage fuelSavingsDebitCardPage;
    FuelSavingsVipPage fuelSavingsVipPage;
    FuelSavingsRewardsPage fuelSavingsRewardsPage;
    BuyNewCardPage buyNewCardPage;
    PayWithAddedGiftCardPage payWithAddedGiftCardPage;

    //    SECTIONS
    NavigationDrawer navigationDrawer;
    AndroidNavBar androidNavBar;
    IosNavBar iosNavBar;
    ErrorMessageVIew errorMessageVIew;
    CouponsView couponsView;
    FraudErrorMessageView fraudErrorMessageView;
    PointsAndLevelsView pointsAndLevelsView;
    NotAdultNotice notAdultNotice;
    NoPointsNotice noPointsNotice;
    RewardsPopupPage rewardsPopupPage;
    RewardsCatalogPage rewardsCatalogPage;
    EnoughRedeemPointsPopUp enoughRedeemPointsPopUp;
    CheckoutBtnView checkoutBtnView;
    SadSmileRewardCatalogView sadSmileRewardCatalogView;
    CouponsPopUpPage couponsPopUpPage;
    InputEmailForGiftCouponPage inputEmailForGiftCouponPage;
    UserNotFoundForGiftPopUpPage userNotFoundForGiftPopUpPage;
    SuccessfulSentGiftPopUpPage successfulSentGiftPopUpPage;
    SuccessfulSentContactUsMessagePage successfulSentContactUsMessagePage;
    NoInternetConnectionPage noInternetConnectionPage;
    AllowLocationPermitView allowLocationPermitView;
    SuccessPaymentProcessedView successPaymentProcessedView;

}