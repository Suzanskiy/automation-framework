package com.racetrac.mobile.multisite.racetrac.util.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import com.racetrac.mobile.multisite.racetrac.page.RewardsPopupPage;
import com.racetrac.mobile.multisite.racetrac.page.TurnOnLocationPage;
import com.racetrac.mobile.multisite.racetrac.util.AuthenticationUtil;
import com.racetrac.mobile.multisite.racetrac.views.PointsAndLevelsView;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Profile(IOS)
@Component
public class iosAuthenticationUtilImpl extends BaseFlow implements AuthenticationUtil {
    @Autowired
    SignOutFlow signOutFlow;

    @Override
    public void prepareAppAfterBrokenSignOut() {
        getDriver().launchApp();

        if (!getHomePage().waitUntilIsOpened()) {
            tryToCloseLocationPage(getTurnOnLocationPage());
            tryToClosePointsView(getPointsAndLevelsView());
            tryToCLoseRewardView(getRewardsPopupPage());
            signOutFlow.doSignOut();
        }
    }

    private void tryToCLoseRewardView(final RewardsPopupPage rewards) {
        try {
            if (rewards.waitUntilIsOpened()) {
                rewards.getGotItBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }

    private void tryToClosePointsView(final PointsAndLevelsView points) {

        try {
            if (points.waitUntilIsOpened()) {
                points.getPointsGotItBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }

    private void tryToCloseLocationPage(final TurnOnLocationPage turnOnLocationPage) {

        try {
            if (turnOnLocationPage.waitUntilIsOpened()) {
                turnOnLocationPage.getNotNowBtn().click();
            }
        } catch (TimeoutException ignored) {
        }
    }
}