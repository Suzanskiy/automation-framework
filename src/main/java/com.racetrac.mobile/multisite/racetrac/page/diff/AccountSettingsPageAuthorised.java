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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Account\")")
    private MobileElement accountCategory;

    @iOSXCUITFindBy(accessibility = "Profile")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
    private MobileElement profile;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Promotional Settings\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promotional Settings\")")
    private MobileElement promotionalSettings;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notifications\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Notifications\")")
    private MobileElement notifications;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_section_item_image")
    private MobileElement settingsIcon;
}