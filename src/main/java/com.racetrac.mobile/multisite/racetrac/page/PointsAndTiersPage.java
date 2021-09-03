package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PointsAndTiersPage extends PointsAndLevelsPage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "YOU HAVE")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_you_have")
    private MobileElement youHaveElement;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Available Points')]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_available_points")
    private MobileElement availablePoints;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Progress")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_member_next_tier")
    private MobileElement pointsToNextTier;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_member_tier")
    private MobileElement memberTierImg;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/progress_bar_milestone")
    private MobileElement progressBarMilestone;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_label_level")
    private MobileElement labelLevelName;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Tier Expires")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_level_expires")
    private MobileElement levelExpires;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_level_expires_date")
    private MobileElement levelExpiresDate;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DETAILS\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_level_detail")
    private MobileElement levelDetailsBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'As you earn')]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_description")
    private MobileElement levelDescription;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/recyclerView_levels")
    private MobileElement levelsRecycleView;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/layout_tier_expiry_detail")
    @iOSXCUITFindBy(accessibility = "Tier Expiration")
    private MobileElement tierExpirationDetails;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CLOSE\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_tier_expiration_close")
    private MobileElement closeDetailsBtn;
}
