package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CheckoutBtnView extends BaseMobilePage {

  @PageLoading
  @iOSXCUITFindBy(xpath = "//..//XCUIElementTypeStaticText[@name=\"Checkout\"]")
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkoutButton")
  private WebElement checkoutBtn;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkoutCounter")
  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton/XCUIElementTypeStaticText[1]")
  private WebElement checkoutCounter;
}
