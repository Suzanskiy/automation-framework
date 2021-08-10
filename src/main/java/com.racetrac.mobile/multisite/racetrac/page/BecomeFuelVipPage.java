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
public class BecomeFuelVipPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_not_right_now")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not right now\"]")
    private MobileElement notRightNowBtn;
}