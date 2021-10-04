package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigationFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosBottomNavigationFlowImpl extends BaseFlow implements NavigationFlow {
    @Step
    @Override
    public void navigateToHome() {
        getIosNavBar().getHomeTab().click();
    }

    @Step
    @Override
    public void navigateToStores() {
        getIosNavBar().getStoresTab().click();
        try {
            getPriceDisclaimerPage().getOkButton().click();
        } catch (
                NoSuchElementException e) {
            LOG.info("Price disclaimer Page is not opened, but it is OK");
        }
    }

    @Step
    @Override
    public void navigateToCoupons() {
        getIosNavBar().getCouponsTab().click();
    }

    @Step
    @Override
    public void navigateToCards() {
        getIosNavBar().getCardsTab().click();
    }

    @Step
    @Override
    public void navigateToInbox() {
        getIosNavBar().getInboxTab().click();
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

    @Override
    public void navigateToRewardsCards() {

    }

    @Override
    public boolean isRewardCatalogDisplayed() {
        return getRewardsCatalogPage().waitUntilIsOpened();
    }

    @Override
    public void navigateToRewardsCatalogViaDrawer() {
        getHomePage().getRedeemPointsBtn().click();
    }

    @Override
    public void rewardCatalogClick() {

    }

    @Override
    public void navigateToHomeFromCouponsPage() {

    }

}

