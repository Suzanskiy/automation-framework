package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.PriceDisclaimerPage;
import com.racetrac.mobile.multisite.racetrac.page.StoresPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.views.AndroidNavBar;
import com.racetrac.mobile.multisite.racetrac.views.IosNavBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseFlow {
    //     PAGES
    HomePage homePage;
    TurnOnLocationPage turnOnLocationPage;
    StoresPage storesPage;
    PriceDisclaimerPage priceDisclaimerPage;
    //    SECTIONS
    AndroidNavBar androidNavBar;
    IosNavBar iosNavBar;

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
