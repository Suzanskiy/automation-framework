package com.racetrac.mobile.multisite.racetrac.views;

import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.multisite.BaseMobilePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NoPointsNotice extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(accessibility = "Sorry, you don't have enough points.")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Sorry\")]")
    private WebElement subtitleRewardsCatalog;

    @PageLoading
    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/buttonOK")
    private WebElement okButtonRewardCatalog;

}
