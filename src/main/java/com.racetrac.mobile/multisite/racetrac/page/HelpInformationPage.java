package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HelpInformationPage extends BaseMobilePage{
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
    private MobileElement backBtn;

    @PageLoading
    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"App FAQ's\")")
    private MobileElement applicationFAQ;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
    private MobileElement pageTitle;

    @AndroidFindBy(xpath= "//android.widget.TextView[contains(@text,\"Contact\")]")
    private MobileElement contactUsLink;
}
