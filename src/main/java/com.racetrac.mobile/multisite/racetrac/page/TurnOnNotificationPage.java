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
public class TurnOnNotificationPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "notNowButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NOT NOW\"]")
    private MobileElement notNowBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TURN ON\"]")
    @AndroidFindBy(id = "notNowButton")//fixme wrong selectors on android
    private MobileElement turnOnBtn;
}