package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public abstract class RewardsCheckoutPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Checkout\"]")
    private MobileElement pageTitle;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Scan barcode\")]")
    private MobileElement checkoutSubtitle;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_checkout_back")
    private MobileElement closeCheckoutPageBtn;

}
