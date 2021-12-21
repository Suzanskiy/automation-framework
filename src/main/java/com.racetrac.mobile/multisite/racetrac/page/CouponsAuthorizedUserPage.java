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
public class CouponsAuthorizedUserPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Gift It\" AND name == \"Gift It\" AND value == \"Gift It\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gift It\")")
    private MobileElement giftItBtn;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupons\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Coupons\"]")
    private MobileElement couponsTitle;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"COUPONS\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[10]")
    private MobileElement availableCoupon;

    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/gift_back_btn")
    @iOSXCUITFindBy(accessibility = "NavBarClose")
    private MobileElement backBtn;

}
