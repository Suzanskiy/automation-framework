package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsDebitCardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_rewards_debit_card")
    private WebElement rewardsDebitCardText;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvRewardDebitCardNumber")
    private WebElement addCardBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tvPromotionalTileCaption")
    private WebElement orderRewardCardButton;
}
