package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidPointsAndLevelFlowImpl extends BaseFlow implements PointsAndLevelsFlow {

    @Override
    public void clickGotItBtn() {
        getPointsAndLevelsView().waitUntilIsOpened();
        getPointsAndLevelsView().getPointsGotItBtn().click();
    }
}
