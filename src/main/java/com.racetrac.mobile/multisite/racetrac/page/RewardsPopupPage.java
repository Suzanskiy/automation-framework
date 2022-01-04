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
public class RewardsPopupPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GOT IT\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"GOT IT\")")
    private WebElement gotItBtn;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/redeemButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM\"]")
    private WebElement redeemBtn;

    @AndroidFindBy(id ="com.RaceTrac.Common.qa:id/rewardsTutorialArrow")
    @iOSXCUITFindBy(accessibility = "RewardsLine")
    private WebElement tutorialPopUpArrow;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Tap Redeem to add\")]")
    @iOSXCUITFindBy(accessibility = "Tap Redeem to add a reward to your loyalty card. Rewards expire in 24 hours and points are returned for unused rewards.")
    private WebElement rewardsPopUpTutorialMessage;

}