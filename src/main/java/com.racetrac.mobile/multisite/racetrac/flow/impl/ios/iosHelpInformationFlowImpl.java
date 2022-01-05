package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.HelpInformationFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosHelpInformationFlowImpl extends BaseFlow implements HelpInformationFlow {
  @Step
  @Override
  public boolean isHelpInformationPageOpened() {
    return getHelpInformationPage().waitUntilIsOpened();
  }

  @Step
  @Override
  public void navigateToContactUs() {
    getHelpInformationPage().getContactUsLink().click();
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
