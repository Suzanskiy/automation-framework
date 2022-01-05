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
public class OrderRewardCardPage extends BaseMobilePage {

  @PageLoading
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rewards Card Upgrade\"]")
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/tv_title_rewards_card_upgrade")
  private WebElement root;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_FirstName']")
  private WebElement firstname;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_LastName']")
  private WebElement lastName;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='EmailAddress']")
  private WebElement EmailAddress;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Data_Phone']")
  private WebElement DataPhone;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='Birthday']")
  private WebElement Birthday;

  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
  private WebElement ContinueButton;

  @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CANCEL\"]")
  private WebElement cancelBtn;
}
