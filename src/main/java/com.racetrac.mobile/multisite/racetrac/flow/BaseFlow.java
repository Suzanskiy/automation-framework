package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.AccountPage;
import com.racetrac.mobile.multisite.racetrac.page.CardsPage;
import com.racetrac.mobile.multisite.racetrac.page.CouponsPage;
import com.racetrac.mobile.multisite.racetrac.page.EmailConfirmationPage;
import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.InboxPage;
import com.racetrac.mobile.multisite.racetrac.page.LoginPage;
import com.racetrac.mobile.multisite.racetrac.page.PriceDisclaimerPage;
import com.racetrac.mobile.multisite.racetrac.page.SignUpPage;
import com.racetrac.mobile.multisite.racetrac.page.StoresPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.views.AndroidNavBar;
import com.racetrac.mobile.multisite.racetrac.views.CouponsView;
import com.racetrac.mobile.multisite.racetrac.views.ErrorMessageVIew;
import com.racetrac.mobile.multisite.racetrac.views.IosNavBar;
import com.racetrac.mobile.multisite.racetrac.views.NavigationDrawer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseFlow {
    //     PAGES
    HomePage homePage;
    TurnOnLocationPage turnOnLocationPage;
    StoresPage storesPage;
    PriceDisclaimerPage priceDisclaimerPage;
    CouponsPage couponsPage;
    CardsPage cardsPage;
    InboxPage inboxPage;
    SignUpPage signUpPage;
    EmailConfirmationPage emailConfirmationPage;
    LoginPage loginPage;
    AccountPage accountPage;
    //    SECTIONS
    NavigationDrawer navigationDrawer;
    AndroidNavBar androidNavBar;
    IosNavBar iosNavBar;
    ErrorMessageVIew errorMessageVIew;
    CouponsView couponsView;

    public AccountPage getAccountPage() {
        accountPage.waitUntilIsOpened();
        return accountPage;
    }

    @Autowired
    public void setAccountPage(final AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    public CouponsView getCouponsView() {
        couponsView.waitUntilIsOpened();
        return couponsView;
    }

    @Autowired
    public void setCouponsView(final CouponsView couponsView) {
        this.couponsView = couponsView;
    }

    public LoginPage getLoginPage() {
        loginPage.waitUntilIsOpened();
        return loginPage;
    }

    @Autowired
    public void setLoginPage(final LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public ErrorMessageVIew getErrorMessageVIew() {
        errorMessageVIew.waitUntilIsOpened();
        return errorMessageVIew;
    }

    @Autowired
    public void setErrorMessageVIew(final ErrorMessageVIew errorMessageVIew) {
        this.errorMessageVIew = errorMessageVIew;
    }

    public EmailConfirmationPage getEmailConfirmationPage() {
        emailConfirmationPage.waitUntilIsOpened();
        return emailConfirmationPage;
    }

    @Autowired
    public void setEmailConfirmationPage(final EmailConfirmationPage emailConfirmationPage) {
        this.emailConfirmationPage = emailConfirmationPage;
    }

    public SignUpPage getSignUpPage() {
        signUpPage.waitUntilIsOpened();
        return signUpPage;
    }

    @Autowired
    public void setSignUpPage(final SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    public InboxPage getInboxPage() {
        inboxPage.waitUntilIsOpened();
        return inboxPage;
    }

    @Autowired
    public void setInboxPage(final InboxPage inboxPage) {
        this.inboxPage = inboxPage;
    }

    public CardsPage getCardsPage() {
        cardsPage.waitUntilIsOpened();
        return cardsPage;
    }

    @Autowired
    public void setCardsPage(final CardsPage cardsPage) {
        this.cardsPage = cardsPage;
    }

    public NavigationDrawer getNavigationDrawer() {
        navigationDrawer.waitUntilIsOpened();
        return navigationDrawer;
    }

    @Autowired
    public void setNavigationDrawer(final NavigationDrawer navigationDrawer) {
        this.navigationDrawer = navigationDrawer;
    }

    public CouponsPage getCouponsPage() {
        couponsPage.waitUntilIsOpened();
        return couponsPage;
    }

    @Autowired
    public void setCouponsPage(final CouponsPage couponsPage) {
        this.couponsPage = couponsPage;
    }

    public TurnOnLocationPage getTurnOnLocationPage() {
        turnOnLocationPage.waitUntilIsOpened();
        return turnOnLocationPage;
    }

    @Autowired
    public void setTurnOnLocationPage(final TurnOnLocationPage turnOnLocationPage) {
        this.turnOnLocationPage = turnOnLocationPage;
    }

    public HomePage getHomePage() {
        homePage.waitUntilIsOpened();
        return homePage;
    }

    @Autowired
    public void setHomePage(final HomePage homePage) {
        this.homePage = homePage;
    }

    public StoresPage getStoresPage() {
        storesPage.waitUntilIsOpened();
        return storesPage;
    }

    @Autowired
    public void setStoresPage(final StoresPage storesPage) {
        this.storesPage = storesPage;
    }

    public AndroidNavBar getAndroidNavBar() {
        androidNavBar.waitUntilIsOpened();
        return androidNavBar;
    }

    @Autowired
    public void setAndroidNavBar(final AndroidNavBar androidNavBar) {
        this.androidNavBar = androidNavBar;
    }

    public IosNavBar getIosNavBar() {
        iosNavBar.waitUntilIsOpened();
        return iosNavBar;
    }

    @Autowired
    public void setIosNavBar(final IosNavBar iosNavBar) {
        this.iosNavBar = iosNavBar;
    }

    public PriceDisclaimerPage getPriceDisclaimerPage() {
        priceDisclaimerPage.waitUntilIsOpened();
        return priceDisclaimerPage;
    }

    @Autowired
    public void setPriceDisclaimerPage(final PriceDisclaimerPage priceDisclaimerPage) {
        this.priceDisclaimerPage = priceDisclaimerPage;
    }
}
