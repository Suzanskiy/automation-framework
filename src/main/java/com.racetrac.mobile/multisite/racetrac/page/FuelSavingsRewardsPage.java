package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FuelSavingsRewardsPage extends BaseMobilePage {

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_back_btn")
    private WebElement backBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_image")
    private WebElement image;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuel_rewards_title")
    private WebElement title;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelRewardsDesc")
    private WebElement description;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/fuelRewardsRedeemPointsBtn")
    private WebElement redeemPointsBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_not_right_now")
    private WebElement footer;
}
