package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PointsAndLevelsView extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=AndroidWelcomeFlowImplGOT IT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/pointsAndLevelsTutorialGotItButton")
    private MobileElement pointsGotItBtn;
}
