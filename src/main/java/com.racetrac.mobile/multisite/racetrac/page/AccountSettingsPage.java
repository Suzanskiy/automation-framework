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
public class AccountSettingsPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.close")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
    private MobileElement navBarCloseBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
    private MobileElement title;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Location Services\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Location Services\")")
    private MobileElement locationSwitch;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"General\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"General\")")
    private MobileElement generalCategory;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "RaceTrac App Intro")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"RaceTrac App Intro\")")
    private MobileElement racetracAppIntro;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Help")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Help\")")
    private MobileElement helpCategory;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Terms & Privacy")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms & Privacy\")")
    private MobileElement termsAndPrivacy;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Accessibility")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Accessibility\")")
    private MobileElement accessibility;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN OUT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sign_out_button")
    private MobileElement signOutBtn;
}