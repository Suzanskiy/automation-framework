package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CouponsView extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Coupons are already added to your rewards card. Simply scan card at checkout.")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsTutorialMessage")
    private WebElement root;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GOT IT\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardsTutorialGotItButton")
    private WebElement gotItBtn;
}
