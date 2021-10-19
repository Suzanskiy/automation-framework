package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class UpgradeRewardCardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_image")
    private MobileElement upgradeRewardCardImage;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_title")
    private MobileElement addCardBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgradeRewardsCardBtn")
    private MobileElement upgradeyourCardButton;
}
