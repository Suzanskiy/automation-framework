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
public class SuccessfulSentGiftPopUpPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    private MobileElement okBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Your coupon\")]")
    @iOSXCUITFindBy(accessibility = "Your coupon has been sent!")
    private MobileElement successfulInformMessage;

}
