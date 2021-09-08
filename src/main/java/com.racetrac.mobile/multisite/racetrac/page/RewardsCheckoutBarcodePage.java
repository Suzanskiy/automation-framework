package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsCheckoutBarcodePage extends RewardsCheckoutPage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/image_barcode")
    private MobileElement barcode;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewards_number")
    private MobileElement rewardsNumber;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_unclaimed_count")
    private MobileElement unclaimedRewardsCounter;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkout_pay")
    private MobileElement payBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkout_done")
    private MobileElement doneBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/user_name")
    private MobileElement userName;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/user_email")
    private MobileElement userEmail;
}
