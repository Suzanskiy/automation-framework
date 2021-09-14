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
public class CouponsPopUpPage extends BaseMobilePage {

    private static final String DESCRIPTION_COUPONS_POP_UP_MESSAGE = "All coupons are already added to your\n" +
            "rewards card. Simply scan card at\n" +
            "checkout.";

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GOT IT\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"GOT IT\")")
    private MobileElement gotItBtn;

    @PageLoading
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupons\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Coupons\"]")
    private MobileElement couponsTitle;

    @PageLoading
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + DESCRIPTION_COUPONS_POP_UP_MESSAGE + "\")")
    @iOSXCUITFindBy(accessibility = "All coupons are already added to your rewards card. Simply scan card at checkout.")
    private MobileElement CouponsTutorialMessage;
}
