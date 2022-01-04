package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class InboxPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Inbox\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/textViewCardViewTitle")
    private WebElement header;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/imageGuestInfo")
    private WebElement image;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOG IN\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signInButton")
    private WebElement loginBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signUpButton")
    private WebElement singUpBtn;
}
