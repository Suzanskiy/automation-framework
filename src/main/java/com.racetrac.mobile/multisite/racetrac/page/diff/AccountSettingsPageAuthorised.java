package com.racetrac.mobile.multisite.racetrac.page.diff;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.racetrac.page.AccountSettingsPage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AccountSettingsPageAuthorised extends AccountSettingsPage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "button.close")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
    private WebElement navBarCloseBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Account\")")
    private WebElement accountCategory;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Profile")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
    private WebElement profile;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Rewards + Debit Card")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Rewards + Debit Card\")")
    private WebElement rewardsAndDebitCard;

    @iOSXCUITFindBy(accessibility = "Purchase History")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Purchase History\")")
    private WebElement purchaseHistory;

    @iOSXCUITFindBy(accessibility = "Promo Codes")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promo Code\")")
    private WebElement promoCodes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Preferences\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Preferences\")")
    private WebElement preferencesCategory;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Promotional Settings\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promotional Settings\")")
    private WebElement promotionalSettings;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notifications\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Notifications\")")
    private WebElement notifications;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Receive Emails?\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Receive Emails?\"]/../android.widget.Switch[@resource-id=\"com.RaceTrac.Common.qa:id/account_section_item_switch\"]")
    private WebElement receiveEmailsSwitchBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_section_item_image")
    private WebElement settingsIcon;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/availablePointsValue")
    private WebElement availablePointsValue;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/lifetimePointsValue")
    private WebElement lifetimePointsValue;

}