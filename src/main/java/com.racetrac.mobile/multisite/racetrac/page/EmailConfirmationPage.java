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
public class EmailConfirmationPage extends BaseMobilePage {

    @PageLoading
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"GO TO EMAIL\"]")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/goToEmailBtn")
    private MobileElement gotoEmailBtn;

    @iOSXCUITFindBy(accessibility = "Try again")
    @AndroidFindBy(id = "com.RaceTrac.Common.qa:id/emailWrong")
    private MobileElement retryEmailBtn;
}