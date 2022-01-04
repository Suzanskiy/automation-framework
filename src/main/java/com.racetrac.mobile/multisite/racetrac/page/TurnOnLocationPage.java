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
public class TurnOnLocationPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/continueButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUE\"`]")
    private WebElement continueBtn; // continue btn on ios

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/turnOnButton")
    private WebElement turnOnBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement whileUsingAppBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private WebElement onlyThisTimeBtn;
}