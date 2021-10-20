package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
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

    @Step
    @Override
    public void navigateToRewardsCards() {
        getNavigationDrawer().getDrawer().click();
        getAndroidNavBar().getRewardsCardsTab().click();
    }

    @Step
    @Override
    public boolean isRewardCatalogDisplayed() {
        try {
            return getAndroidNavBar().getRewardsCatalog().isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.warn("Reward catalog tab is not displayed");
            return false;
        }
    }

    @Step
    @Override
    public void navigateToRewardsCatalogViaDrawer() {
        getNavigationDrawer().getDrawer().click();
    }

    @Step
    @Override
    public void rewardCatalogClick() {
        getAndroidNavBar().getRewardsCatalog().click();
    }

    @Step
    @Override
    public void navigateToHomeFromCouponsPage() {
        getNavigationDrawer().getDrawerFromCouponsPage().click();
        getAndroidNavBar().getHomeTab().click();
    }
    @Step
    @Override
    public boolean isNearestStorePageOpened() {
        AppiumWaitingUtils.waitUntilElementClickable(getNearestStorePage().getStoreName());
        return getNearestStorePage().waitUntilIsOpened();
    }
}
