package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FuelSavingsPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/top_header_fuel_saving_breakdown")
    private WebElement header;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelSavingDesc")
    private WebElement description;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/debitFuelSavingLayout")
    private WebElement debitCardSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/vipFuelSavingLayout")
    private WebElement VipSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsFuelSavingLayout")
    private WebElement RewardsSavings;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/potentialSavingTitle")
    private WebElement footer;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/img_close_fuel_saving_breakdown")
    private WebElement backBtn;
}
