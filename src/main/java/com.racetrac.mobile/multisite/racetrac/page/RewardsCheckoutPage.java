package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public abstract class RewardsCheckoutPage extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Checkout\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Checkout\"])[2]")
    private WebElement pageTitle;

    @PageLoading
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Scan barcode\")]")
    @iOSXCUITFindBy(accessibility = "Scan barcode before paying to earn points.")
    private WebElement checkoutSubtitle;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "NavBarCloseWhite")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/bt_checkout_back")
    private WebElement closeCheckoutPageBtn;

}
