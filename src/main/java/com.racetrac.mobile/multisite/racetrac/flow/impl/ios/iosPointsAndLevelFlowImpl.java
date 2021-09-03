package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPointsAndLevelFlowImpl extends BaseFlow implements PointsAndLevelsFlow {

    @Override
    public void clickGotItBtn() {
        try {
            getPointsAndLevelsView().waitUntilIsOpened();
            getPointsAndLevelsView().getPointsGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException ignored) {
        }
    }

    @Override
    public void clickOnHeroLevelHelpBtn() {
        getHomePage().getHeroLevelHelpBtn().click();
    }

    @Override
    public boolean isPointsAndLevelsPageOpened() {
        return getPointsAndLevelsPage().waitUntilIsOpened();
    }

    @Override
    public boolean isPointsAndTiersSectionIsOpened() {
        return getPointsAndTiersPage().waitUntilIsOpened();
    }

    @Override
    public boolean isHowItWorksSectionIsOpened() {
        return getHowItWorksPage().waitUntilIsOpened();
    }

    @Override
    public boolean isTierExpirationDetailsDisplayed() {
        return getPointsAndTiersPage().getTierExpirationDetails().isDisplayed();
    }

    @Override
    public void clickOnDetailsBtn() {
        getPointsAndTiersPage().getLevelDetailsBtn().click();
    }

    @Override
    public void clickOnCloseDetailsBtn() {
        getPointsAndTiersPage().getCloseDetailsBtn().click();
    }

    @Override
    public void clickOnHowItWorksSectionBtn() {
        getPointsAndLevelsPage().getHowItWorksSectionBtn().click();
    }

    @Override
    public void clickOnCloseActivityBtn() {
        getPointsAndLevelsPage().getCloseActivityBtn().click();
    }
}
