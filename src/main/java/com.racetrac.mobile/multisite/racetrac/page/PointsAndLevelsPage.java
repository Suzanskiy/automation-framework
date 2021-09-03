package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PointsAndLevelsPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "NavBarClose")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_close_activity")
    private MobileElement closeActivityBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Points & Tiers")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_points_and_levels")
    private MobileElement pointsAndLevelPageTitle;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"POINTS & TIERS\"]")
    @AndroidFindBy(accessibility = "POINTS & TIERS")
    private MobileElement pointsAndTiersSectionBtn;

    @PageLoading
    @AndroidFindBy(accessibility = "HOW IT WORKS")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"HOW IT WORKS\"]")
    private MobileElement howItWorksSectionBtn;
}
