package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SadSmileRewardCatalogView extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id="com.RaceTrac.Common.qa:id/imageView7")
    @iOSXCUITFindBy(accessibility = "Whoops! Looks like you already have this Reward in your cart. You can only redeem one Fuel Reward at a time")
    private MobileElement sadSmileDescription;

    @PageLoading
    @AndroidFindBy(id="com.RaceTrac.Common.qa:id/buttonOK")
    private MobileElement okSadSmileBtn;
}
