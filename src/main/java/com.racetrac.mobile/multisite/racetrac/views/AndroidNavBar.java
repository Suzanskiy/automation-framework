package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AndroidNavBar extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_home")
    private WebElement homeTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_stores")
    private WebElement storesTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_coupons")
    private WebElement couponsTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_pay_with_gift_card")
    private WebElement cardsTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_inbox")
    private WebElement inboxTab;

    @AndroidFindBy (id = "com.RaceTrac.Common.qa:id/nav_rewards_card")
    private WebElement rewardsCardsTab;

    @AndroidFindBy (id = "com.RaceTrac.Common.qa:id/nav_rewards_catalog")
    private WebElement rewardsCatalog;

}
