package com.racetrac.mobile.multisite.racetrac.util.impl;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import com.racetrac.mobile.util.appium.Action;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilIsTrue;

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
    }

    @Step
    @Override
    public String getUrl() {
        waitUntilIsTrue(getDriverWaitContextAction());
        getDriver().context(WEBVIEW_CHROME);
        final String currentUrl = getDriver().getCurrentUrl();
        getDriver().context(NATIVE_APP);

        return currentUrl;
    }

    private Action<Boolean> getDriverWaitContextAction() {
        Action<Boolean> checkBrowserContextAction;
        checkBrowserContextAction = () -> {
            Set<String> context;
            do {
                context = getDriver().getContextHandles();
            } while (!context.contains(WEBVIEW_CHROME));
            return true;
        };
        return checkBrowserContextAction;
    }

    @Step
    @Override
    public void returnBackToApp() {
        getDriver().activateApp(COM_RACE_TRAC_COMMON_QA);
    }
}
