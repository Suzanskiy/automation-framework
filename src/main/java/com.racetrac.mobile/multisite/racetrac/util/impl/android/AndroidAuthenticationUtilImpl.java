package com.racetrac.mobile.multisite.racetrac.util.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.AuthenticationUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Profile(ANDROID)
@Component
public class AndroidAuthenticationUtilImpl extends BaseFlow implements AuthenticationUtil {
    private static final String RACETRAC_APP_PACKAGE = "com.RaceTrac.Common.qa";

    @Override
    public void prepareAppAfterBrokenSignOut() {
        try {
            Runtime.getRuntime().exec("adb shell pm clear " + RACETRAC_APP_PACKAGE);
            getDriver().launchApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}