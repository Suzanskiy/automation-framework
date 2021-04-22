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
public class HomePage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "IconSettings blue")
    @AndroidFindBy(accessibility = "Account Settings")
    private MobileElement iconSettings;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private MobileElement drawer;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOG IN\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signInButtonHomeGuest")
    private MobileElement loginBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signUpButtonHomeGuest")
    private MobileElement signUpBtn;
}