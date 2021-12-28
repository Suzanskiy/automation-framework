package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RewardsCheckoutBarcodePage extends RewardsCheckoutPage {
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/image_barcode")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeImage")
  private WebElement barcode;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewards_number")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'My Rewards')]")
  private WebElement rewardsNumber;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_unclaimed_count")
  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeOther[3]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
  private WebElement unclaimedRewardsCounter;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkout_pay")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PAY\"]")
  private WebElement payBtn;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/checkout_done")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DONE\"]")
  private WebElement doneBtn;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/user_name")
  private WebElement userName;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/user_email")
  private WebElement userEmail;
}
