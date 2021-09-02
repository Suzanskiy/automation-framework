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
    private static final String DESCRIPTION_TEXT_WITH_NO_POINTS = "You have no points!";

    @PageLoading
    @iOSXCUITFindBy(accessibility = "IconSettings blue")
    @AndroidFindBy(accessibility = "Account Settings")
    private MobileElement iconSettings;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private MobileElement drawer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOG IN\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signInButtonHomeGuest")
    private MobileElement loginBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIGN UP\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/signUpButtonHomeGuest")
    private MobileElement signUpBtn;

    @PageLoading
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"VIP\"`]")
    @AndroidFindBy(accessibility = "VIP")
    private MobileElement vipSection;

    @iOSXCUITFindBy(accessibility = "HelpIcon")
    @AndroidFindBy(accessibility = "Help")
    private MobileElement heroLevelHelpBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_TEXT_WITH_NO_POINTS + "\")")
    @iOSXCUITFindBy(accessibility = DESCRIPTION_TEXT_WITH_NO_POINTS)
    private MobileElement descriptionTextWhenUserHasNoPoints;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Enter phone number\")]/../android.widget.ImageView[@resource-id=\"com.RaceTrac.Common.qa:id/imageGuestInfo\"]")
    private MobileElement rewardsSectionScreenForUserWithoutPoints;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsPoints")
    private MobileElement availablePoints;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM POINTS\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemPointsBtn")
    private MobileElement redeemPointsBtn;
}