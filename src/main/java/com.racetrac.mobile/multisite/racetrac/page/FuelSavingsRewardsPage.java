package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FuelSavingsRewardsPage extends BaseMobilePage {

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_back_btn")
    private MobileElement backBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_image")
    private MobileElement image;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_title")
    private MobileElement title;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelRewardsDesc")
    private MobileElement description;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelRewardsRedeemPointsBtn")
    private MobileElement redeemPointsBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_not_right_now")
    private MobileElement footer;
}
