package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Component
@Profile(ANDROID)
public class AndroidDrawerNavigationFlowImpl extends BaseFlow implements NavigationFlow {

    @Override
    public void navigateToHome() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getHomeTab().click();
    }

    @Override
    public void navigateToStores() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getStoresTab().click();
        getPriceDisclaimerPage().getOkButton().click();
    }

    @Override
    public void navigateToCoupons() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getCouponsTab().click();

    }

    @Override
    public void navigateToCards() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getCardsTab().click();
    }

    @Override
    public void navigateToInbox() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getInboxTab().click();
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
        return false;
    }

    @Override
    public boolean isInboxTabOpened() {
        return false;
    }
}
