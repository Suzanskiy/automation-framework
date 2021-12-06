package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FuelSavingsPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_header_fuel_saving_breakdown")
    private MobileElement header;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelSavingDesc")
    private MobileElement description;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/debitFuelSavingLayout")
    private MobileElement debitCardSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipFuelSavingLayout")
    private MobileElement VipSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsFuelSavingLayout")
    private MobileElement RewardsSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/potentialSavingTitle")
    private MobileElement footer;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_close_fuel_saving_breakdown")
    private MobileElement backBtn;
}
