package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AndroidNavBar extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_home")
    private MobileElement homeTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_stores")
    private MobileElement storesTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_coupons")
    private MobileElement couponsTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_pay_with_gift_card")
    private MobileElement cardsTab;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/nav_inbox")
    private MobileElement inboxTab;

    @AndroidFindBy (id = "com.RaceTrac.Common.qa:id/nav_rewards_card")
    private MobileElement rewardsCardsTab;

    @AndroidFindBy (id = "com.RaceTrac.Common.qa:id/nav_rewards_catalog")
    private MobileElement rewardsCatalog;

}
