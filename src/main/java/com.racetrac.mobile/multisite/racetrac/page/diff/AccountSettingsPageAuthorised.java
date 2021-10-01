package com.racetrac.mobile.multisite.racetrac.page.diff;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.racetrac.page.AccountSettingsPage;
import io.appium.java_client.MobileElement;
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
    private MobileElement navBarCloseBtn;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Account\")")
    private MobileElement accountCategory;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Profile")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
    private MobileElement profile;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Rewards + Debit Card")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Rewards + Debit Card\")")
    private MobileElement rewardsAndDebitCard;

    @iOSXCUITFindBy(accessibility = "Purchase History")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Purchase History\")")
    private MobileElement purchaseHistory;

    @iOSXCUITFindBy(accessibility = "Promo Codes")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promo Code\")")
    private MobileElement promoCodes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Preferences\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Preferences\")")
    private MobileElement preferencesCategory;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Promotional Settings\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promotional Settings\")")
    private MobileElement promotionalSettings;

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notifications\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Notifications\")")
    private MobileElement notifications;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Receive Emails?\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Receive Emails?\"]/../android.widget.Switch[@resource-id=\"com.RaceTrac.Common.qa:id/account_section_item_switch\"]")
    private MobileElement receiveEmailsSwitchBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_section_item_image")
    private MobileElement settingsIcon;

}