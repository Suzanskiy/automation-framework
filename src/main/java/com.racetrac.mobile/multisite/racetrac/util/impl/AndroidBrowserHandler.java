package com.racetrac.mobile.multisite.racetrac.util.impl;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Profile(ANDROID)
@Component
public class AndroidBrowserHandler extends BaseFlow implements ChromeBrowserHandler {

    public static final String WEBVIEW_CHROME = "WEBVIEW_chrome";
    public static final String NATIVE_APP = "NATIVE_APP";
    public static final String CHROME_APP_PACKAGE = "com.android.chrome";
    public static final String COM_RACE_TRAC_COMMON_QA = "com.RaceTrac.Common.qa";

    @Override
    public void prepareBrowser() throws IOException {
        Runtime.getRuntime().exec("adb shell pm clear " + CHROME_APP_PACKAGE);
        getDriver().activateApp(CHROME_APP_PACKAGE);

        try {
            getChromeAcceptTermsPage().waitUntilIsOpened();
            getChromeAcceptTermsPage().getTermsAcceptBtn().click();
            getTurnOnSyncNowPage().waitUntilIsOpened();
            getTurnOnSyncNowPage().getNoThanksBtn().click();
        } catch (TimeoutException e) {
            LOG.debug("Chrome not showed first run page. Its ok");
        }
    }

    @Override
    public String getUrl() throws InterruptedException {
        getChromeMainPage().waitUntilIsOpened();
        getDriver().context(WEBVIEW_CHROME);
        final String currentUrl = getDriver().getCurrentUrl();
        getDriver().context(NATIVE_APP);

        return currentUrl;
    }

    @Step
    @Override
    public void returnBackToApp() {
        getDriver().activateApp(COM_RACE_TRAC_COMMON_QA);
    }
}
