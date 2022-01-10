package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FacebookAuthFlow;
import com.racetrac.mobile.util.device.AlertUtil;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;

@Profile(IOS)
@Component
public class iosFacebookAuthFlowImpl extends BaseFlow implements FacebookAuthFlow {

  @Override
  public void authorise(final CustomerDto customerDto) {
    AlertUtil.acceptAlert();
    getFacebookLoginPage().waitUntilIsOpened();
    getFacebookLoginPage().getEmailInput().clear();
    getFacebookLoginPage().getEmailInput().sendKeys(customerDto.getPersonalInfo().getEmail());
    getFacebookLoginPage().getPassInput().sendKeys(customerDto.getEmailAuth().getPassword());
    getFacebookLoginPage().getLoginBtn().click();
    getFacebookLoginStep2Page().waitUntilIsOpened();
    getFacebookLoginStep2Page().getContinueBtn().click();
  }

  @Step
  @Override
  public void singInToFacebook() {
    clickContinueBtn();
  }

  private void clickContinueBtn() {
    AlertUtil.acceptAlert();
    getFacebookLoginStep2Page().waitUntilIsOpened();
    waitUntilElementClickable(getFacebookLoginStep2Page().getContinueBtn());
    getFacebookLoginStep2Page().getContinueBtn().click();
  }
}
