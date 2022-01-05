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
public class UpgradeRewardCardPage extends BaseMobilePage {
  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_image")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Upgrade Your Rewards Card & Save\"]")
  private WebElement upgradeRewardCardImage;

  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgrade_rewards_title")
  private WebElement addCardBtn;

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UPGRADE YOUR CARD\"]")
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/upgradeRewardsCardBtn")
  private WebElement upgradeyourCardButton;
}
