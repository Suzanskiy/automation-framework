package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PayWithAddedGiftCardPage extends BaseMobilePage {

  @PageLoading
  @iOSXCUITFindBy(accessibility = "Pay")
  private WebElement root;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '$')]")
  private WebElement moneyAmount;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ADD CARD\"]")
  private WebElement addCard;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BUY NEW\"]")
  private WebElement buyNew;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RELOAD\"]")
  private WebElement reloadCard;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PAY\"]")
  private WebElement payBtn;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypePageIndicator")
  private WebElement pageIndicator;
}
