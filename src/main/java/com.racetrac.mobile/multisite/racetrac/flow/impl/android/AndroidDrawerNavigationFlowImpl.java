package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Component
@Profile(ANDROID)
public class AndroidDrawerNavigationFlowImpl extends BaseFlow implements NavigationFlow {
    @Step
    @Override
    public void navigateToHome() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getHomeTab().click();
    }

    @Step
    @Override
    public void navigateToStores() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getStoresTab().click();
        getPriceDisclaimerPage().waitUntilIsOpened();
        getPriceDisclaimerPage().getOkButton().click();
    }

    @Step
    @Override
    public void navigateToCoupons() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getCouponsTab().click();

    }
    @Step
    @Override
    public void navigateToCards() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getCardsTab().click();
    }
    @Step
    @Override
    public void navigateToInbox() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getInboxTab().click();
    }
    @Step
    @Override
    public boolean isHomeTabOpened() {
        return getHomePage().waitUntilIsOpened();
    }
    @Step
    @Override
    public boolean isStoresTabOpened() {
        return getStoresPage().waitUntilIsOpened();
    }
    @Step
    @Override
    public boolean isCouponsTabOpened() {
        return getCouponsPage().waitUntilIsOpened();
    }
    @Step
    @Override
    public boolean isCardsTabOpened() {
        return getCardsPage().waitUntilIsOpened();
    }
    @Step
    @Override
    public boolean isInboxTabOpened() {
        return getInboxPage().waitUntilIsOpened();
    }
}
