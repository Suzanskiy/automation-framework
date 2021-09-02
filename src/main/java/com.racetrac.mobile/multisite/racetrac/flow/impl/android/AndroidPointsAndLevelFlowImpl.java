package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidPointsAndLevelFlowImpl extends BaseFlow implements PointsAndLevelsFlow {

    @Step
    @Override
    public void clickGotItBtn() {
        try {
            getPointsAndLevelsView().waitUntilIsOpened();
            getPointsAndLevelsView().getPointsGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Points and Levels screen not opened, skipping..");
        }
    }

    @Step
    @Override
    public void clickOnHeroLevelHelpBtn() {
        getHomePage().getHeroLevelHelpBtn().click();
    }

    @Step
    @Override
    public boolean isPointsAndLevelsPageOpened() {
        return getPointsAndLevelsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isPointsAndTiersSectionIsOpened() {
        return getPointsAndTiersPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isHowItWorksSectionIsOpened() {
        return getHowItWorksPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isTierExpirationDetailsDisplayed() {
        return getPointsAndTiersPage().getTierExpirationDetails().isDisplayed();
    }

    @Step
    @Override
    public void clickOnDetailsBtn() {
        getPointsAndTiersPage().getLevelDetailsBtn().click();
    }

    @Step
    @Override
    public void clickOnCloseDetailsBtn() {
        getPointsAndTiersPage().getCloseDetailsBtn().click();
    }

    @Step
    @Override
    public void clickOnHowItWorksSectionBtn() {
        getPointsAndLevelsPage().getHowItWorksSectionBtn().click();
    }

    @Step
    @Override
    public void clickOnCloseActivityBtn() {
        getPointsAndLevelsPage().getCloseActivityBtn().click();
    }
}
