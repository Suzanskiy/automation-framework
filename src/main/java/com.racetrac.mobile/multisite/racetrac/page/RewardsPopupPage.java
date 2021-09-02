package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsPopupPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GOT IT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsTutorialGotItButton")
    private MobileElement gotItBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemButton")
    private MobileElement redeemBtn;


}