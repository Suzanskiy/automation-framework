package com.racetrac.mobile.multisite.racetrac.util.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.BrowserHandler;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;


@Profile(ANDROID)
@Component
public class ChromeBrowserHandler extends BaseFlow implements BrowserHandler {

  public static final String WEBVIEW_CHROME = "WEBVIEW_chrome";
  public static final String NATIVE_APP = "NATIVE_APP";
  public static final String CHROME_APP_PACKAGE = "com.android.chrome";
  public static final String COM_RACE_TRAC_COMMON_QA = "com.RaceTrac.Common.qa";
  public static final String ANDROID_FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION =
      "https://dep-www.racetrac.com/Rewards/RaceTrac-Rewards-Vip?utm_source=app&utm_medium=VIPtab&utm_campaign=vip";
  private static final String ANDROID_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION =
      "https://dep-www.racetrac.com/Rewards/RaceTrac-Rewards-Vip?utm_source=app&utm_medium=VIPtab&utm_campaign=vip";
  private static final String ANDROID_BECOME_A_VIP_LEARN_MORE_LINK =
      "https://dep-www.racetrac.com/Rewards/Purchase/FuelSubscription/10?utm_source=app&utm_medium=onboarding&utm_campaign=vip";
  private static final String ANDROID_BECOME_A_VIP_GET_STARTED_LINK =
      "https://dep-www.racetrac.com/Rewards/Purchase/FuelSubscription/10?utm_source=app&utm_medium=onboarding&utm_campaign=vip";
  private static final String RACE_TRAC_DOMAIN = "dep-www.racetrac.com";
  private static final String ANDROID_BECOME_A_VIP_URL_ENDPOINT =
      "/Rewards/Purchase/FuelSubscription/";
  private static final String ANDROID_BECOME_A_VIP_URL_PARAMETERS =
      "utm_source=app&utm_medium=onboarding&utm_campaign=vip";
  private static final String ANDROID_FUEL_VIP_URL_ENDPOINT =
          "/Rewards";
  private static final String ANDROID_FUEL_VIP_URL_PARAMETERS =
          "RaceTrac-Rewards-Vip&utm_source=app&utm_medium=VIPtab&utm_campaign=vip";
  private static final String ANDROID_FUEL_VIP_URL_FOR_UNAUTHORIZED_PARAMETERS =
          "/Account/VipMembership";

  @Override
  public void prepareBrowser() throws IOException {
    Runtime.getRuntime().exec("adb shell pm clear " + CHROME_APP_PACKAGE);
  }

  @Override
  public void handleBrowserOpening() {
    try {
      this.getChromeAcceptTermsPage().waitUntilIsOpened();
      this.getChromeAcceptTermsPage().getTermsAcceptBtn().click();
      this.getTurnOnSyncNowPage().waitUntilIsOpened();
      this.getTurnOnSyncNowPage().getNoThanksBtn().click();
    } catch (NoSuchElementException | TimeoutException var2) {
      LOG.debug("Chrome not showed first run page. Its ok");
    }
  }

  @Step
  @Override
  public String getUrl() {
    String newUrl = getChromeMainRaceTrackMoreInfoPage().getURLxpath().getText();
    if(newUrl.contains("accesstoken")) {
      String URLwithoutTokenStart = newUrl.substring(0, newUrl.indexOf("/rewards"));
      String URLwithoutTokenEnd = newUrl.substring(newUrl.indexOf("/Rewards"));
      URLwithoutTokenEnd = URLwithoutTokenEnd.replaceFirst("[?]", "&");
      return URLwithoutTokenStart + URLwithoutTokenEnd;
    }
    else {
      return newUrl;
    }
  }

  @Step
  @Override
  public void returnBackToApp() {
    // getDriver().activateApp(COM_RACE_TRAC_COMMON_QA);
  }

  @Override
  public String getDesiredRedirectUrlNoSubscription() {
    return ANDROID_FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION;
  }

  @Override
  public String getDesiredRedirectUrlActiveSubscription() {
    return ANDROID_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION;
  }

  @Override
  public String getLearnMoreRedirectUrl() {
    return ANDROID_BECOME_A_VIP_LEARN_MORE_LINK;
  }

  @Override
  public String getGetStartedRedirectUrl() {
    return ANDROID_BECOME_A_VIP_GET_STARTED_LINK;
  }

  @Override
  public String getRaceTracDomain() {
    return RACE_TRAC_DOMAIN;
  }

  @Override
  public String getBecomeAVipUrlEndpoint() {
    return ANDROID_BECOME_A_VIP_URL_ENDPOINT;
  }

  @Override
  public String getBecomeAVipUrlParameters() {
    return ANDROID_BECOME_A_VIP_URL_PARAMETERS;
  }

  @Override
  public String getVipUrlRewardsEndpoint() {
    return ANDROID_FUEL_VIP_URL_ENDPOINT;
  }

  @Override
  public String getVipUrlRewardsParameters() {
    return ANDROID_FUEL_VIP_URL_PARAMETERS;
  }

  @Override
  public String getVipUrlRewardsUnauthorizedEndpointAdditionPart() {
    return ANDROID_FUEL_VIP_URL_FOR_UNAUTHORIZED_PARAMETERS;
  }

}
