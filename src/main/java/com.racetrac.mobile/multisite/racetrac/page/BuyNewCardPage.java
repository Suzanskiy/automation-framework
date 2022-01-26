package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BuyNewCardPage extends BaseMobilePage {
  @PageLoading
  @iOSXCUITFindBy(accessibility = "Buy New Card")
  private WebElement root;

  @PageLoading
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
  private WebElement firstNameOnCard;

  @PageLoading
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
  private WebElement lastNameOnCard;

  @PageLoading
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
  private WebElement cardNumber;

  @PageLoading
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
  private WebElement monthYear;

  @PageLoading
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
  private WebElement securityCode;

  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[6]")
  private WebElement adress;

  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[7]")
  private WebElement city;

  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[8]")
  private WebElement state;

  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[9]")
  private WebElement zipCode;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DONE\"]")
  private WebElement doneBtn;
}
