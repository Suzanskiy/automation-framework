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
public class UserNotFoundForGiftPopUpPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Ok")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    private WebElement okBtn;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"User not found\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeAlert[`label == \"User not found or user's account was created through a social network. You can only gift coupons to other RaceTrac Rewards members\"`]")
    private WebElement userNotFoundMessage;
}
