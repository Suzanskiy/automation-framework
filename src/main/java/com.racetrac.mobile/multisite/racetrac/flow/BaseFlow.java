package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.AccountSettingsPage;
import com.racetrac.mobile.multisite.racetrac.page.BecomeFuelVipPage;
import com.racetrac.mobile.multisite.racetrac.page.CardsPage;
import com.racetrac.mobile.multisite.racetrac.page.CouponsPage;
import com.racetrac.mobile.multisite.racetrac.page.EditEmailPage;
import com.racetrac.mobile.multisite.racetrac.page.EditPasswordPage;
import com.racetrac.mobile.multisite.racetrac.page.FistBumpPage;
import com.racetrac.mobile.multisite.racetrac.page.ForgotPassPage;
import com.racetrac.mobile.multisite.racetrac.page.FuelVipPage;
import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.InboxPage;
import com.racetrac.mobile.multisite.racetrac.page.LoginPage;
import com.racetrac.mobile.multisite.racetrac.page.PriceDisclaimerPage;
import com.racetrac.mobile.multisite.racetrac.page.ProfilePage;
import com.racetrac.mobile.multisite.racetrac.page.PromotionalOffersPage;
import com.racetrac.mobile.multisite.racetrac.page.RewardsPopupPage;
import com.racetrac.mobile.multisite.racetrac.page.SignUpPage;
import com.racetrac.mobile.multisite.racetrac.page.SignUpSelectorPage;
import com.racetrac.mobile.multisite.racetrac.page.StoresPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnNotificationPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeAcceptTermsPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.ChromeMainPage;
import com.racetrac.mobile.multisite.racetrac.page.chrome.TurnOnSyncNowPage;
import com.racetrac.mobile.multisite.racetrac.page.diff.AccountSettingsPageAuthorised;
import com.racetrac.mobile.multisite.racetrac.page.safari.SafariBrowserPage;
import com.racetrac.mobile.multisite.racetrac.views.AndroidNavBar;
import com.racetrac.mobile.multisite.racetrac.views.CouponsView;
import com.racetrac.mobile.multisite.racetrac.views.ErrorMessageVIew;
import com.racetrac.mobile.multisite.racetrac.views.FraudErrorMessageView;
import com.racetrac.mobile.multisite.racetrac.views.IosNavBar;
import com.racetrac.mobile.multisite.racetrac.views.NavigationDrawer;
import com.racetrac.mobile.multisite.racetrac.views.NotAdultNotice;
import com.racetrac.mobile.multisite.racetrac.views.PointsAndLevelsView;
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
    //    SECTIONS
    NavigationDrawer navigationDrawer;
    AndroidNavBar androidNavBar;
    IosNavBar iosNavBar;
    ErrorMessageVIew errorMessageVIew;
    CouponsView couponsView;
    FraudErrorMessageView fraudErrorMessageView;
    PointsAndLevelsView pointsAndLevelsView;
    NotAdultNotice notAdultNotice;
    RewardsPopupPage rewardsPopupPage;

}