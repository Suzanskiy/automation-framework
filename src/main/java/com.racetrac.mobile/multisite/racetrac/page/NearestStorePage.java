package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter

public class NearestStorePage extends BaseMobilePage {
  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_detail_store_name")
  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeButton[@name=\"NavBarBack\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement storeName;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_item_row_container")
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeButton[@name=\"DirectionIcon\"]/preceding-sibling::XCUIElementTypeStaticText")
  private WebElement cityAndDistance;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/store_phone_num")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"MobileIcon\"]/preceding-sibling::XCUIElementTypeStaticText")
  private WebElement telephoneNumber;
}
