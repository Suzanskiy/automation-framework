package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsCatalogPage extends BaseMobilePage {

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemButton")
    private MobileElement redeemBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/button_redeem")
    private MobileElement redeemPopupBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/unclaimedRewardsLabel")
    private MobileElement unclaimedRewardsLabel;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/memberPoints")
    private MobileElement rewardsCatalogNumberOfPoints;

}
