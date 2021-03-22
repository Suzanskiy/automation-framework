package com.racetrac.mobile.multisite.lux.flow;


import com.racetrac.mobile.multisite.lux.page.WelcomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseFlow {

  WelcomePage welcomePage;

    public WelcomePage getWelcomePage() {
        welcomePage.waitUntilIsOpened();
        return welcomePage;
    }

    @Autowired
    public void setWelcomePage(final WelcomePage welcomePage) {
        this.welcomePage = welcomePage;
    }
}
