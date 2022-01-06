package com.racetrac.mobile.multisite.racetrac.util;

import java.io.IOException;

public interface BrowserHandler {

  void prepareBrowser() throws IOException;

  void handleBrowserOpening();

  String getUrl() throws InterruptedException;

  void returnBackToApp();

  String getDesiredRedirectUrlNoSubscription();

  String getDesiredRedirectUrlActiveSubscription();

  String getLearnMoreRedirectUrl();

  String getGetStartedRedirectUrl();

  String getRaceTracDomain();

  String getBecomeAVipUrlEndpoint();

  String getBecomeAVipUrlParameters();
}
