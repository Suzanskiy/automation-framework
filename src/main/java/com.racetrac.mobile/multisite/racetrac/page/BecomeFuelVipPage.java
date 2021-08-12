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

    private static final String DESCRIPTION_TEXT = "To get the most out of RaceTrac Rewards, " +
            "Rewards members can upgrade to the VIP level and unlock fuel savings.";

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_not_right_now")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not right now\"]")
    private MobileElement notRightNowBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_get_started")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GET STARTED!\"]")
    private MobileElement getStartedBtn;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_learn_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LEARN MORE\"]")
    private MobileElement learnMoreBtn;

    @PageLoading
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_TEXT + "\")")
    @iOSXCUITFindBy(accessibility = DESCRIPTION_TEXT)
    private MobileElement descriptionText;
}
