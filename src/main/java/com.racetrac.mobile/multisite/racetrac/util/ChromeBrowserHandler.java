package com.racetrac.mobile.multisite.racetrac.util;

import java.io.IOException;

public interface ChromeBrowserHandler {

    void prepareBrowser() throws IOException;

    String getUrl() throws InterruptedException;

    void returnBackToApp();

    String getDesiredRedirectUrlNoSubscription();

    String getDesiredRedirectUrlActiveSubscription();

    String getLearnMoreRedirectUrl();

    String getGetStartedRedirectUrl();

}
