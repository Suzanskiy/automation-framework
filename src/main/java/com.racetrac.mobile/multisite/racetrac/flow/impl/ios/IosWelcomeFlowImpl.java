package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class IosWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    @Override
    @Step
    public boolean isHomePageOpened() {
        return getHomePage().waitUntilIsOpened();
    }

    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        return isHomePageOpened();
    }

    @Override
    public boolean isHeroLevelHelpBtnDisplayed() {
        try {
            return getHomePage().getHeroLevelHelpBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean isZeroPointsDescriptionDisplayed() {
        return false;
    }

    @Override
    public boolean isRewardsScreenFOrUserWithoutPointsDisplayed() {
        return false;
    }

    @Override
    public int availablePoints() {
        return 0;
    }

    @Override
    public boolean isRedeemPointsBtnDisplayed() {
        return false;
    }

    @Override
    public void clickOnRedeemPointsBtn() {

    }

    @Override
    public boolean isRewardsSectionForUserWithPointsDisplayed() {
        return false;
    }

    @Override
    public boolean isRedeemPointsIsDisplayed() {
        return getHomePage().getRedeemPointsBtn().isDisplayed();
    }

    @Override
    public void clickRedeemPointsBtn() {
        getHomePage().getRedeemPointsBtn().click();
    }
}