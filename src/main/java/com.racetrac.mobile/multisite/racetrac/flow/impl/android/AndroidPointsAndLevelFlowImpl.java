package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidPointsAndLevelFlowImpl extends BaseFlow implements PointsAndLevelsFlow {

    @Override
    public void clickGotItBtn() {
        try {
            getPointsAndLevelsView().waitUntilIsOpened();
            getPointsAndLevelsView().getPointsGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Points and Levels screen not opened, skipping..");
        }
    }
}
