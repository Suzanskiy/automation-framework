package com.racetrac.mobile.multisite.racetrac.util.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Profile(IOS)
@Component
public class iOSBrowserHandler extends BaseFlow implements ChromeBrowserHandler {

    public static final String FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION = "https://dep-www.racetrac.com/Rewards/RaceTrac-Rewards-Vip?utm_source=app&utm_campaign=vip&utm_medium=VIPtab";
    private static final String IOS_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION = "https://dep-www.racetrac.com/Rewards/Account/VipMembership?utm_source=app&utm_campaign=vip";
    public static final String BUNDLE_ID = "com.racetrac.QA.ams";
    public static final String IOS_LEARN_MORE_REDIRECT_URL = "https://dep-www.racetrac.com/Rewards/RaceTrac-Rewards-Vip?utm_source=app&utm_campaign=vip&utm_medium=onboarding";
    public static final String HTTPS_DEP_WWW_RACETRAC_COM_REWARDS_PURCHASE_FUEL_SUBSCRIPTION_14_UTM_SOURCE_APP_UTM_CAMPAIGN_VIP_UTM_MEDIUM_ONBOARDING = "https://dep-www.racetrac.com/Rewards/Purchase/FuelSubscription/14?utm_source=app&utm_campaign=vip&utm_medium=onboarding";
    private static final String IOS_RACE_TRAC_DOMAIN = "dep-www.racetrac.com";
    private static final String IOS_BECOME_A_VIP_URL_ENDPOINT = "/Rewards/Purchase/FuelSubscription/";
    private static final String IOS_BECOME_A_VIP_URL_PARAMETERS = "utm_source=app&utm_medium=onboarding&utm_campaign=vip";


    @Override
    public void prepareBrowser() throws IOException {
        LOG.debug("Not needed in iOS");
    }

    @Step
    @Override
    public String getUrl() {
        getSafariBrowserPage().waitUntilIsOpened();
        getSafariBrowserPage().getUrl().click();
        getSafariBrowserPage().getUrl().sendKeys(Keys.ENTER);
        getSafariBrowserPage().refresh();
        getSafariBrowserPage().waitUntilIsOpened();
        getSafariBrowserPage().getUrl().click();
        return getSafariBrowserPage().getUrl().getAttribute("value");
    }

    @Step
    @Override
    public void returnBackToApp() {
        getDriver().activateApp(BUNDLE_ID);
    }

    @Override
    public String getDesiredRedirectUrlNoSubscription() {
        return FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION;
    }

    @Override
    public String getDesiredRedirectUrlActiveSubscription() {
        return IOS_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION;
    }

    @Override
    public String getLearnMoreRedirectUrl() {
        return IOS_LEARN_MORE_REDIRECT_URL;
    }

    @Override
    public String getGetStartedRedirectUrl() {
        return HTTPS_DEP_WWW_RACETRAC_COM_REWARDS_PURCHASE_FUEL_SUBSCRIPTION_14_UTM_SOURCE_APP_UTM_CAMPAIGN_VIP_UTM_MEDIUM_ONBOARDING;
    }
    public String getRaceTracDomain(){
        return IOS_RACE_TRAC_DOMAIN;
    }
    @Override
    public String getBecomeAVipUrlEndpoint() {
        return IOS_BECOME_A_VIP_URL_ENDPOINT;
    }
    @Override
    public String getBecomeAVipUrlParameters() {
        return IOS_BECOME_A_VIP_URL_PARAMETERS;
    }
}
