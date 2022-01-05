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
public class HelpInformationPage extends BaseMobilePage {
  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
  @iOSXCUITFindBy(accessibility = "NavBarBack")
  private WebElement backBtn;

  @PageLoading
  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"App FAQ's\")")
  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"App FAQ's\"])[1]")
  private WebElement applicationFAQ;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
  @iOSXCUITFindBy(xpath = "\t\n" + "(//XCUIElementTypeStaticText[@name=\"Help\"])[2]")
  private WebElement pageTitle;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Contact\")]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Still need help? Contact Us\"]")
  private WebElement contactUsLink;
}
