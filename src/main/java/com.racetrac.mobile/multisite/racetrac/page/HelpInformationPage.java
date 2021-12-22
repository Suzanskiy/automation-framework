package com.racetrac.mobile.multisite.racetrac.page;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HelpInformationPage extends BaseMobilePage{
    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_close_btn")
    private WebElement backBtn;

    @PageLoading
    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"App FAQ's\")")
    private WebElement applicationFAQ;

    @PageLoading
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/account_title")
    private WebElement pageTitle;

    @AndroidFindBy(xpath= "//android.widget.TextView[contains(@text,\"Contact\")]")
    private WebElement contactUsLink;
}
