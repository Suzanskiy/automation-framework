package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PointsAndLevelsPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_close_activity")
    private MobileElement closeActivityBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_points_and_levels")
    private MobileElement pointsAndLevelPageTitle;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/desc_how_it_works")
    private MobileElement howItWorksElement;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sliding_tabs")
    private MobileElement slidingTabs;

    @PageLoading
    @AndroidFindBy(accessibility = "POINTS & TIERS")
    private MobileElement pointsAndTiersSectionBtn;

    @PageLoading
    @AndroidFindBy(accessibility = "HOW IT WORKS")
    private MobileElement howItWorksSectionBtn;
}
