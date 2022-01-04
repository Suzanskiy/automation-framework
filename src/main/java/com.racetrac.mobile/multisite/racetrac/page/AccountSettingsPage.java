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
public class AccountSettingsPage extends BaseMobilePage {
    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.close")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
    private WebElement navBarCloseBtn;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "text.title")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
    private WebElement title;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Location Services\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Location Services\")")
    private WebElement locationSwitch;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"General\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"General\")")
    private WebElement generalCategory;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "RaceTrac App Intro")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"RaceTrac App Intro\")")
    private WebElement racetracAppIntro;

    @iOSXCUITFindBy(accessibility = "Help")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Help\")")
    private WebElement helpCategory;

    @iOSXCUITFindBy(accessibility = "Terms & Privacy")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms & Privacy\")")
    private WebElement termsAndPrivacy;

    @iOSXCUITFindBy(accessibility = "Accessibility")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Accessibility\")")
    private WebElement accessibility;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN OUT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signOutButton")
    private WebElement signOutBtn;
}