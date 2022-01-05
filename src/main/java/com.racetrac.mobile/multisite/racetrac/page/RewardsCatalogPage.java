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
public class RewardsCatalogPage extends BaseMobilePage {

  @PageLoading
  @iOSXCUITFindBy(accessibility = "NavBarClose")
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reward_catalog_back_btn")
  private WebElement closeBtn;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeStaticText[@name=\"UAT - 10c gal Reward\"]/following-sibling::XCUIElementTypeButton")
  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[contains(@text,\"10c gal\")]/following-sibling::android.widget.Button")
  private WebElement redeemBtn;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/button_redeem")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REDEEM\"]")
  private WebElement redeemPopupBtn;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/unclaimedRewardsLabel")
  @iOSXCUITFindBy(accessibility = "Unclaimed Rewards")
  private WebElement unclaimedRewardsLabel;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/unclaimedRewardsCounter")
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
  private WebElement unclaimedRewardsCounter;

  @iOSXCUITFindBy(
      xpath =
          "//XCUIElementTypeApplication[@name=\"RaceTrac QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/memberPoints")
  private WebElement rewardsCatalogNumberOfPoints;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/reward_catalog_back_btn")
  private WebElement rewardsCatalogBackBtn;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/availablePointsDesc")
  private WebElement availablePointsDesc;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/sortCaret")
  private WebElement sortCaret;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardImage")
  private WebElement rewardImage;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/rewardName")
  private WebElement rewardName;

  @AndroidFindBy(
      xpath =
          "//android.widget.TextView[contains(@text,\"gal\")]/following-sibling::android.widget.TextView[@resource-id=\"com.RaceTrac.Common.qa:id/rewardPoints\"]")
  @iOSXCUITFindBy(
      xpath = "//XCUIElementTypeButton[@name=\"REDEEM\"]/../\t\n" + "XCUIElementTypeStaticText[2]")
  private WebElement rewardPoints;
}
