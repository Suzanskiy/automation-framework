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
public class CouponsAuthorizedUserPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Gift It\" AND name == \"Gift It\" AND value == \"Gift It\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gift It\")")
    private WebElement giftItBtn;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupons\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Coupons\"]")
    private WebElement couponsTitle;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"COUPONS\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[10]")
    private WebElement availableCoupon;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/gift_back_btn")
    @iOSXCUITFindBy(accessibility = "NavBarClose")
    private WebElement backBtn;

}
