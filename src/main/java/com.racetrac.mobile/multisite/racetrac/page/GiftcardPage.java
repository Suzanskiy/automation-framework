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

public class GiftcardPage extends BaseMobilePage {
    @PageLoading
    @AndroidFindBy(accessibility = "No Gift Cards")
    @iOSXCUITFindBy(accessibility = "Pay")
    private WebElement noGiftCardImage;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardNewBtnNoCards")
  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"BUY NEW\"])[2]")
  private WebElement buyNewBtn;

  @PageLoading
  @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/giftCardAddBtnNoCards")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ADD GIFT CARD\"]")
  private WebElement addGiftCardBtn;
}
