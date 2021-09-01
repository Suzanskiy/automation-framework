package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PointsAndTiersPage extends PointsAndLevelsPage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_you_have")
    private MobileElement youHaveElement;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_available_points")
    private MobileElement availablePoints;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_member_next_tier")
    private MobileElement pointsToNextTier;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_member_tier")
    private MobileElement memberTierImg;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/progress_bar_milestone")
    private MobileElement progressBarMilestone;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_label_level")
    private MobileElement labelLevelName;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_level_expires")
    private MobileElement levelExpires;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_level_expires_date")
    private MobileElement levelExpiresDate;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_level_detail")
    private MobileElement levelDetailsBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_description")
    private MobileElement levelDescription;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/recyclerView_levels")
    private MobileElement levelsRecycleView;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/layout_tier_expiry_detail")
    private MobileElement tierExpirationDetails;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_tier_expiration_close")
    private MobileElement closeDetailsBtn;
}
