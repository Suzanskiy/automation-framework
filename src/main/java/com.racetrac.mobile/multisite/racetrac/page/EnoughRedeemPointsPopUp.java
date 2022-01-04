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
public class EnoughRedeemPointsPopUp extends BaseMobilePage {

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/button_redeem")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[@name=\"REDEEM\"]")
    private WebElement redeemPopupBtn;

}
