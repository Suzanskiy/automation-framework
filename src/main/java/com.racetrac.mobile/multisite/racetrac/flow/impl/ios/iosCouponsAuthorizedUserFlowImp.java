package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.CouponsAuthorizedUserFlow;
import com.racetrac.mobile.util.appium.SwipeScroll;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.SwipeScroll.Direction.UP;
import static com.racetrac.mobile.util.appium.SwipeScroll.swipeToElement;

@Profile(IOS)
@Component
public class iosCouponsAuthorizedUserFlowImp extends BaseFlow implements CouponsAuthorizedUserFlow {

  @Step
  @Override
  public boolean isCouponsPageAuthorizedUserOpen() {
    return getCouponsAuthorizedUserPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void clickOnGiftItBtn() {
    swipeToElement(UP, getHomePage().getGiftToAFriendBtn() );
    getHomePage().getGiftToAFriendBtn().click();
  }

  @Step
  @Override
  public void selectAvailableCoupon() {
    getCouponsAuthorizedUserPage().getAvailableCoupon().click();
  }

  @Step
  @Override
  public void pressBackBtn() {
    getCouponsAuthorizedUserPage().getBackBtn().click();
  }
}
