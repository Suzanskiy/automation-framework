package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.HelpInformationFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.SwipeScroll.tapByCoordinates;

@Profile(ANDROID)
@Component
public class AndroidHelpInformationFlowImpl extends BaseFlow implements HelpInformationFlow {
  @Step
  @Override
  public boolean isHelpInformationPageOpened() {
    AppiumWaitingUtils.waitUntilElementClickable(getHelpInformationPage().getBackBtn());
    return getHelpInformationPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void navigateToContactUs() {
    tapByCoordinates(
        getHelpInformationPage().getContactUsLink().getRect().width * 2 - 30,//right shift to link
        getHelpInformationPage().getContactUsLink().getRect().y);
  }

  @Step
  @Override
  public boolean isContactUsDisplayed() {
    try {
      return getHelpInformationPage().getContactUsLink().isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
