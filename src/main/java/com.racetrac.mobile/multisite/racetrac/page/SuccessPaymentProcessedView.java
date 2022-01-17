package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SuccessPaymentProcessedView extends BaseMobilePage {
  @PageLoading
  @iOSXCUITFindBy(accessibility = "Complete")
  private WebElement root;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
  private WebElement okBtn;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Success!')]")
  private WebElement text;
}
