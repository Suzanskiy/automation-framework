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
public class FraudErrorMessageView extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"Hmm… we don't recognize this email. Please contact our Guest Engagement team at guest@racetrac.com or 1-888-636-5589 to complete the process.\"]")
    @AndroidFindBy(id = "android:id/message")
    private MobileElement errorMessage;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Ok")
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;
}
