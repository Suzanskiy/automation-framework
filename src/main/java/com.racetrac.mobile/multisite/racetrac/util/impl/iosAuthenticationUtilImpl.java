package com.racetrac.mobile.multisite.racetrac.util.impl;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.page.HomePage;
import com.racetrac.mobile.multisite.racetrac.page.RewardsPopupPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.page.diff.AccountSettingsPageAuthorised;
import com.racetrac.mobile.multisite.racetrac.util.AuthenticationUtil;
import com.racetrac.mobile.multisite.racetrac.views.PointsAndLevelsView;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosAuthenticationUtilImpl extends BaseFlow implements AuthenticationUtil {
    @Autowired
    SignOutFlow signOutFlow;
    @Autowired
    BaseFlow baseFlow;

    @Override
    public void prepareAppAfterBrokenSignOut() {

        TurnOnLocationPage turnOnLocationPage = getTurnOnLocationPage();
        PointsAndLevelsView points = getPointsAndLevelsView();
        RewardsPopupPage rewards = getRewardsPopupPage();
        HomePage homePage = getHomePage();
        AccountSettingsPageAuthorised accountSettingsPageAuthorised = getAccountSettingsPageAuthorised();


        tryToCloseLocationPage(turnOnLocationPage);
        tryToClosePointsView(points);
        tryToCLoseRewardView(rewards);


        if (homePage.shortWaitUntilIsOpened()) {
            homePage.getIconSettings().click();
            if (checkAccountSettingsPage(accountSettingsPageAuthorised)) {
                signOutFlow.doSignOut();
            } else {
                getAccountSettingsPage().getNavBarCloseBtn().click();
            }
        } else {
            LOG.warn("Unable to do signout before test");
        }
    }

    private boolean checkAccountSettingsPage(final AccountSettingsPageAuthorised accountSettingsPageAuthorised) {
        try {
            final boolean isOpened = accountSettingsPageAuthorised.shortWaitUntilIsOpened();
            accountSettingsPageAuthorised.getNavBarCloseBtn().click();
            return isOpened;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void tryToCLoseRewardView(final RewardsPopupPage rewards) {
        try {
            if (rewards.shortWaitUntilIsOpened()) {
                rewards.getGotItBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }

    private void tryToClosePointsView(final PointsAndLevelsView points) {

        try {
            if (points.shortWaitUntilIsOpened()) {
                points.getPointsGotItBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }

    private void tryToCloseLocationPage(final TurnOnLocationPage turnOnLocationPage) {

        try {
            if (turnOnLocationPage.shortWaitUntilIsOpened()) {
                turnOnLocationPage.getNotNowBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }
}