package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.AccountPage;
import com.racetrac.mobile.multisite.racetrac.page.BecomeFuelVipPage;
import com.racetrac.mobile.multisite.racetrac.page.CardsPage;
import com.racetrac.mobile.multisite.racetrac.page.CouponsPage;
import com.racetrac.mobile.multisite.racetrac.page.FistBumpPage;
import com.racetrac.mobile.multisite.racetrac.page.ForgotPassPage;
import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.InboxPage;
import com.racetrac.mobile.multisite.racetrac.page.LoginPage;
import com.racetrac.mobile.multisite.racetrac.page.PriceDisclaimerPage;
import com.racetrac.mobile.multisite.racetrac.page.PromotionalOffersPage;
import com.racetrac.mobile.multisite.racetrac.page.SignUpPage;
import com.racetrac.mobile.multisite.racetrac.page.SignUpSelectorPage;
import com.racetrac.mobile.multisite.racetrac.page.StoresPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnNotificationPage;
import com.racetrac.mobile.multisite.racetrac.views.AndroidNavBar;
import com.racetrac.mobile.multisite.racetrac.views.CouponsView;
import com.racetrac.mobile.multisite.racetrac.views.ErrorMessageVIew;
import com.racetrac.mobile.multisite.racetrac.views.FraudErrorMessageView;
import com.racetrac.mobile.multisite.racetrac.views.IosNavBar;
import com.racetrac.mobile.multisite.racetrac.views.NavigationDrawer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
    AccountPage accountPage;
    ForgotPassPage forgotPassPage;
    SignUpSelectorPage signUpSelectorPage;
    TurnOnNotificationPage turnOnNotificationPage;
    PromotionalOffersPage promotionalOffersPage;
    BecomeFuelVipPage becomeFuelVipPage;
    //    SECTIONS
    NavigationDrawer navigationDrawer;
    AndroidNavBar androidNavBar;
    IosNavBar iosNavBar;
    ErrorMessageVIew errorMessageVIew;
    CouponsView couponsView;
    FraudErrorMessageView fraudErrorMessageView;

    //Getters

    public BecomeFuelVipPage getBecomeFuelVipPage() {
        return becomeFuelVipPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public TurnOnLocationPage getTurnOnLocationPage() {
        return turnOnLocationPage;
    }

    public StoresPage getStoresPage() {
        return storesPage;
    }

    public PriceDisclaimerPage getPriceDisclaimerPage() {
        return priceDisclaimerPage;
    }

    public CouponsPage getCouponsPage() {
        return couponsPage;
    }

    public CardsPage getCardsPage() {
        return cardsPage;
    }

    public PromotionalOffersPage getPromotionalOffersPage() {
        return promotionalOffersPage;
    }

    public InboxPage getInboxPage() {
        return inboxPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public FistBumpPage getFistBumpPage() {
        return fistBumpPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AccountPage getAccountPage() {
        return accountPage;
    }

    public ForgotPassPage getForgotPassPage() {
        return forgotPassPage;
    }

    public SignUpSelectorPage getSignUpSelectorPage() {
        return signUpSelectorPage;
    }

    public TurnOnNotificationPage getTurnOnNotificationPage() {
        return turnOnNotificationPage;
    }

    public NavigationDrawer getNavigationDrawer() {
        return navigationDrawer;
    }

    public AndroidNavBar getAndroidNavBar() {
        return androidNavBar;
    }

    public IosNavBar getIosNavBar() {
        return iosNavBar;
    }

    public ErrorMessageVIew getErrorMessageVIew() {
        return errorMessageVIew;
    }

    public CouponsView getCouponsView() {
        return couponsView;
    }

    public FraudErrorMessageView getFraudErrorMessageView() {
        return fraudErrorMessageView;
    }


    //Setters


    @Autowired
    public void setHomePage(final HomePage homePage) {
        this.homePage = homePage;
    }

    @Autowired
    public void setTurnOnLocationPage(final TurnOnLocationPage turnOnLocationPage) {
        this.turnOnLocationPage = turnOnLocationPage;
    }

    @Autowired
    public void setStoresPage(final StoresPage storesPage) {
        this.storesPage = storesPage;
    }

    @Autowired
    public void setPriceDisclaimerPage(final PriceDisclaimerPage priceDisclaimerPage) {
        this.priceDisclaimerPage = priceDisclaimerPage;
    }

    @Autowired
    public void setCouponsPage(final CouponsPage couponsPage) {
        this.couponsPage = couponsPage;
    }

    @Autowired
    public void setCardsPage(final CardsPage cardsPage) {
        this.cardsPage = cardsPage;
    }

    @Autowired
    public void setInboxPage(final InboxPage inboxPage) {
        this.inboxPage = inboxPage;
    }

    @Autowired
    public void setSignUpPage(final SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    @Autowired
    public void setFistBumpPage(final FistBumpPage fistBumpPage) {
        this.fistBumpPage = fistBumpPage;
    }

    @Autowired
    public void setLoginPage(final LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Autowired
    public void setAccountPage(final AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    @Autowired
    public void setForgotPassPage(final ForgotPassPage forgotPassPage) {
        this.forgotPassPage = forgotPassPage;
    }

    @Autowired
    public void setSignUpSelectorPage(final SignUpSelectorPage signUpSelectorPage) {
        this.signUpSelectorPage = signUpSelectorPage;
    }

    @Autowired
    public void setPromotionalOffersPage(final PromotionalOffersPage promotionalOffersPage) {
        this.promotionalOffersPage = promotionalOffersPage;
    }

    @Autowired
    public void setBecomeFuelVipPage(final BecomeFuelVipPage becomeFuelVipPage) {
        this.becomeFuelVipPage = becomeFuelVipPage;
    }

    @Autowired
    public void setTurnOnNotificationPage(final TurnOnNotificationPage turnOnNotificationPage) {
        this.turnOnNotificationPage = turnOnNotificationPage;
    }

    @Autowired
    public void setNavigationDrawer(final NavigationDrawer navigationDrawer) {
        this.navigationDrawer = navigationDrawer;
    }

    @Autowired
    public void setAndroidNavBar(final AndroidNavBar androidNavBar) {
        this.androidNavBar = androidNavBar;
    }

    @Autowired
    public void setIosNavBar(final IosNavBar iosNavBar) {
        this.iosNavBar = iosNavBar;
    }

    @Autowired
    public void setErrorMessageVIew(final ErrorMessageVIew errorMessageVIew) {
        this.errorMessageVIew = errorMessageVIew;
    }

    @Autowired
    public void setCouponsView(final CouponsView couponsView) {
        this.couponsView = couponsView;
    }

    @Autowired
    public void setFraudErrorMessageView(final FraudErrorMessageView fraudErrorMessageView) {
        this.fraudErrorMessageView = fraudErrorMessageView;
    }
}
