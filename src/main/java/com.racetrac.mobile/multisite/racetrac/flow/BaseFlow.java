package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.*;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeAcceptTermsPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeMainPage;
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
    SafariBrowserPage safariBrowserPage;
    PointsAndLevelsPage pointsAndLevelsPage;
    PointsAndTiersPage pointsAndTiersPage;
    HowItWorksPage howItWorksPage;
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

}