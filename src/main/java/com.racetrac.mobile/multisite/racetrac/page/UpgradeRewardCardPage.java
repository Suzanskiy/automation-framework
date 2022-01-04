package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UpgradeRewardCardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_image")
    private WebElement upgradeRewardCardImage;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_title")
    private WebElement addCardBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgradeRewardsCardBtn")
    private WebElement upgradeyourCardButton;
}
