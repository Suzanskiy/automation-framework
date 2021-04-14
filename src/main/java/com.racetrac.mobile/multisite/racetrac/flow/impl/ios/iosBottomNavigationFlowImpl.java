package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosBottomNavigationFlowImpl extends BaseFlow implements NavigationFlow {

    @Override
    public void navigateToHome() {
        getIosNavBar().getHomeTab().click();
    }

    @Override
    public void navigateToStores() {
        getIosNavBar().getStoresTab().click();
        getPriceDisclaimerPage().getOkButton().click();
    }

    @Override
    public void navigateToCoupons() {
        getIosNavBar().getCouponsTab().click();
    }

    @Override
    public void navigateToCards() {
        getIosNavBar().getCardsTab().click();
    }

    @Override
    public void navigateToInbox() {
        getIosNavBar().getInboxTab().click();
    }

    @Override
    public boolean isHomeTabOpened() {
        return getHomePage().isOpened();
    }

    @Override
    public boolean isStoresTabOpened() {
        return getStoresPage().isOpened();
    }

    @Override
    public boolean isCouponsTabOpened() {
        return getCouponsPage().isOpened();
    }

    @Override
    public boolean isCardsTabOpened() {
        return getCardsPage().isOpened();
    }

    @Override
    public boolean isInboxTabOpened() {
        return getInboxPage().isOpened();
    }
}
