package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseFlow {

    HomePage homePage;
    TurnOnLocationPage turnOnLocationPage;

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
}
