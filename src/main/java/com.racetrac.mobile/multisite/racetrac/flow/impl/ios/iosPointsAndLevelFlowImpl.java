package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PointsAndLevelsFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPointsAndLevelFlowImpl extends BaseFlow implements PointsAndLevelsFlow {

    @Override
    public void clickGotItBtn() {
// TODO: 22.06.2021 Not implementen on Ios from dev
    }
}
