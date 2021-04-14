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
public class InboxPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Inbox\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.dev:id/textViewCardViewTitle")
    private MobileElement header;

    @AndroidFindBy(id = "com.RaceTrac.Common.dev:id/imageGuestInfo")
    private MobileElement image;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOG IN\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.dev:id/signInButton")
    private MobileElement loginBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.dev:id/signUpButton")
    private MobileElement singUpBtn;
}
