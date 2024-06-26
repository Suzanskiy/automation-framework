package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCheckoutBarcodeFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeRight;

@Profile(IOS)
@Component
public class iosRewardsCheckoutBarcodeBarcodeFlowImpl extends BaseFlow
    implements RewardsCheckoutBarcodeFlow {

  @Step
  @Override
  public boolean isRewardsCheckoutBarcodePageOpened() {
    return getRewardsCheckoutBarcodePage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void closeRewardsCheckoutPage() {
    getRewardsCheckoutBarcodePage().getCloseCheckoutPageBtn().click();
  }

  @Step
  @Override
  public int getUnclaimedRewardsCounter() {
    return Integer.parseInt(
        getRewardsCheckoutBarcodePage().getUnclaimedRewardsCounter().getAttribute("value"));
  }

  @Step
  @Override
  public void clickOnDoneBtn() {
    getRewardsCheckoutBarcodePage().getDoneBtn().click();
  }

  @Override
  public void goToUnclaimedRewardsPage() {
    swipeRight();
  }
}
