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
        } catch (NoSuchElementException | TimeoutException e) {
        }
    }

    @Override
    public void clickOnHeroLevelHelpBtn() {
    }

    @Override
    public boolean isPointsAndLevelsPageOpened() {
        return false;
    }

    @Override
    public boolean isPointsAndTiersSectionIsOpened() {
        return false;
    }

    @Override
    public boolean isHowItWorksSectionIsOpened() {
        return false;
    }

    @Override
    public boolean isTierExpirationDetailsDisplayed() {
        return false;
    }

    @Override
    public void clickOnDetailsBtn() {

    }

    @Override
    public void clickOnCloseDetailsBtn() {

    }

    @Override
    public void clickOnHowItWorksSectionBtn() {

    }

    @Override
    public void clickOnCloseActivityBtn() {

    }
}
